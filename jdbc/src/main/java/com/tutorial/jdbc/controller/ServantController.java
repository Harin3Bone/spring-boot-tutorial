package com.tutorial.jdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.jdbc.entity.ServantEntity;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getServantById(@PathVariable(name = "id") String id){
		Map<String,Object> res = servantService.getServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Object> createdService(@RequestBody ServantEntity body){
		servantService.createdServant(body);
		return ResponseEntity.status(HttpStatus.CREATED).body("create servant success");
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Object> updateServantById(@RequestBody ServantEntity body){
		servantService.updateServantById(body);
		return ResponseEntity.status(HttpStatus.OK).body("update servant success");
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<Object> deleteAllServant(){
		servantService.deleteAllServant();
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteServantById(@PathVariable(name = "id") String id){
		servantService.deleteServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}
	
}
