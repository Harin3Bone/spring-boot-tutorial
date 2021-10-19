package com.tutorial.rabbitmq.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.tutorial.rabbitmq.entity.TransactionEntity;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class TopicListener {
	
	@RabbitListener(queues = "topic-string-queue")
	public void topicStringListener(String in) {
		log.info("topicStringListener receive= " + in);
	}

	@RabbitListener(queues = "topic-number-queue")
	public void topicNumberListener(int in) {
		log.info("topicNumberListener receive= " + in);
	}

	@RabbitListener(queues = "topic-reference-queue")
	public void topicNumberListener(Map<String, Object> in) {
		log.info("topicNumberListener receive= " + in.toString());
	}

	@RabbitListener(queues = "topic-object-queue")
	public void topicObjectListener(TransactionEntity in) {
		log.info("topicObjectListener receive= " + in.toString());
	}
	
//	@RabbitListener(queues = "matchtopic-string-queue")
//	public void topicMatchStringListener(String in) {
//		log.info("topicMatchStringListener receive= " + in);
//	}
}
