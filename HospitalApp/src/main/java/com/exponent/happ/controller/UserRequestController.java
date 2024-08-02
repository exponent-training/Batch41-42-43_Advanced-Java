package com.exponent.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.service.UserServiceI;



@RestController
@RequestMapping(value = "/api/user")
public class UserRequestController {
	
	
	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping(value = "/save",consumes = "application/json")
	public String registerUserRequest(@RequestBody UserRequest userRequest) {
		System.out.println("Check User Request Data : " + userRequest);
		userServiceI.addUserRequest(userRequest);
		return "Data Added.";
	}

}
