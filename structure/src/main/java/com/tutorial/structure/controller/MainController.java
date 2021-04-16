package com.tutorial.structure.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.structure.service.MainService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MainController {
	
	@Autowired
	private MainService mainService;

	@RequestMapping(value = "main")
	public ResponseEntity<Object> mainApi(){
		Map<String,Object> res = mainService.resMainApi();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
