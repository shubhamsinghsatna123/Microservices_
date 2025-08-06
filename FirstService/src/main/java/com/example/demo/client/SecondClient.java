package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name="SECONDSERVICE",value = "SECONDSERVICE" )
public interface SecondClient {


	@GetMapping("/second/home")
	public String getHome();
}
