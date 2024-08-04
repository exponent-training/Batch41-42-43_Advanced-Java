package com.exponent.happ.service;

import com.exponent.happ.dto.ResponseDto;
import com.exponent.happ.entity.Login;
import com.exponent.happ.entity.UserRequest;

public interface UserServiceI {

	
	ResponseDto addUserRequest(Login login);
}
