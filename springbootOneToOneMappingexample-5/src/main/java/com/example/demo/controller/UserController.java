package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceI;

@RestController
public class UserController {

	
	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping(value = "/saveUser")
	public ResponseEntity<String> saveUserData(@RequestBody User user){
		System.out.println("Check user Data  : " + user);
		int i = userServiceI.userSave(user); 
		if( i > 0 ) {
			return new ResponseEntity<String>("User SuccessFully Registerd.",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("User not SuccessFully Registerd.",HttpStatus.OK);
		}
	}
	
}
