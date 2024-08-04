package com.exponent.happ.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.happ.dto.UserResponseDto;
import com.exponent.happ.entity.Login;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.LoginRepository;
import com.exponent.happ.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserResponseDto getLoginData(String uname, String pass) {
		// TODO Auto-generated method stub
		UserResponseDto userResponseDto = new UserResponseDto();
		Login login = loginRepository.findByEmailAndPassword(uname, pass);
		if(login != null && login.getUserRequest() != null) {
			UserRequest userRequest = login.getUserRequest();
			userResponseDto.setUsernumber(userRequest.getUsernumber());
			userResponseDto.setFirstname(userRequest.getFirstname());
			userResponseDto.setLastname(userRequest.getLastname());
			userResponseDto.setEmail(login.getEmail());
			userResponseDto.setMobNumber(userRequest.getMobNumber());
			return userResponseDto;
		}else {
			userResponseDto.setErrorMsg("User Can not Find.");
			return userResponseDto;
		}
	}

}
