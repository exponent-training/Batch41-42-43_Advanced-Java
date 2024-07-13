package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.HomeServicei;

@RestController
public class StudentController {

	
	@Autowired
	private HomeServicei homeServicei;
	
	@PostMapping(value = "/reg")
	public String addStudent(@RequestBody Student student) {
		System.out.println("Check Student Data :" + student);
		homeServicei.addStudent(student);
		return "Data Stored successfully";
	}
	
	@GetMapping(value = "/get/{id}")
	public Student getStudentUsingId(@PathVariable int id) {
		System.out.println("Check In in Controller : " + id);
		Student student = homeServicei.findStudentUsingId(id);
		return student;
	}
	
	@GetMapping(value = "/all")
	public List<Student> getAllData(){
		System.out.println("Fe5tching all data: start");
		return homeServicei.findAllData();
	}
	
	@PostMapping(value = "/insertAll")
	public String insertingAllStudent(@RequestBody List<Student> list) {
		System.out.println("Check All list of Student : " + list);
		homeServicei.saveAllStudentData(list);
		return "Check List of Data";
	}
	
	@PutMapping(value = "/updateStu")
	public String updatingStudent(@RequestBody Student student) {
		System.out.println("Check updated data : "  + student);
		homeServicei.updatingStudentData(student);
		return "Student updated.";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") int stuId) {
		System.out.println("Check Deleting Id : " + stuId);
		homeServicei.deleteStudent(stuId);
		return "Student Deleted successfully.";
	}
	
	
}
