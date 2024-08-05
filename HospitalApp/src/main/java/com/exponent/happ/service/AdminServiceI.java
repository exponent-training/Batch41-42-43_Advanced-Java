package com.exponent.happ.service;

import com.exponent.happ.dto.Response;

public interface AdminServiceI {
	
	Response assignRole(String email,String rolename);

}
