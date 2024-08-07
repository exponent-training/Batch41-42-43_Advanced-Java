package com.exponent.happ.service;

import java.util.List;

import com.exponent.happ.dto.Response;

public interface AdminServiceI {
	
	Response assignRole(String email,String rolename);
	
	List<String> getActiveEmailList();

	List<String> getRoleList();
}
