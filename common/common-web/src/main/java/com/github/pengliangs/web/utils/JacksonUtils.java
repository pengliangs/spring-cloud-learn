package com.github.pengliangs.web.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.github.pengliangs.common.core.exception.ConvertException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Jackson 工具类
 *
 * @author Caratacus
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JacksonUtils {

    private final static ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = initObjectMapper(new ObjectMapper());
    }

    /**
     * 转换Json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (isCharSequence(object)) {
            return (String) object;
        }
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ConvertException(e);
        }
    }

    /**
     * 获取ObjectMapper
     *
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * 初始化 ObjectMapper
     *
     * @param objectMapper
     * @return
     */
    public static ObjectMapper initObjectMapper(ObjectMapper objectMapper) {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
        }
        return doInitObjectMapper(objectMapper);
    }

    /**
     * 初始化 ObjectMapper 时间方法
     *
     * @param objectMapper
     * @return
     */
    private static ObjectMapper doInitObjectMapper(ObjectMapper objectMapper) {
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //不显示为null的字段
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 忽略不能转移的字符
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        // 过滤对象的null属性.
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略transient
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        return registerModule(objectMapper);
    }

    /**
     * 注册模块
     *
     * @param objectMapper
     * @return
     */
    private static ObjectMapper registerModule(ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        simpleModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }


    /**
     * 包装 MappingJackson2HttpMessageConverter
     *
     * @return
     */
    public static Consumer<HttpMessageConverter<?>> wrapperObjectMapper() {
        return converter -> {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter httpMessageConverter = (MappingJackson2HttpMessageConverter) converter;
                registerModule(httpMessageConverter.getObjectMapper());
            }
        };
    }

    /**
     * <p>
     * 是否为CharSequence类型
     * </p>
     *
     * @param object
     * @return
     */
    public static Boolean isCharSequence(Object object) {
        return !Objects.isNull(object) && StringUtils.isCharSequence(object.getClass());
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json
     * @return
     */
    public static Object parse(String json) {
        Object object = null;
        try {
            object = getObjectMapper().readValue(json, Object.class);
        } catch (Exception ignored) {
            log.error(ignored.getMessage());
        }
        return object;
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        T t = null;
        try {
            t = getObjectMapper().readValue(json, clazz);
        } catch (Exception ignored) {
            log.error(ignored.getMessage());
        }
        return t;
    }

    /**
     * 将转换成功后的对象通过consumer消费
     *
     * @param json
     * @param clazz
     * @param successConsumer
     * @param <T>
     */
    public static <T> void readValue(String json, Class<T> clazz, Consumer<T> successConsumer) {
        if (StringUtils.isEmpty(json)) {
            log.warn("param [json] is empty");
            return;
        }
        T t = readValue(json, clazz);
        if (Objects.nonNull(t)) {
            successConsumer.accept(t);
        }
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public static <T> T readValue(String json, TypeReference valueTypeRef) {
        T t = null;
        try {
            t = getObjectMapper().readValue(json, valueTypeRef);
        } catch (Exception ignored) {
            log.error(ignored.getMessage());
        }
        return t;
    }


}