package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserData;
import com.example.demo.repository.UserRepo;

@Service
public class HomeService {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	public UserData setData(UserData userData) {
		userData.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
		return repo.save(userData);
	}	

	public UserData getLogin( UserData data) {
		String identifier = data.getEmail();
		if (identifier == null || identifier.trim().isEmpty()) {
		        if (data.getMobile()!=null) {
		            identifier = String.valueOf(data.getMobile());
		        } else {
		            throw new BadCredentialsException("Email or Mobile must be provided");
		        }
		    }
		
		
		Optional<UserData>us;
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword())
				);
		if(authentication.isAuthenticated()) {
			if(identifier.contains("@")) {
			us=	repo.findByEmailIgnoreCase(data.getEmail());
			}else {
			us=	repo.findByMobile(data.getMobile());
			}
			return us.get();
		}
		return null;
	}
	
}