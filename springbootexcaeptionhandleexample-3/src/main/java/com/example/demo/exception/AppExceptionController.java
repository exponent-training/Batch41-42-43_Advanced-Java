package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionController {
	
	@ExceptionHandler(ExceptionResponse.class)
	public @ResponseBody ExceptionData handleException(HttpServletRequest request, ExceptionResponse exceResponse) {
		ExceptionData data = new ExceptionData();
		data.setUrl(request.getRequestURI());
		data.setErrorMsg(exceResponse.getMessage());
		return data;
	}

	
}
