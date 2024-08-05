package com.exponent.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.happ.dto.Response;
import com.exponent.happ.service.AdminServiceI;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceI adminServiceI;

	@GetMapping(value = "/assignRole")
	public ResponseEntity<Response> assignRoleToUser(@RequestParam String email,@RequestParam String rolename){
		System.out.println("Check Role Data For USer : " + email + " " + rolename);
		Response response = adminServiceI.assignRole(email, rolename);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
}
