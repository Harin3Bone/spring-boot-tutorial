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
	public Queue topicStringSQueue() {
		return new Queue("topic-string-small", false);
	}
	
	@Bean
	public Queue topicStringLQueue() {
		return new Queue("topic-string-large", false);
	}
	
	@Bean
	public Queue topicStringAQueue() {
		return new Queue("topic-string-all", false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topic.exchange");
	}

	@Bean
	public Binding topicStringSBinding(Queue topicStringSQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicStringSQueue).to(exchange).with("topic.string.small");
	}
	
	@Bean
	public Binding topicStringLBinding(Queue topicStringLQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicStringLQueue).to(exchange).with("topic.string.large");
	}
	
	@Bean
	public Binding topicStringABinding(Queue topicStringAQueue, TopicExchange exchange) {
		return BindingBuilder.bind(topicStringAQueue).to(exchange).with("topic.string.*");
	}

}
