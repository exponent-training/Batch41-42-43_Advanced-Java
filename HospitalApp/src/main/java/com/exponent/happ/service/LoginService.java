package com.exponent.happ.service;

import com.exponent.happ.dto.Response;
import com.exponent.happ.dto.UserResponseDto;

public interface LoginService {

	
	UserResponseDto getLoginData(String uname,String pass);
	
	Response forgotPassword(String email,String pass);
}
