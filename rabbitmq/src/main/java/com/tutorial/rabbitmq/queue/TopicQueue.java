package com.tutorial.rabbitmq.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class TopicQueue {

	@Bean
	public Queue topicStringQueue() {
		return new Queue("primitive-string-queue", false);
	}
	
	@Bean
	public Queue topicNumberQueue() {
		return new Queue("primitive-number-queue", false);
	}
	
	@Bean
	public Queue topicReferenceQueue() {
		return new Queue("non-primitive-reference-queue", false);
	}
	
	@Bean
	public Queue topicObjectQueue() {
		return new Queue("non-primitive-object-queue", false);
	}
}
