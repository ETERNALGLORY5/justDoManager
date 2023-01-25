package com.todo.justdo.controllers;

import java.util.Arrays;

//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(FileController.class);

	@PostMapping("/single")
	public String uploadSingleFile(@RequestParam("image") MultipartFile file) 
	{
		
		logger.info("Name ; {}",file.getName());
		logger.info("Content Type {}",file.getContentType());
		logger.info("Original File Name {}",file.getOriginalFilename());
		logger.info("File Size {}",file.getSize());
		//logger.info("File Byte {}",file.getBytes());
		
//		InputStream inputStream = file.getInputStream(); 
//		FileOutputStream fileOutputStream = new  fileOutputStream("data.png");
//		//byte data[] =  new byte[inputStream.available()];
//		fileOutputStream.write(data);
		
		return"File Test";
	}
	
	@PostMapping("/multiple")
	public String  uploadMultiple(@RequestParam("files") MultipartFile[] files)
	{
		Arrays.stream(files).forEach(file -> {
			logger.info("File name{} ",file.getOriginalFilename());
			logger.info("File Type {} ",file.getContentType());
		});
		
		
		return "Hamdling Multiple files";
	}
}
