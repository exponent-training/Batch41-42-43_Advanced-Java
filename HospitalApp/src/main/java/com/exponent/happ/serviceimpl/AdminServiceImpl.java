package com.exponent.happ.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.happ.dto.Response;
import com.exponent.happ.entity.Login;
import com.exponent.happ.entity.Role;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.LoginRepository;
import com.exponent.happ.repo.RoleRepository;
import com.exponent.happ.repo.UserRepository;
import com.exponent.happ.service.AdminServiceI;

@Service
public class AdminServiceImpl implements AdminServiceI {

	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Response assignRole(String email, String rolename) {
		// TODO Auto-generated method stub
		
		Login login = loginRepository.findByEmail(email);
		if(login != null &&  login.getUserRequest() != null) {
			Role role = roleRepository.findByRolename(rolename);
			if(role != null) {
			  UserRequest userRequest = login.getUserRequest();
			  userRequest.setRole(role);
			  userRepository.save(userRequest);
			}
			return  Response.builder().msg("Role Assigned Successfully.").build();
		}
		return  Response.builder().msg("Role Assigned Not Successfully.").build();
	}

	@Override
	public List<String> getActiveEmailList() {
		// TODO Auto-generated method stub
		return loginRepository.findAllEmails();
	}

	@Override
	public List<String> getRoleList() {
		// TODO Auto-generated method stub
		return roleRepository.findAllRole();
	}
}
