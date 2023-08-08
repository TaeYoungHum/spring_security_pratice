//package com.taeSecurity.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.taeSecurity.security.CustomAuthenticationProvider;
//
//@SuppressWarnings("deprecation")
//@Configuration
//public class ProjectConfig {
//	
//	//추가로 provider 작성 후 등록 법 
//	
//	//1. custom provider를 오토 와이어드
//	@Autowired
//	private CustomAuthenticationProvider authenticationProvider;
//	
//	//2. 이제 등록을 해야하는데...
////	@Bean
////    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
////        return authenticationConfiguration.getAuthenticationManager();
////    } //-> 현재 이거 없어도 됨.
//	
//	//3. 등록 부분
//	@Autowired
//	void registerProvider(AuthenticationManagerBuilder auth) {
//		
//		auth.authenticationProvider(authenticationProvider);
//	}
//	
//	//유저 디테일 서비스 등록 -> 현재 provider 등록시 작동 안하는 것 같음 -> 이게 나중에 jdbc랑 연동되고. 커스텀 프로바이더에서 불려서 사용되는 듯
//	@Bean
//	public UserDetailsService userDetailsService () {
//		var userDetailsService = new InMemoryUserDetailsManager();
//		
//		var user = User.withUsername("gsdj1990")
//			.password("12345")
//			.authorities("read")
//			.build();
//		
//		userDetailsService.createUser(user);
//		
//		return userDetailsService;
//		
//		
//	}
//	
//	//패스워드 엔코더 등록 -> 일단 스트링 그대로.
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.httpBasic();
//		http.authorizeRequests()
//					.anyRequest().authenticated(); // 모든 http 리퀘스트에 인증
//					//.anyRequest().permitAll();	// 모든 http 리퀘스트에 인증 안함
//		
//		return http.build();
//		
//	}
//	
//	
//	
//}
