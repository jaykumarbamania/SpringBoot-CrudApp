package com.neosoft.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Welcome to SpringBoot Hello Test using STS 445";
	}
	
	@GetMapping("/today")
	public String today() {
		return "Hello Welcome to SpringBoot Today Test using STS 445";
	}

}
