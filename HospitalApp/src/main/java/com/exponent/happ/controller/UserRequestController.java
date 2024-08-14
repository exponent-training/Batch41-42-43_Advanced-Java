package com.exponent.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.happ.dto.ResponseDto;
import com.exponent.happ.dto.UserRequestDto;
import com.exponent.happ.entity.Login;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.service.UserServiceI;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class UserRequestController {


	@Autowired
	private UserServiceI userServiceI;

	@PostMapping(value = "/save",consumes = "application/json")
	public ResponseEntity<ResponseDto> registerUserRequest(@RequestBody Login login) {
		System.out.println("Check User Request Data : " + login);
		ResponseDto responseDto = userServiceI.addUserRequest(login);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
	}

	@GetMapping(value = "/findUser/{usernumber}")
	public ResponseEntity<UserRequest> getUserData(@PathVariable String usernumber){
       log.info("User Request Data Fetching Start using usernumber : " + usernumber);
       UserRequest userRequest = userServiceI.getUserRequest(usernumber);
       return new ResponseEntity<UserRequest>(userRequest,HttpStatus.OK);
	} 
	
	@GetMapping(value = "/userAllAppointment/{usernumber}")
	public ResponseEntity<UserRequestDto> getUserAppointDetails(@PathVariable String usernumber){
		log.info("Checking User number : " + usernumber);
		UserRequestDto userRequestDto = userServiceI.getUserReuestAppointmentData(usernumber);
		return new ResponseEntity<UserRequestDto>(userRequestDto,HttpStatus.OK);
	}
}
