package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

		try {
			fileUploadOnServerPath(file.getBytes(),file.getOriginalFilename());
			fileData.setFileName(file.getOriginalFilename());
			fileData.setFileType(file.getContentType());
			fileData.setFileSize(file.getSize());
			fileData.setFileData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fileRepository.save(fileData);

	}


	private String fileUploadOnServerPath(byte[] filedata,String filename) {

		int i = filename.lastIndexOf(".");
	
        String ext = filename.substring(i);
        
		System.out.println(ext);
		
		Path path = Paths.get("D:"+File.separator+"Demo"+File.separator+"public"+ext);

		try {
			Files.write(path, filedata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "File Writing done on server";
	}

}
