package com.tutorial.profile.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@Profile(value = { "local" })
public class LocalRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		log.info("Running in 'Local' profile.");
	}
}
