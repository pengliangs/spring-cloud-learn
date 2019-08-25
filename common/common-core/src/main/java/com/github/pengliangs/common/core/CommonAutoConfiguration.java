package com.github.pengliangs.common.core;

import com.github.pengliangs.common.core.properties.CommonProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengliang
 * @date 2019/8/25 18:25
 */
@Configuration
@EnableConfigurationProperties(CommonProperties.class)
public class CommonAutoConfiguration {

}
