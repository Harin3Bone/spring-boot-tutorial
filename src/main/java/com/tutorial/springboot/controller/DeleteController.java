package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

	@DeleteMapping(value = "/simple")
	public ResponseEntity<Object> deleteMapping(){
		System.out.println("DeleteMapping success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping success");
	}
	
	@DeleteMapping(value = "/path",params = "data")
	public ResponseEntity<Object> deleteMappingWithParam(@RequestParam("data") String data){
		System.out.println("DeleteMapping with Param success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping with Param success, data= " + data);
	}
}
