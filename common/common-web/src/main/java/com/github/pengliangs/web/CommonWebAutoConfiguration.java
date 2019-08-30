package com.github.pengliangs.web;

import com.github.pengliangs.web.spring.ApplicationContextRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * web公共模块
 *
 * @author pengliang
 * @date 2019/8/30 16:34
 */
@Configuration
@Import(ApplicationContextRegister.class)
public class CommonWebAutoConfiguration {
}
