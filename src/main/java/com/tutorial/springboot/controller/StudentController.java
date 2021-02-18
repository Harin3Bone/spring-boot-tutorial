package com.tutorial.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.entity.Student;
import com.tutorial.springboot.model.TemplateResModel;
import com.tutorial.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students")
	public ResponseEntity<Object> getAllStudent() {
		List<Student> data = studentService.getAllStudent();
		String message = "Success with " + data.size() + " row(s)";

		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, data);
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") long id){
		Student data = studentService.getStudentById(id);
		String message = "Success found id " + data.getId();

		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, data);
		return ResponseEntity.ok().body(res);		
	}
}
