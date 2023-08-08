package com.taeSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.taeSecurity.security.CustomAuthenticationProvider;

//웹 인증용. custom provider 등록 하는 config

@Configuration
public class WebAuthorizationConfig {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Autowired
	void registerProvider(AuthenticationManagerBuilder auth) {
		
		auth.authenticationProvider(authenticationProvider);
	}
	
}
