package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class HomeController {

	
	@RequestMapping(value = "/log")
	public Student getData() {
		
		Student student =new Student();
		student.setId(123);student.setName("ABC");
		student.setAddress("Pune");
		student.setUname("admin");
		student.setPass("admin");
		
		return student;
	}
	
	
	@RequestMapping(value = "/allStu")
	public List<Student> getAllData() {
		
		Student student =new Student();
		student.setId(123);student.setName("ABC");
		student.setAddress("Pune");
		student.setUname("admin");
		student.setPass("admin");
		
		Student student1 =new Student();
		student1.setId(123);student1.setName("ABC");
		student1.setAddress("Pune");
		student1.setUname("admin");
		student1.setPass("admin");
		
		Student student2 =new Student();
		student2.setId(123);student2.setName("ABC");
		student2.setAddress("Pune");
		student2.setUname("admin");
		student2.setPass("admin");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);list.add(student1);list.add(student2);
		
		return list;
	}
	
	
	
	@RequestMapping(value = "/getStu/{id}")
	public ResponseEntity<?> getSingleById(@PathVariable int id) {
		
		System.out.println("Check Id : " + id);
		
		Student student =new Student();
		student.setId(13);student.setName("ABCQWER");
		student.setAddress("Pune");
		student.setUname("admin");
		student.setPass("admin");
		
		Student student1 =new Student();
		student1.setId(12);student1.setName("ABCPQR");
		student1.setAddress("Pune");
		student1.setUname("admin");
		student1.setPass("admin");
		
		Student student2 =new Student();
		student2.setId(11);student2.setName("ABCD");
		student2.setAddress("Pune");
		student2.setUname("admin");
		student2.setPass("admin");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);list.add(student1);list.add(student2);
		Student s = new Student();
		boolean flag = false;
	    for(Student stu : list) {
	    	if(stu.getId()== id) {
	    		s = stu;
	    		flag =true;
	    		break;
	    	}	
	    }
	    
	    //Using java 8.
//	    Student  stu =  
	    Student stu = list.stream().filter(x->x.getId()==id).findFirst().get();
	    
	    if( flag ) {
	    	return new ResponseEntity(stu,HttpStatus.OK);
	    }
        return  new ResponseEntity("Student Not Found",HttpStatus.OK);
	}
	
	@GetMapping(value = "/login")
	public String getLoginData(@RequestParam String uname,@RequestParam String pass) {
		System.out.println("Check Login Credentials : " + uname + "   " + pass);
		return "Testing";
	}
	
	
	@PostMapping(value = "/reg")
	public String regsiterStudent(@RequestBody Student student) {
		System.out.println("Checking Student Data : " + student);
		return "Student registered.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
