package com.exponent.happ.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.exponent.happ.dto.ResponseDto;
import com.exponent.happ.dto.UserRequestDto;
import com.exponent.happ.entity.Appointment;
import com.exponent.happ.entity.Login;
import com.exponent.happ.entity.Role;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.AppointmentRepository;
import com.exponent.happ.repo.LoginRepository;
import com.exponent.happ.repo.RoleRepository;
import com.exponent.happ.repo.UserRepository;
import com.exponent.happ.service.UserServiceI;
import com.exponent.happ.util.UserRequestIDGenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;


	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseDto addUserRequest(Login login) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = new ResponseDto();
		Login login2 = null;
		if(login.getEmail() == null) {
			System.out.println("User Email Null Calling");
			responseDto.setMsg("User Can not be null.");
			return responseDto;
		}
		Login login1 = loginRepository.findByEmail(login.getEmail());
		System.out.println("User  3  Calling : " + login1);
		if(login1 != null) {
			System.out.println("User Email Null Calling");
			responseDto.setMsg("User already Exist.");
			return responseDto;
		}
		System.out.println("User3 Calling");

		System.out.println("Userid Calling");
		String userId = UserRequestIDGenerator.generateUserID();
		login.getUserRequest().setUsernumber(userId);
		login.getUserRequest().setStatus(true);
		Role role = roleRepository.findById(2).get();
		login.getUserRequest().setRole(role);
		login2 = loginRepository.save(login);

		if(login2 != null && login2.getId() > 0 ) {
			System.out.println("User success Calling");
			responseDto.setMsg("User Successfully Registered.");
			//Mail Sending Code .
			SimpleMailMessage message = new SimpleMailMessage();

			message.setTo("ajasshaikh8390@gmail.com","andhalekrushna101@gmail.com");

			message.setSubject("Thanks For Creating Account.");

			message.setText("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <title>Document</title>\r\n" + 
					"</head>\r\n" + 
					"<body style=\"background-color: red;\">\r\n" + 
					"    <h1>Hello Hi</h1>\r\n" + 
					"    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto voluptatem incidunt eum sit debitis odit? Mollitia dolore at dicta culpa voluptatibus, doloremque sapiente. Aliquid debitis voluptatibus fugit, veniam repudiandae ut!</p>\r\n" + 
					"</body>\r\n" + 
					"</html>");


			//javaMailSender.send(message);
			return responseDto;
		}else {
			System.out.println("User success Calling");
			responseDto.setMsg("User Not Successfully Registered.");
			return responseDto;
		}

	}

	@Override
	public UserRequest getUserRequest(String usernumber) {
		// TODO Auto-generated method stub
		UserRequest user = userRepository.findByUsernumber(usernumber);
		log.debug("fetched User Request data : " + user);
		return userRepository.findByUsernumber(usernumber);
	}

	@Override
	public UserRequestDto getUserReuestAppointmentData(String usernumber) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = appointmentRepository.findByUserRequestUsernumber(usernumber);
		log.debug("Appointment List : " + appointments);
		return null;
	}

}
