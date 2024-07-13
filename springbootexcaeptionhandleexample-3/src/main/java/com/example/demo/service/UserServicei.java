package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserRequest;

public interface UserServicei {

	void saveRequset(UserRequest userRequest);
	
	UserRequest getUserRequestData(String uname);
	
	List<UserRequest> getAllData();
	
	List<UserRequest> getAllDataGreaterThanAge(long age);
	
	List<UserRequest> getAllDataUsingAddress(String address);
	
	List<UserRequest> findDataUSingDate(String startDate,String endDate);
}
