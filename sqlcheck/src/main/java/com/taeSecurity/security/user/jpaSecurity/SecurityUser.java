package com.taeSecurity.security.user.jpaSecurity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taeSecurity.model.jpa.User;


// 엔티티랑 유저 디테일을 나눔.
public class SecurityUser implements UserDetails{

	private final User user; //final 을 사용해서 반드시 User 객체가 필요함을 알리고. 셋업은 생성자로.

	public SecurityUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->user.getAuthority());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	
}
