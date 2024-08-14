package com.exponent.happ.util;

import java.util.ArrayList;
import java.util.List;

import com.exponent.happ.dto.AppointmentDto;
import com.exponent.happ.dto.UserRequestDto;
import com.exponent.happ.entity.Appointment;
import com.exponent.happ.entity.UserRequest;

public class AllDTOConverter {
	
	public static List<AppointmentDto> convertAppointmentDto(List<Appointment> appointments){
		
		List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
		
		for(Appointment appointment : appointments) {
			appointmentDtos.add(AppointmentDto.builder()
					             .appintmentNumber(appointment.getAppintmentNumber())
					             .pname(appointment.getPname())
					             .date(appointment.getDate())
					             .time(appointment.getTime())
					             .age(appointment.getAge())
					             .gender(appointment.getGender())
					             .category(appointment.getCategory())
					             .appointedDoctor(appointment.getAppointedDoctor())
					             .referredDoctor(appointment.getReferredDoctor())
					             .location(appointment.getLocation())
					             .email(appointment.getEmail())
					             .mobileNumber(appointment.getMobileNumber())
					             .bloodGroup(appointment.getBloodGroup())
					             .visitType(appointment.getVisitType())
					             .problemHistory(appointment.getProblemHistory())
					             .build());
		}
		
		return appointmentDtos;
	}
	
	public static UserRequestDto convertUserRequestDto(UserRequest userRequest) {
		return UserRequestDto.builder()
				.usernumber(userRequest.getUsernumber())
				.firstname(userRequest.getFirstname())
				.lastname(userRequest.getLastname())
				.mobNumber(userRequest.getMobNumber())
				.build();
	}

}
