package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class HomeServiceImpl implements HomeServicei {

	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Styudent Data Check In Repo : " + student);
		studentRepository.save(student);
	}


	@Override
	public Student findStudentUsingId(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).get();
		return student;
	}


	@Override
	public List<Student> findAllData() {
		// TODO Auto-generated method stub
		return (List<Student>)studentRepository.findAll();
	}


	@Override
	public void saveAllStudentData(List<Student> list) {
		// TODO Auto-generated method stub
		studentRepository.saveAll(list);
	}


	@Override
	public void updatingStudentData(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}


	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
