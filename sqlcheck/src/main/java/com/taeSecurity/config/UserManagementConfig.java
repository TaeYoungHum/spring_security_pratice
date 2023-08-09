package com.taeSecurity.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.taeSecurity.security.user.SimpleUser;
import com.taeSecurity.service.InMemoryUserDetailService;

@Configuration
//p85 메모리 기반 유저 디테일 서비스 등록
public class UserManagementConfig {

	//원래 config에서 역할 분담을 위해 분리하는 것이 좋아서 분리한 것임.
	
	//기본형
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		var userDetailsService = new InMemoryUserDetailsManager();
//		
//	
//		var user = User.withUsername("check").password("1234").authorities("read").build();
//		
//		userDetailsService.createUser(user);
//		
//		return userDetailsService;
//					
//	}
	
	//커스텀한 유저 디테일 서비스
	@Bean 
	public UserDetailsService userDetailsService() {
		UserDetails u = new SimpleUser("gsdj1990", "1234", "read");
		List<UserDetails> users = List.of(u); //of 용법 알아보자
		System.out.println("커스텀한 유저 디테일 서비스의 유저 아이디 = "+users.get(0).getUsername()+", "+users.get(0).getPassword());
		
		return new InMemoryUserDetailService(users);
		
		
	}
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
}
