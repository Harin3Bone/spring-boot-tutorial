package com.tutorial.rabbitmq.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.tutorial.rabbitmq.entity.TransactionEntity;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class TopicListener {

	@RabbitListener(queues = "primitive-string-queue")
	public void topicStringListener(String in) {
		log.info("topicStringListener receive= " + in);
	}

	@RabbitListener(queues = "primitive-number-queue")
	public void topicNumberListener(int in) {
		log.info("topicNumberListener receive= " + in);
	}
	
	@RabbitListener(queues = "non-primitive-reference-queue")
	public void topicNumberListener(Map<String,Object> in) {
		log.info("topicNumberListener receive= " + in.toString());
	}
	
	@RabbitListener(queues = "non-primitive-object-queue")
	public void topicObjectListener(TransactionEntity in) {
		log.info("topicObjectListener receive= " + in.toString());
	}
}
