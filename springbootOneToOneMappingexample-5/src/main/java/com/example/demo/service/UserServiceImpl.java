package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
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


	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User getUserEntity(int id) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			 throw new UserNotFound("User Id Does Not exists.");
		}
	}

}
