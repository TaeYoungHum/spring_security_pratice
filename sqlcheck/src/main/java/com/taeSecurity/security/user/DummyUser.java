package com.taeSecurity.security.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DummyUser implements UserDetails{

	
	//1
	@Override
	public String getPassword() {
		return "1234";
	
	}

	@Override
	public String getUsername() {
		
		return "bill";
		
	}
	
	
	//2 권한의 목록을 위한 정의
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->"READ");
	}

	
	//3.  true로 하면, 항상 활성화 하고 사용가능하다는 의미.
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
