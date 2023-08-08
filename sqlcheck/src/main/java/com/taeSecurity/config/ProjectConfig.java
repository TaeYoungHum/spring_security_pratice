package com.taeSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {
	
	//유저 디테일 서비스 등록
	@Bean
	public UserDetailsService userDetailsService () {
		var userDetailsService = new InMemoryUserDetailsManager();
		
		var user = User.withUsername("john")
			.password("12345")
			.authorities("read")
			.build();
		
		userDetailsService.createUser(user);
		
		return userDetailsService;
		
		
	}
	
	//패스워드 엔코더 등록 -> 일단 스트링 그대로.
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
}
