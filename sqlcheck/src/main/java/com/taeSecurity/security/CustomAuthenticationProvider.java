package com.taeSecurity.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//커스텀한 인증 공급자.(인증 필터 -> 인증 관리자 -> 인증 공급자 ->: 인증 공급자에서 결과값 리턴)

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider  {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//인증 논리를 추가할 위치
		
		String username = authentication.getName(); // principal 인터페이스의 getName() 매서드를 Authentication에서 상속받는다.
		String password = String.valueOf(authentication.getCredentials());
		
		//인증 논리 부분 현재 연습용으로 config에서 john 12345 를 유저 디테일을 설정해서 bean으로 등록해놨다. 이걸 검증 할 것이다.
		if("check1".equals(username) && "1234".equals(password)) {
			//이 부분은 UserDetailService 및 PasswordEncoder를 호출해서 사용자 이름과 암호를 체크한다.
			
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
			
			
		}else {
			
			throw new AuthenticationCredentialsNotFoundException("Error in authentication");
			
		}
		//결국 여기의 if-else 구문은 UserDetailService 및 PasswordEncoder의 책임을 대체한다. 
		//두개의 Bean을 이용해야 하는 것은 아니지만. 인증을 위해 사용자와 암호를 관리함ㄴ다면 논리를 분리시키는 것이 좋다.
		
		
		
	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//Authentication 형식의 구현을 추가할 위치
	
		//이건 후에 더 자세히 할 것이다. 지금은 일단 코드.
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
		
	}
	
	
	//이제 이 Provider를 등록하러 가자.
	

}
