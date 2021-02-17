package com.tutorial.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.service.MainService;

@RestController
@RequestMapping(value = "/service")
public class MainController {

	@Autowired
	public MainService mainService;
	
	@GetMapping(value = "/simple")
	public ResponseEntity<Object> getSimpleService(){
		System.out.println("MainController.java, getSimpleService()");
		String res = mainService.getDataService();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@GetMapping(value = "/hashmap")
	public ResponseEntity<Object> getHashMapService(@RequestParam("value") String value){
		System.out.println("MainController.java, getHashMapService()");
		Map<String,Object> res = mainService.getDataMapService(value);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@PostMapping(value = "/cal")
	public ResponseEntity<Object> getCalService(@RequestBody Map<String,Object> body) {
		int valA = Integer.parseInt(body.get("valA").toString());
		int valB = Integer.parseInt(body.get("valA").toString());
		
		Map<String,Object> res = mainService.getCalService(valA, valB);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
