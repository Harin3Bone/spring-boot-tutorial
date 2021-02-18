package com.tutorial.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.springboot.entity.Student;
import com.tutorial.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Resource
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		List<Student> data = studentRepository.findAll();
		return data;
	}

	public Student getStudentById(long id) {
		Optional<Student> opData = studentRepository.findById(id);
		Student data = opData.get();
		return data;
	}

}
