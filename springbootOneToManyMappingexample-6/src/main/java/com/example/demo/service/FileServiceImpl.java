package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repo.FileRepository;

@Service
public class FileServiceImpl implements FileServicei{

	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public void uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		FileData fileData = new FileData();
		fileData.setFileName(file.getOriginalFilename());
		fileData.setFileType(file.getContentType());
		fileData.setFileSize(file.getSize());
		try {
			fileData.setFileData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileRepository.save(fileData);
		
	}

}
