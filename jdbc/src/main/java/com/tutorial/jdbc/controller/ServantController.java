package com.tutorial.jdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.jdbc.service.ServantService;

@RestController
@RequestMapping(value = "/servant")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class ServantController {

	@Autowired
	private ServantService servantService;
	
	@GetMapping(value = "")
	public ResponseEntity<Object> getAllServant(){
		List<Map<String,Object>> lst = servantService.getAllServant();
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}
	
}
