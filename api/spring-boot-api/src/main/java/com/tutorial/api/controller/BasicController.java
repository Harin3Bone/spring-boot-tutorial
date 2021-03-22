package com.tutorial.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/basic")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BasicController {

	@GetMapping(value = "")
	public ResponseEntity<Object> getMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping");
	}
	
	@GetMapping(value = "/path/{value}")
	public ResponseEntity<Object> getMappingPath(@PathVariable(name = "value") String value){
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping, path= " + value);
	}
	
	@GetMapping(value = "/query")
	public ResponseEntity<Object> getMappingQuery(@RequestParam(name = "value") String value){
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping, query= " + value);
	}
	
	@GetMapping(value = "/header")
	public ResponseEntity<Object> getMappingHeader(@RequestHeader(name = "value") String value){
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping, header= " + value);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Object> postMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping");
	}
	
	@PostMapping(value = "/object")
	public ResponseEntity<Object> postMappingObj(@RequestBody Map<String,Object> body){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, JSONObject= " + body.toString());
	}
	
	@PostMapping(value = "/array")
	public ResponseEntity<Object> postMappingArr(@RequestBody List<Map<String,Object>> body){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, JSONArray= " + body.toString());
	}
	
	@PostMapping(value = "/multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> postMappingMultipart(@RequestParam(name = "file") MultipartFile file){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, Multipartfile");
	}
	
	@PostMapping(value = "/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> postMappingConsumes(@RequestBody Map<String,Object> body){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, Consumes= " + MediaType.APPLICATION_JSON);
	}
	
	@PostMapping(value = "/produces", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Object> postMappingProduces(@RequestBody Map<String,Object> body){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, Produces= " + MediaType.TEXT_PLAIN);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Object> putMapping(@RequestBody List<Map<String,Object>> body){
		return ResponseEntity.status(HttpStatus.OK).body("PostMapping, JSONArray= " + body.toString());
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Object> deleteMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("DeleteMapping");
	}
	
	@PatchMapping(value = "")
	public ResponseEntity<Object> patchMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("PatchMapping");
	}
	
}
