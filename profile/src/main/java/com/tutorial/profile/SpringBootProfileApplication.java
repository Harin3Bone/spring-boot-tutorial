package com.tutorial.profile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootProfileApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootProfileApplication.class).profiles("dev", "prod").run(args);
	}

}
