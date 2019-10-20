package com.github.pengliangs.common.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.pengliangs.common.core.response.ResultData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 登录发生异常时
 * @author pengliang on 2018-08-06 10:06
 */
@Slf4j
public class CustomOauth2ExceptionSerializer extends StdSerializer<CustomOauth2Exception> {

    protected CustomOauth2ExceptionSerializer() {
        super(CustomOauth2Exception.class);
    }

    @Override
    public void serialize(CustomOauth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
       log.info("异常OaOauth2ExceptionSerializer：{}",value.getMessage());
        gen.writeObject(ResultData.failure(value.getHttpErrorCode(),value.getMessage()));
    }
}
