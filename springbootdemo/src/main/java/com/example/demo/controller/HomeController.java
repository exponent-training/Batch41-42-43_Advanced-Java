package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;
import com.example.demo.service.HomeServiceI;

@Controller
public class HomeController {

	@Autowired
	private HomeServiceI homeServiceI;

	@RequestMapping(value = "/")
	public String demo() {

		return "index";
	}

	@RequestMapping(value = "/reg")
	public String getRegisterData(@ModelAttribute Student student) {
		System.out.println("Check Student Data : " + student);
		homeServiceI.addStudentData(student);
		return "login";
	}
}