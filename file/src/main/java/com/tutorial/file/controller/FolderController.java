package com.tutorial.file.controller;

import java.nio.file.FileSystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.file.impl.FileServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/folder")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Log4j2
public class FolderController {

	@Autowired
	FileServiceImpl fileService;

	@PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Object> uploadFileCreateFolder(@RequestParam(name = "file") MultipartFile file)
			throws FileSystemException {
		log.info("uploadFileCreateFolder Begin.");
		fileService.saveWithFolder(file);
		log.info("uploadFileCreateFolder Finish.");
		return ResponseEntity.ok("Upload " + file.getOriginalFilename());
	}
}
