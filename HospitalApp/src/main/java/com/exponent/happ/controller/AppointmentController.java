package com.exponent.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exponent.happ.dto.Response;
import com.exponent.happ.entity.Appointment;
import com.exponent.happ.service.AppointmentServiceI;

@RestController
@RequestMapping(value ="/api/all")
public class AppointmentController {
	
	@Autowired
	private AppointmentServiceI appointmentServiceI;

	@PostMapping(value = "/book/{usernumber}")
	public ResponseEntity<Response> bookAppointment(@RequestBody Appointment appointment,@PathVariable String usernumber){
		System.out.println("Appointment : "+ appointment);
		Response response = appointmentServiceI.bookAppointment(appointment,usernumber);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
}
