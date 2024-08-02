package com.exponent.happ.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.UserRepository;
import com.exponent.happ.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUserRequest(UserRequest userRequest) {
		// TODO Auto-generated method stub
		userRepository.save(userRequest);
	}

}
