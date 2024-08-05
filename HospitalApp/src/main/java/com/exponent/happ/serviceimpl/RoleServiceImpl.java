package com.exponent.happ.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.happ.dto.Response;
import com.exponent.happ.entity.Role;
import com.exponent.happ.repo.RoleRepository;
import com.exponent.happ.service.RoleServiceI;

@Service
public class RoleServiceImpl implements RoleServiceI{

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Response saveRoleData(Role role) {
		// TODO Auto-generated method stub
		Response response =  new Response();
		Role role2 = roleRepository.save(role);
		if(role2 != null) {
			response.setMsg("Role Data inserted.");
		} else {
			response.setMsg("Role Data not inserted.");
		}
		return response;
	}

}
