package com.github.pengliangs.web.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * spring上下文
 *
 * @author pengliang
 * @date 2019/8/27 17:35
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    /**
     * 上下文对象
     */
    private static ApplicationContext APPLICATION_CONTEXT;

    static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * 设置spring上下文
     *
     * @param applicationContext spring上下文
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (Objects.isNull(APPLICATION_CONTEXT)){
            APPLICATION_CONTEXT = applicationContext;
        }
    }
}
