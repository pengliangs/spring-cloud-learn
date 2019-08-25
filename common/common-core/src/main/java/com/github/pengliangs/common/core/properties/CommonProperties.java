package com.github.pengliangs.common.core.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author pengliang
 * @date 2019/8/25 18:26
 */
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@ConfigurationProperties("common")
public class CommonProperties {
}
