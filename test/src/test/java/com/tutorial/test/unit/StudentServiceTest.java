package com.tutorial.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tutorial.test.model.CalculatorModel;
import com.tutorial.test.model.StudentModel;

@ExtendWith(MockitoExtension.class)
@DisplayName("StudentService")
class StudentServiceTest {

	@Mock
	StudentModel student;

	@InjectMocks
	CalculatorModel calculator;

	@Test
	@DisplayName("Owner")
	void printOwnerName() {
		Mockito.when(student.getName()).thenReturn("Emma");

		String msg = calculator.displayStudent();

		assertEquals("This calculator owner by Emma", msg);
	}
}
