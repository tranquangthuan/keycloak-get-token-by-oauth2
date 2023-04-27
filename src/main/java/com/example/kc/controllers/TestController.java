package com.example.kc.controllers;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public OAuth2AccessToken test(
			@RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient oAuth2AuthorizedClient) {
		OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();
		System.out.println(accessToken.getTokenValue());
		return accessToken;
	}

}
