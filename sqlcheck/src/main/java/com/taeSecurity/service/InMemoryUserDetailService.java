package com.taeSecurity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryUserDetailService implements UserDetailsService{
	
	private final List<UserDetails> users;

	public InMemoryUserDetailService(List<UserDetails> users) {
		this.users = users;
	}

	@Override
	//이 매서드는 주어진 사용자 이름으로 사용자 목록을 검색하고. 
	//검색된 UserDetails 인스턴스를 반환한다.(없으면 예외) 이제 이걸 bean으로 등록해보자.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.stream()
				.filter( // 사용자의 목록에서 요청된 사용자 이름과 일치하는 항목을 필터링
							u->u.getUsername().equals(username)
						)
				.findFirst() // 일치하는 사용자가 있으면 반환
				.orElseThrow( // 없으면 예외를 반환
							()-> new UsernameNotFoundException("User not found")
						);
	}
	
	
	
	

}
