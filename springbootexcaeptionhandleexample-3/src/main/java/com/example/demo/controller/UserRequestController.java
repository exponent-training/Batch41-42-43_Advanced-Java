package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;
import com.example.demo.service.UserServicei;

@RestController
public class UserRequestController {

	@Autowired
	private UserServicei userServicei;

	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public ResponseEntity<String> saverequest(@RequestBody UserRequest userRequest){
		System.out.println("Check UserRequest Data : " + userRequest);
		userServicei.saveRequset(userRequest);
		return new ResponseEntity<String>("Data Stored.", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/get/{uname}",method = RequestMethod.GET )
	public ResponseEntity<UserRequest> getUserrequestData(@PathVariable String uname){
		System.out.println("Check username : " + uname);
		UserRequest userRequest = userServicei.getUserRequestData(uname);
		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.OK);
	} 

	@RequestMapping(value ="/getAll")
	public ResponseEntity<List<UserRequest>> getData(){
		System.out.println("Fetching All Data : => Start");
		List<UserRequest> list = userServicei.getAllData();
		return new ResponseEntity<List<UserRequest>>(list,HttpStatus.OK);
	}

	@GetMapping(value = "/age/{age}")
	public List<UserRequest> getUserRequestGreaterThanAge(@PathVariable long age){
		System.out.println("Check Greater than age : " + age);
		List<UserRequest> ulist = userServicei.getAllDataGreaterThanAge(age);
		return ulist;
	}

	@RequestMapping(value = "/findByAddress")
	public List<UserRequest> getUserRequestUsingAddress(@RequestParam String address){
		List<UserRequest> list = userServicei.getAllDataUsingAddress(address);
		return list;
	}


	@RequestMapping(value = "/findDataUsingDate/{startDate}/{endDate}")
	public List<UserRequest> findDataUSingDate(@PathVariable String startDate,@PathVariable String endDate){
         System.out.println("Check Date : " + startDate + "    " + endDate);
         List<UserRequest> list = userServicei.findDataUSingDate(startDate,endDate);
         return list;
	}














}
