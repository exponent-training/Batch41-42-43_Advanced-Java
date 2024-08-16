package com.exponent.happ.service;

import com.exponent.happ.entity.AssignedDoctor;

public interface AssignedDoctorService {

	
	AssignedDoctor findDoctor(String catogory,String doctorName);
}
