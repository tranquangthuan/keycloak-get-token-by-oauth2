package com.example.kc.controllers;

import com.example.kc.config.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TokenManager tokenManager;

    @GetMapping("/test")
    public OAuth2AccessToken test(
            @RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();
        System.out.println(accessToken.getTokenValue());
        return accessToken;
    }

    @GetMapping("/test2")
    public OAuth2AccessToken test2() {
        return tokenManager.getAccessToken().getAccessToken();
    }
}
