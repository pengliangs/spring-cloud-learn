package com.github.pengliangs.common.core.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * security配置
 * @author pengliang
 * @date 2019/10/20 17:41
 */
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@ConfigurationProperties("com.github.pengliangs.security")
public class SecurityProperties {

	/**
	 * 不被验证验证的连接
	 */
	List<String> ignoreUrls = new ArrayList<>();
}
