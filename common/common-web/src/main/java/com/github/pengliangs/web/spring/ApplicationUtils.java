package com.github.pengliangs.web.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Spring Application 工具类
 *
 * @author Caratacus
 */
public class ApplicationUtils {

    /**
     * 全局的ApplicationContext
     */
    private final static ApplicationContext APPLICATION_CONTEXT = ApplicationContextRegister.getApplicationContext();

    /**
     * 获取ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取springbean
     *
     * @param beanName
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> requiredType) {
        if (containsBean(beanName)) {
            return APPLICATION_CONTEXT.getBean(beanName, requiredType);
        }
        return null;
    }

    /**
     * 获取springbean
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }

    /**
     * 获取springbean
     *
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName) {
        if (containsBean(beanName)) {
            Class<T> type = getType(beanName);
            return APPLICATION_CONTEXT.getBean(beanName, type);
        }
        return null;
    }

    /**
     * 依赖spring框架获取HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = null;
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (Objects.nonNull(requestAttributes)) {
                request = requestAttributes.getRequest();
            }
        } catch (Exception ignored) {
        }
        return request;
    }

    /**
     * ApplicationContext是否包含该Bean
     *
     * @param name
     * @return
     */
    public static boolean containsBean(String name) {
        return APPLICATION_CONTEXT.containsBean(name);
    }

    /**
     * ApplicationContext该Bean是否为单例
     *
     * @param name
     * @return
     */
    public static boolean isSingleton(String name) {
        return APPLICATION_CONTEXT.isSingleton(name);
    }

    /**
     * 获取该Bean的Class
     *
     * @param name
     * @return
     */
    public static <T> Class<T> getType(String name) {
        return (Class<T>) APPLICATION_CONTEXT.getType(name);
    }

}
