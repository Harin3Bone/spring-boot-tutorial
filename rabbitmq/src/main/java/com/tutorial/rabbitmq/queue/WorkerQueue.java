package com.tutorial.rabbitmq.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class WorkerQueue {

	@Bean
	public Queue workerStringQueue() {
		return new Queue("worker-string-queue", false);
	}
	
	@Bean
	public Queue workerNumberQueue() {
		return new Queue("worker-number-queue", false);
	}
	
	@Bean
	public Queue workerReferenceQueue() {
		return new Queue("worker-reference-queue", false);
	}
	
	@Bean
	public Queue workerObjectQueue() {
		return new Queue("worker-object-queue", false);
	}
}
