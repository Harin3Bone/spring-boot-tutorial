package com.tutorial.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicQueue {

	@Bean
	public Queue topicStringQueue() {
		return new Queue("topic-string-queue", false);
	}

	@Bean
	public Queue topicNumberQueue() {
		return new Queue("topic-number-queue", false);
	}

	@Bean
	public Queue topicReferenceQueue() {
		return new Queue("topic-reference-queue", false);
	}

	@Bean
	public Queue topicObjectQueue() {
		return new Queue("topic-object-queue", false);
	}
	
	@Bean
	public Queue topicMatchQueue() {
		return new Queue("topic-all-queue", false);
	}


	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topic-exchange");
	}

	@Bean
	public Binding topicAllBinding(Queue topicMatchQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicMatchQueue).to(exchange).with("*-string-*");
	}

	@Bean
	public Binding topicStringBinding(Queue topicNumberQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicNumberQueue).to(exchange).with("topic-string-*");
	}

	@Bean
	public Binding topicNumberBinding(Queue topicReferenceQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicReferenceQueue).to(exchange).with("topic-number-*");
	}

	@Bean
	public Binding topicReferenceBinding(Queue topicStringQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicStringQueue).to(exchange).with("topic-reference-*");
	}

	@Bean
	public Binding topicObjectBinding(Queue topicObjectQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicObjectQueue).to(exchange).with("topic-object-*");
	}
}
