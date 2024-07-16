package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "/getAll")
    public ResponseEntity<List<User>> getAllUserData(){
		System.out.println("In controller List of User fetching");
		List<User>  ulist = userServiceI.getAllUser();
		return new ResponseEntity<List<User>>(ulist,HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<User> getUserEntity(@PathVariable int id){
		System.out.println("Fetching user data usibng id : " + id);
		User user = userServiceI.getUserEntity(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateUserAndLoginData(@RequestBody  User user){
		System.out.println("Upadated User Data : " + user);
		int i = userServiceI.userSave(user);
		if( i > 0 ) {
			return new ResponseEntity<String>("User SuccessFully Updated.",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("User not SuccessFully updated.",HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
}
