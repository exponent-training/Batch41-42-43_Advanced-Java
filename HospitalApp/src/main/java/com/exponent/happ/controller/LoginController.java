package com.exponent.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.happ.dto.Response;
import com.exponent.happ.dto.UserResponseDto;
import com.exponent.happ.entity.Login;
import com.exponent.happ.service.LoginService;

@RestController
@RequestMapping("/api/user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/login")
	public ResponseEntity<UserResponseDto> getLoginData(@RequestBody Login login){
		System.out.println("Login Credentials Check : " + login);
		UserResponseDto userResponseDto = loginService.getLoginData(login.getEmail(), login.getPassword());
		return new ResponseEntity<UserResponseDto>(userResponseDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/forgotpassword")
	public ResponseEntity<Response> forgotPassword(@RequestParam String email,@RequestParam String pass){
		System.out.println("Check updated password : " + email + "  " + pass);
		Response response = loginService.forgotPassword(email, pass);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
}
