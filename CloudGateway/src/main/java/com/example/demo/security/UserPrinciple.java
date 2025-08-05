package com.example.demo.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UserData;

public class UserPrinciple implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	UserData data;

	public UserPrinciple(UserData userData) {
		this.data=userData;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(data.getRole()));
	}

	@Override
	public String getPassword() {
		return data.getPassword();
	}

	@Override
	public String getUsername() {
		return data.getEmail();
	}

}
