package com.tutorial.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootOpenapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOpenapiApplication.class, args);
	}

}
