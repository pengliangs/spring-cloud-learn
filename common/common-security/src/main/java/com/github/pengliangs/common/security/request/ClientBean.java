package com.github.pengliangs.common.security.request;

import lombok.Data;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;

import java.util.Objects;

/**
 * @author pengliang on 2018-09-12 14:08
 */
@Data
public class ClientBean {

    private String clientId;

    private String clientSecret;

    public ClientBean(String clientId, String clientSecret) {
        if (Objects.isNull(clientId) || Objects.isNull(clientSecret)){
            throw new UnapprovedClientAuthenticationException("clientId and clientSecret required");
        }
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}
