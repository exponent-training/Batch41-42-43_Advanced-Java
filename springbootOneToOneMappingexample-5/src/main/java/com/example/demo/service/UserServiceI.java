package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserServiceI {
	
	int userSave(User user);
	
	List<User> getAllUser();
	
	User getUserEntity(int id);

}
