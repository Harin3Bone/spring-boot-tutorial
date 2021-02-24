package com.tutorial.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category GET, POST, PUT, DELETE Example
 */

@RestController
@RequestMapping(value = "/basic")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BasicController {

	@GetMapping(value = "/simple")
	public ResponseEntity<Object> getMapping() {
		System.out.println("GetMapping");
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping success");
	}

	@GetMapping(value = "/path/{path}")
	public ResponseEntity<Object> getMappingWithPath(@PathVariable(name = "path") String pathParam) {
		System.out.println("GetMapping pathParam = " + pathParam);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [PathParam] success, @PathVariable = " + pathParam);
	}

	@GetMapping(value = "query")
	public ResponseEntity<Object> getMappingWithQuery(@RequestParam(name = "query") String queryParam) {
		System.out.println("GetMapping queryParam = " + queryParam);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [QueryParam] success, @RequestParam = " + queryParam);
	}

	@GetMapping(value = "header")
	public ResponseEntity<Object> getMappingWithHeader(@RequestHeader(name = "header") String requestHeader) {
		System.out.println("GetMapping requestHeader =" + requestHeader);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [RequestHeader] success, @RequestHeader = " + requestHeader);
	}

	@PostMapping(value = "/simple")
	public ResponseEntity<Object> postMapping() {
		System.out.println("PostMapping success");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping success");
	}

	@PostMapping(value = "/body/obj")
	public ResponseEntity<Object> postMappingWithObj(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with JSONObject");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONObject, Body = " + body);
	}

	@PostMapping(value = "/body/arr")
	public ResponseEntity<Object> postMappingWithArr(@RequestBody List<Object> body) {
		System.out.println("PostMapping with JSONArray");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONArray, Body = " + body);
	}

	@PostMapping(value = "/consumes", consumes = "application/json")
	public ResponseEntity<Object> postMappingByConsume(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with Consumes application/json");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with Consumes application/json");
	}

	@PostMapping(value = "/produces", produces = "application/json")
	public ResponseEntity<Object> postMappingByProduce(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with Produces application/json");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with Produces application/json");
	}
	
	@PostMapping(value = "/multipart", produces = "multipart/form-data")
	public ResponseEntity<Object> postMappingByMultipart(@RequestParam(name = "file") MultipartFile file) {
		System.out.println("PostMapping with Produces multipart/form-data");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with Produces multipart/form-data");
	}

	@PutMapping(value = "/simple")
	public ResponseEntity<Object> putMapping() {
		System.out.println("PutMapping success");
		return ResponseEntity.status(HttpStatus.OK).body("PutMapping success");
	}

	@PutMapping(value = "/body", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putMappingWithBody(@RequestBody Map<String, Object> body) {
		System.out.println("PutMapping with Body");
		return ResponseEntity.status(HttpStatus.OK).body("PutMapping with Body");
	}

	@PutMapping(value = "/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putMappingByConsumeAnotherWay(@RequestBody Map<String, Object> body) {
		System.out.println("PutMapping with Consumes MediaType.APPLICATION_JSON_VALUE");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("PutMapping with Consumes MediaType.APPLICATION_JSON_VALUE");
	}

	@PutMapping(value = "/produces", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putMappingByProduceAnotherWay(@RequestBody Map<String, Object> body) {
		System.out.println("PutMapping with Produces MediaType.APPLICATION_JSON_VALUE");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("PutMapping with Produces MediaType.APPLICATION_JSON_VALUE");
	}

	@DeleteMapping(value = "/simple")
	public ResponseEntity<Object> deleteMapping() {
		System.out.println("DeleteMapping success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping success");
	}

	@DeleteMapping(value = "/path", params = "data")
	public ResponseEntity<Object> deleteMappingWithParam(@RequestParam("data") String data) {
		System.out.println("DeleteMapping with Param success");
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping with Param success, data= " + data);
	}
}
