package com.tutorial.test.impl;

import org.springframework.stereotype.Service;

import com.tutorial.test.service.CalculateService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CalculateImpl implements CalculateService {

	@Override
	public int sum(int x, int y) {
		log.info("sum: x= " + x + ", y= " + y);
		return x + y;
	}

	@Override
	public int substract(int x, int y) {
		log.info("substract: x= " + x + ", y= " + y);
		return x - y;
	}

	@Override
	public int multiply(int x, int y) {
		log.info("multiply: x= " + x + ", y= " + y);
		return x * y;
	}

	@Override
	public int divide(int x, int y) {
		log.info("divide: x= " + x + ", y= " + y);
		return x / y;
	}

	@Override
	public int modular(int x, int y) {
		log.info("modular: x= " + x + ", y= " + y);
		return x % y;
	}

}
