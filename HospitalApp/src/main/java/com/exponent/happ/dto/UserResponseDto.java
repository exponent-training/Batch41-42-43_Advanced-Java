package com.exponent.happ.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

	private String usernumber;
	
	private String firstname;
	
	private String lastname;
	
	private String mobNumber;
	
	private String email;
	
	private String errorMsg;

}
