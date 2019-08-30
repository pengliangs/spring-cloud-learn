package com.github.pengliangs.common.core;

import com.github.pengliangs.common.core.properties.CommonProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author pengliang
 * @date 2019/8/25 18:25
 */
@Configuration
@EnableConfigurationProperties(CommonProperties.class)
@Import({MyBatisPlusConfiguration.class})
public class CommonAutoConfiguration {


}
