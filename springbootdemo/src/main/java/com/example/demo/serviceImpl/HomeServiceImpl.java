package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HomeDaoi;
import com.example.demo.model.Student;
import com.example.demo.service.HomeServiceI;


@Service
public class HomeServiceImpl implements HomeServiceI{

	@Autowired
	private HomeDaoi homeDaoi;
	
	@Override
	public void addStudentData(Student student) {
		// TODO Auto-generated method stub
		homeDaoi.addStudentData(student);
	}

}
