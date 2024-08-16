package com.exponent.happ.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.happ.constants.Constants;
import com.exponent.happ.dto.Response;
import com.exponent.happ.entity.Appointment;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.AppointmentRepository;
import com.exponent.happ.repo.AssignedDoctorRepository;
import com.exponent.happ.repo.UserRepository;
import com.exponent.happ.service.AppointmentServiceI;
import com.exponent.happ.util.UserRequestIDGenerator;

@Service
public class AppointmentServiceImpl implements AppointmentServiceI{

	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AssignedDoctorRepository assignedDoctorRepository;

	@Override
	public Response bookAppointment(Appointment appointment, String usernumber) {
		// TODO Auto-generated method stub
		Response response = new Response();
		UserRequest user = userRepository.findByUsernumber(usernumber);
		if(user != null) {
			//			if(appointment.getUserRequest() != null ) {
			//				UserRequest userRequest = appointment.getUserRequest();
			//				if(user.getUsernumber().equals(userRequest.getUsernumber()))
			//			}
			String appointmentNumber =  UserRequestIDGenerator.generateUserID();
			appointment.setAppintmentNumber(appointmentNumber);
			appointment.setUserRequest(user);
			appointment.setStatus(Constants.NEW);
			appointmentRepository.save(appointment);
			response.setMsg("Appointment Booked.");
		}
		return response;
	}

}
