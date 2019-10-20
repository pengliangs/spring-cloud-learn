package com.github.pengliangs.auth.handler;

import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.core.utils.JacksonUtils;
import com.github.pengliangs.common.service.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功
 *
 * @author pengliang on 2018-07-31 17:56
 */
@Component
public class OaAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomOAuth2AccessToken customOAuth2AccessToken;

    @SuppressWarnings("unchecked")
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        logger.info("用户：{}，登录成功：{}.", request.getParameter("username"), request.getRequestURL());
        String type = request.getParameter("type");
		SysUser user = (SysUser) authentication.getPrincipal();
        OAuth2AccessToken token = customOAuth2AccessToken.getOAuth2AccessToken(request, authentication);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JacksonUtils.toJson(ResultData.success(token)));
    }


}
