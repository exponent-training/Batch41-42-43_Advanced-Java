package com.exponent.happ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exponent.happ.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	
	Role findByRolename(String rolename); 
	
}
