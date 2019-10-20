package com.github.pengliangs.common.request;

import com.github.pengliangs.common.constant.SecurityConstants;
import com.github.pengliangs.common.core.utils.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author pengliang on 2018-09-12 14:06
 */
public class ExtractRequest {

    /**
     * 提取请求头中认证信息
     *
     * @param header
     * @return
     * @throws UnsupportedEncodingException
     */
    public static ClientBean extractAndDecodeHeader(String header) throws UnsupportedEncodingException {
        byte[] base64Token = header.substring(6).getBytes(SecurityConstants.ENCODING_UTF8);
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }

        String token = new String(decoded, SecurityConstants.ENCODING_UTF8);

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }

        return new ClientBean(token.substring(0, delim), token.substring(delim + 1));
    }

    /**
     * 提取请求头中认，Authorization证信息
     *
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public static ClientBean extractAndDecodeHeader(HttpServletRequest request)
            throws IOException {

        String header = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER);

        if (StringUtils.isEmpty(header) || !header.startsWith(SecurityConstants.AUTH_BASIC)) {
            throw new UnapprovedClientAuthenticationException("Request header is not fund client info.");
        }

        return extractAndDecodeHeader(header);
    }
}
