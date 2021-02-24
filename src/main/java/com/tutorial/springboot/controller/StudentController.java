package com.tutorial.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.entity.StudentEntity;
import com.tutorial.springboot.model.TemplateResModel;
import com.tutorial.springboot.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Harin Thananam
 * @since 18 FEB 2021
 * @category H2 Example
 */

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Tag(name = "Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Operation(summary = "Get all student")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TemplateResModel.class))) })
	@GetMapping(value = "/students")
	public ResponseEntity<Object> getAllStudent() {
		List<StudentEntity> data = studentService.getAllStudent();
		String message = "Success with " + data.size() + " row(s)";
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@Operation(summary = "Get student by Id")
	@Parameters(value = { @Parameter(name = "id", required = true, allowEmptyValue = false, example = "1") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TemplateResModel.class))) })
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") long id) {
		StudentEntity data = studentService.getStudentById(id);
		String message = "Success found id " + data.getId();
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@Operation(summary = "Create once student")
	@RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StudentEntity.class)), description = "Student data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TemplateResModel.class))) })
	@PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveStudent(@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.saveStudent(body);
		String message = "Create student success";
		HttpStatus status = HttpStatus.CREATED;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@Operation(summary = "Create list of student")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TemplateResModel.class))) })
	@PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveStudentList(
			@RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), description = "List of student data") List<StudentEntity> body) {
		List<StudentEntity> data = studentService.saveStudentListv2(body);
		String message = "Create student success " + data.size() + " row(s)";
		HttpStatus status = HttpStatus.CREATED;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@PutMapping(value = "/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateStudentById(@PathVariable("id") long id,
			@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.updateStudent(id, body);
		String message = "Update id " + data.getId() + " success";
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		String message = "Delete id " + id + " success";
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, "");
		return ResponseEntity.status(status).body(res);
	}
}
