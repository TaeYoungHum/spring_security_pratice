package com.taeSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

	//원래 config에서 역할 분담을 위해 분리하는 것이 좋아서 분리한 것임.
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var userDetailsService = new InMemoryUserDetailsManager();
		
	
		var user = User.withUsername("check").password("1234").authorities("read").build();
		
		userDetailsService.createUser(user);
		
		return userDetailsService;
					
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
}
