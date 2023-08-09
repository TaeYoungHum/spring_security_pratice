package com.taeSecurity.security.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//DummyUser class 진화형 -> 혹은 이렇게 class 선언안하고. User 객체 빌더로 만들 수도 있다.
//p76을 보면 빌더로 만드는 내용이 있다.

//p83 연습용 + service에 메모리 어쩌구 
public class SimpleUser implements UserDetails{
	
	private final String username;
	private final String password;
	private final String authority; // 간단하게 만들기 위해서. 1개의 권한만.
	
	public SimpleUser(String username, String password, String authority) {
		this.username = username;
		this.password = password;
		this.authority = authority;
	}

	
	

	public String getAuthority() {
		return authority;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(()->authority); // 인스턴스를 만들때 지정한게 나옴
	}


	@Override
	public String getPassword() {
		return this.password;
	}


	@Override
	public String getUsername() {
		return this.username;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
