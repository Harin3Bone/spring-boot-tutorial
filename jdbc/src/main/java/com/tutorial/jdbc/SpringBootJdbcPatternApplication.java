package com.tutorial.jdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootJdbcPatternApplication {

	public static void main(String[] args) {	
		new SpringApplicationBuilder(SpringBootJdbcPatternApplication.class)
//			.profiles("h2", "mysql")
//			.profiles("h2")
//			.profiles("mysql")
			.profiles("postgres")
			.run(args);
	}

}