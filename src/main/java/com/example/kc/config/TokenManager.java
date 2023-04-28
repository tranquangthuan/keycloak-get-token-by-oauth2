package com.example.kc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {
    private String clientRegistrationName = "keycloak";

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public TokenManager(OAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    public OAuth2AuthorizedClient getAccessToken() {
        OAuth2AuthorizeRequest authorizeRequest =
                OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationName)
                        .principal(clientId)
                        .build();
        return
                this.authorizedClientManager.authorize(authorizeRequest);
    }
}
