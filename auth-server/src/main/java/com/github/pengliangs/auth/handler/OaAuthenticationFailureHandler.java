package com.github.pengliangs.auth.handler;

import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.core.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 认证失败
 *
 * @author pengliang on 2018-08-04 15:34
 */
@Slf4j
@Component
public class OaAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("用户：{},登录失败.", request.getParameter("username"));
        int status = response.getStatus();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JacksonUtils.toJson(ResultData.failure(status, exception.getMessage())));
    }

}
