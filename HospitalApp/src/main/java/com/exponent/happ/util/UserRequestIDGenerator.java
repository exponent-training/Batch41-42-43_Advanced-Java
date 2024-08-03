package com.exponent.happ.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserRequestIDGenerator {

	
	 public static String generateUserID() {
	        LocalDateTime now = LocalDateTime.now();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
	        String dateString = now.format(formatter);

	        Random random = new Random();
	        int i = random.nextInt(9999)+100;
	        String userId = dateString+i;
	        System.out.println(userId);
	        return userId;
	 }
	
	
}
