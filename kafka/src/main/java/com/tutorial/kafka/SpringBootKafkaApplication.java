package com.tutorial.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableConfigurationProperties
@EnableKafka
public class SpringBootKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

}
