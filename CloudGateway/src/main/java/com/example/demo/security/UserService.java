package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserData;
import com.example.demo.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserData> byId = repo.findById(username);
		if(byId.isEmpty()) {
			throw  new RuntimeException("User not found");
		}
		
		return new UserPrinciple(byId.get());
	}

}
