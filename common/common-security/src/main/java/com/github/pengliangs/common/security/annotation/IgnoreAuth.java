package com.github.pengliangs.common.security.annotation;

import java.lang.annotation.*;

/**
 * 标注此注解的服务不进行鉴权
 * @author pengliang on 2019/10/20 21:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

	boolean value() default true;

}
