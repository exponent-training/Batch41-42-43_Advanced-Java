package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.model.UserRequest;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserServicei{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveRequset(UserRequest userRequest) {
		// TODO Auto-generated method stub
		userRepository.save(userRequest);
	}

	@Override
	public UserRequest getUserRequestData(String uname) {
		// TODO Auto-generated method stub
		UserRequest userRequest=null;
		try {
			userRequest = userRepository.findByUname(uname);
			System.out.println(userRequest.getUname());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new ExceptionResponse("Invalid Username.");
		}
		return userRequest;
	}

	@Override
	public List<UserRequest> getAllData() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<UserRequest> getAllDataGreaterThanAge(long age) {
		// TODO Auto-generated method stub
		List<UserRequest>  userList = userRepository.findByAgeGreaterThan(age);
		Collections.sort(userList, Comparator.comparingLong(UserRequest::getAge).reversed());
		return userList;
	}

	@Override
	public List<UserRequest> getAllDataUsingAddress(String address) {
		// TODO Auto-generated method stub
		return userRepository.findUserRequestUsingAddress(address);
	}

	@Override
	public List<UserRequest> findDataUSingDate(String startDate,String endDate) {
		// TODO Auto-generated method stub
		return userRepository.findBystartDateBetween(startDate,endDate);
	}

}
