package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category DELETE Example
 */

@RestController
public class DeleteController {

	/**
	 * @apiNote http://localhost:3000/simple
	 * @response text/plain
	 */
	@DeleteMapping(value = "/simple")
	public ResponseEntity<Object> deleteMapping() {
		System.out.println("DeleteMapping success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping success");
	}

	/**
	 * @apiNote http://localhost:3000/simple?data=123
	 * @response text/plain
	 */
	@DeleteMapping(value = "/path", params = "data")
	public ResponseEntity<Object> deleteMappingWithParam(@RequestParam("data") String data) {
		System.out.println("DeleteMapping with Param success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping with Param success, data= " + data);
	}
}
