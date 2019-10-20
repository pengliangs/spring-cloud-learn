package com.github.pengliangs.common.security.exception;

import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.core.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败时返回信息
 *
 * @author pengliang on 2018-08-06 10:25
 */
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("异常OaAccessDeniedHandler：{}", accessDeniedException.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JacksonUtils.toJson(ResultData.failure(response.getStatus(), accessDeniedException.getMessage())));
    }
}
