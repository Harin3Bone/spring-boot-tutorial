package com.tutorial.handler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.handler.model.RequestModel;
import com.tutorial.handler.model.ResponseModel;
import com.tutorial.handler.service.MainService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@ResponseStatus(code = HttpStatus.CREATED)
public class PostController {

	@Autowired
	MainService mainService;

	@PostMapping(value = "/simple")
	public ResponseModel reqPostApi() {
		return new ResponseModel("Request POST [Simple]", "");
	}

	@PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel reqPostJsonApi(@RequestBody RequestModel body) {
		return new ResponseModel("Request POST [JSON]", body);
	}

	@PostMapping(value = "/multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseModel reqPostMultipartApi(@RequestPart(name = "file") MultipartFile file) {
		return new ResponseModel("Request POST [Multipart/Form-data]", file.getOriginalFilename());
	}

}
