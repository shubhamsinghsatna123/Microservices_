package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SecondClient;

@RestController
@RequestMapping("/first")
public class Homecontroller {
	
	@Autowired
	SecondClient client;
	
	@GetMapping("/home")
	public String btm() {
		return "Hi Sharath" +"     "+client.getHome();
	}

}
