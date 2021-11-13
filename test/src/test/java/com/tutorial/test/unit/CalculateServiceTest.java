package com.tutorial.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tutorial.test.impl.CalculateImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("CalculateService")
class CalculateServiceTest {

	@InjectMocks
	private CalculateImpl calculateService;

	@Test
	@DisplayName("Sum")
	void sumTest() {
		var res = calculateService.sum(10, 10);
		assertEquals(20, res);
	}

	@Test
	@DisplayName("Substract")
	void subTest() {
		var res = calculateService.substract(10, 10);
		assertEquals(0, res);
	}

	@Test
	@DisplayName("Multiple")
	void mulTest() {
		var res = calculateService.multiply(10, 10);
		assertEquals(100, res);
	}

	@Test
	@DisplayName("Divide")
	void divTest() {
		var res = calculateService.divide(10, 10);
		assertEquals(1, res);
	}

	@Test
	@DisplayName("Modular")
	void modTest() {
		var res = calculateService.modular(10, 10);
		assertEquals(0, res);
	}
}
