package com.exponent.happ.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exponent.happ.entity.UserRequest;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Integer>{

	
	
}
