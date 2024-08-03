package com.exponent.happ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exponent.happ.entity.UserRequest;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Integer>{

	UserRequest findByEmail(String email);
	
}
