package com.github.pengliangs.common.security.resource;

import cn.hutool.http.HttpStatus;
import com.github.pengliangs.common.security.constant.SecurityConstants;
import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.core.utils.JacksonUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author pengliang on 2019-10-20 17:48
 * 客户端异常处理,根据 AuthenticationException 不同细化异常处理
 */
@Slf4j
public class CustomResourceAuthExceptionEntryPoint implements AuthenticationEntryPoint {

	@Override
	@SneakyThrows
	public void commence(HttpServletRequest request, HttpServletResponse response,
						 AuthenticationException authException) {
		response.setCharacterEncoding(SecurityConstants.ENCODING_UTF8);
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		ResultData<String> result = ResultData.failure();
		result.setErrorCode(HttpStatus.HTTP_UNAUTHORIZED);
		if (authException != null) {
			result.setErrorMsg(authException.getMessage());
		}
		response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
		PrintWriter printWriter = response.getWriter();
		printWriter.append(JacksonUtils.toJson(result));
	}
}
