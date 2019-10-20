package com.github.pengliangs.common.security.exception;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * 重写oauth错误返回
 *
 * @author pengliang on 2018-08-06 10:09
 */
@Slf4j
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception> {

	@Override
	@SneakyThrows
	public ResponseEntity<OAuth2Exception> translate(Exception e){
		log.info("异常OaWebResponseExceptionTranslator：{}", e.getMessage());
		OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
		return ResponseEntity.status(oAuth2Exception.getHttpErrorCode())
			.body(new CustomOauth2Exception(oAuth2Exception.getMessage()));
	}

}
