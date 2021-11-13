package com.tutorial.test.model;

import lombok.Data;

@Data
public class CalculatorModel {

	private final StudentModel student;
	
	public CalculatorModel(StudentModel student) {
		this.student = student;
	}
	
	public String displayStudent() {
		return "This calculator owner by " + student.getName();
	}
}
