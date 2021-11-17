package com.tutorial.jdbc.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@Profile(value = "multi")
public class MultiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("In Multiple-Database Profile.");
	}
}
