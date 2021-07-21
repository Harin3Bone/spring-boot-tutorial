package com.tutorial.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootJdbcPatternApplication {

	public static void main(String[] args) {	
		SpringApplication.run(SpringBootJdbcPatternApplication.class, args);
	}

}
