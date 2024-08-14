package com.exponent.happ.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
public class AppointmentDto {

	private String appintmentNumber;
	
	private String pname;
	
	private String date;
	
	private String time;
	
	private int age;
	
	private String gender;
	
	private String category;
	
	private String appointedDoctor;
	
	private String referredDoctor;
	
	private String location;
	
	private String mobileNumber;
	
	private String email;
	
	private String bloodGroup;
	
	private String visitType;
	
	private String problemHistory;
	
	private String zipcode;
	
	private String doctornumber;
}
