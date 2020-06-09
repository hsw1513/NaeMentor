package com.min.naementor.spring.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.model.naemember.Naemember_IService;


public class Security_CTRL implements UserDetailsService {

	@Autowired
	private Naemember_IService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> map = new HashMap<String, Object>();
		// username : 사용자가 입력한 아이디 값
		map.put(username, username);
		
		// 유저의 비밀번호, 권한이 담긴 dto 생성
		NaememberDto dto = service.encLogin(map);
		
		// 유저의 권한을 담는 객체
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		// .add를 통해 dto의 권한데이터를 담아 roles 실행 => roles는 해당 유저의 권한을 인식할 수 있음
		// 권한데이터 앞에는 반드시 ROLE_을 붙여야 시큐리티가 인식할 수 있음
		roles.add(new SimpleGrantedAuthority(dto.getAuth()));
		
		// 아이디, 비밀번호, 권한을 담은 위의 객체를 담아 생성
		UserDetails user = new User(username, dto.getPassword(), roles);
		
		return user;
	}

}
