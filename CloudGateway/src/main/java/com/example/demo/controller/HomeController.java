package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserData;
import com.example.demo.entity.UserRes;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.service.HomeService;

@RestController
@RequestMapping("/gateway")
public class HomeController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/token")
	public String home() {
		return "token" +"         "+jwtUtil.generateToken("shubham@gmail.com");
	}
	@GetMapping("/hi")
	public String home1() {
		return "home1";
	}
	
	@PostMapping("/register")
	public UserRes register(@RequestBody UserData userData) {
		 UserData setData = homeService.setData(userData);
		 UserRes map = mapper.map(setData, UserRes.class);
		 return map;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserData data) {
		UserData login = homeService.getLogin(data);
		UserRes map = mapper.map(login, UserRes.class);
		Map<String, Object>mp=new HashMap<String, Object>();
		mp.put("Data", map);
		mp.put("token", jwtUtil.generateToken(login.getEmail()));
		return mp;
	}
	
	
	
	
}
