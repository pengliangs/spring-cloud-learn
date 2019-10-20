package com.github.pengliangs.auth.handler;

import com.github.pengliangs.common.security.request.ClientBean;
import com.github.pengliangs.common.security.request.ExtractRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author pengliang on 2018-09-11 19:48
 */
@Component
public class CustomOAuth2AccessToken {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public OAuth2AccessToken getOAuth2AccessToken(HttpServletRequest request, Authentication authentication) throws IOException {

        ClientBean clientBean = ExtractRequest.extractAndDecodeHeader(request);
        String clientId = clientBean.getClientId();
        String clientSecret = clientBean.getClientSecret();

        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("[clientId] does not exist :" + clientId);
        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException("clientSecret not mismatch:" + clientSecret);
        }

        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(1), clientId, clientDetails.getScope(), "custom");

        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
        return token;
    }


}
