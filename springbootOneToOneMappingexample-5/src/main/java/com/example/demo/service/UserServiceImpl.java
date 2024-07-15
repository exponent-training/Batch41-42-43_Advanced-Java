package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public int userSave(User user) {
		// TODO Auto-generated method stub
		User user1= userRepository.save(user);
		return user1.getId();
	}

}
