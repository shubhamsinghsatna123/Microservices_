package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class HomeController {
	
	@GetMapping("/home")
	public String home2() {
		return "Hi pankaj";
	}

}
