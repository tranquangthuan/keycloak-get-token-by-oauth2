package com.example.kc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.oauth2Client();

		http.authorizeRequests().anyRequest().permitAll();
	}

//	@Bean
//	public OAuth2AuthorizedClientManager authorizedClientManager(
//			ClientRegistrationRepository clientRegistrationRepository,
//			OAuth2AuthorizedClientRepository authorizedClientRepository) {
//
//		OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
//				.clientCredentials().build();
//
//		var authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,
//				authorizedClientRepository);
//
//		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//
//		return authorizedClientManager;
//	}
}
