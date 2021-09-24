package com.tutorial.rabbitmq.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class WorkerQueue {

	@Bean
	public Queue workerStringQueue() {
		return new Queue("primitive-string-queue", false);
	}
	
	@Bean
	public Queue workerNumberQueue() {
		return new Queue("primitive-number-queue", false);
	}
	
	@Bean
	public Queue workerReferenceQueue() {
		return new Queue("non-primitive-reference-queue", false);
	}
	
	@Bean
	public Queue workerObjectQueue() {
		return new Queue("non-primitive-object-queue", false);
	}
}