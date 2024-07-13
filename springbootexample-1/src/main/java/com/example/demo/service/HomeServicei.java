package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface HomeServicei {

	
	void addStudent(Student student);
	
	Student findStudentUsingId(int id);
	
	List<Student> findAllData();
	
	void saveAllStudentData(List<Student> list);
	
	void updatingStudentData(Student student);
	
	void deleteStudent(int id);
}
