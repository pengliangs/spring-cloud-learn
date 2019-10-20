package com.github.pengliangs.common.security.feign;

import cn.hutool.core.collection.CollUtil;
import com.github.pengliangs.common.security.constant.SecurityConstants;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.security.oauth2.client.AccessTokenContextRelay;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collection;
import java.util.Objects;

/**
 * Fegin OAuth2拦截器
 * @author pengliang
 * @since 2019-08-26 21:06
 */
@Slf4j
public class FeignOauthClientInterceptor extends OAuth2FeignRequestInterceptor {
	private final OAuth2ClientContext oAuth2ClientContext;
	private final AccessTokenContextRelay accessTokenContextRelay;


	public FeignOauthClientInterceptor(OAuth2ClientContext oAuth2ClientContext
		, OAuth2ProtectedResourceDetails resource, AccessTokenContextRelay accessTokenContextRelay) {
		super(oAuth2ClientContext, resource);
		this.oAuth2ClientContext = oAuth2ClientContext;
		this.accessTokenContextRelay = accessTokenContextRelay;
	}


	/**
	 *
	 * @param template
	 */
	@Override
	public void apply(RequestTemplate template) {

		Collection<String> fromHeader = template.headers().get(SecurityConstants.IGNORE_AUTH_HEAD);
		if (CollUtil.isNotEmpty(fromHeader) && fromHeader.contains(SecurityConstants.IGNORE_AUTH_HEAD_VALUE)) {
			return;
		}

		accessTokenContextRelay.copyToken();

		if (Objects.nonNull(oAuth2ClientContext.getAccessToken())
			&&  Objects.nonNull(oAuth2ClientContext.getAccessToken().getValue())
			&& OAuth2AccessToken.BEARER_TYPE.equalsIgnoreCase(oAuth2ClientContext.getAccessToken().getTokenType())) {
			template.header("Authorization",
				String.format("%s %s", OAuth2AccessToken.BEARER_TYPE, oAuth2ClientContext.getAccessToken().getValue()));
		}
	}
}
