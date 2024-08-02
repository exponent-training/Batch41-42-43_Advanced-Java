package com.example.demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileServicei;

@RestController
public class FileController {
	
	
	@Autowired
	private FileServicei fileServicei;
	
	@GetMapping(value = "/upload")
	public String uploadFile(@RequestPart MultipartFile file,HttpServletRequest request) {
		String path = request.getContextPath();
		String str2 = request.getRemoteAddr();
		String str = request.getServerName();
//		ServletContext str1 = request.getServletContext();
		System.out.println(str2);
		System.out.println(str);
		System.out.println("Check file Data : " + file.getName());
		System.out.println("Check file Data : " + file.getOriginalFilename());
		fileServicei.uploadFile(file);
		return "File Uploaded.";
	}

}
