package com.exponent.happ.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.exponent.happ.dto.ResponseDto;
import com.exponent.happ.entity.UserRequest;
import com.exponent.happ.repo.UserRepository;
import com.exponent.happ.service.UserServiceI;
import com.exponent.happ.util.UserRequestIDGenerator;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ResponseDto addUserRequest(UserRequest userRequest) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = new ResponseDto();
		UserRequest userRequest2 = null;
//		UserRequest userRequest3 = userRepository.findByEmail(userRequest.getEmail());
//		System.out.println("User  3  Calling : " + userRequest3);
//		if(userRequest3 == null  && !(userRequest.getEmail() == null)) {
//			System.out.println("User3 Calling");
			if(userRequest != null) {
				System.out.println("Userid Calling");
				String userId = UserRequestIDGenerator.generateUserID();
				userRequest.setUsernumber(userId);
				userRequest2 = userRepository.save(userRequest);
			}
			if(userRequest2 != null && userRequest2.getId() > 0 ) {
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


				javaMailSender.send(message);
				return responseDto;
			}else {
				System.out.println("User success Calling");
				responseDto.setMsg("User Not Successfully Registered.");
				return responseDto;
			}
			
//		}else {
//			System.out.println("User all Calling");
//			responseDto.setMsg("User all Ready Registered.");
//			return responseDto;
//		}

	}

}
