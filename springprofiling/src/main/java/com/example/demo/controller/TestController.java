package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@Value(value = "${spring.name}")
	private String name;
	
	@RequestMapping(value = "/")
	public String getProfileData() {
		
		return "Spring Boot Profile name : "+ name;
	}
}
