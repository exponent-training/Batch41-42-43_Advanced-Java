package com.exponent.happ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exponent.happ.entity.AssignedDoctor;

@Repository
public interface AssignedDoctorRepository extends JpaRepository<AssignedDoctor, Integer>{

	
	AssignedDoctor findByCatogoryAndName(String category, String name);
	
}
