package com.github.pengliangs.common.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token校验失败返回信息
 *
 * @author pengliang on 2018-08-06 10:22
 */
@Slf4j
public class CustomAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("令牌有误：{}", authException.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.writeValue(response.getOutputStream(), ResultData.createResultData(HttpServletResponse.SC_UNAUTHORIZED, "错误/过期的令牌"));
    }
}
