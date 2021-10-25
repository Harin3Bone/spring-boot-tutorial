package com.tutorial.rabbitmq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tutorial.rabbitmq.impl.TopicImpl;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class TopicListener {
	
	@Autowired
	TopicImpl topicService;
	
//	@RabbitListener(queues = "topic-string-small")
//	public void topicStringListenerSmall(String in) {
//		log.info("topicStringListenerSmall receive= " + in);
//	}
//
//	@RabbitListener(queues = "topic-string-large")
//	public void topicStringListenerLarge(String in) {
//		log.info("topicStringListenerLarge receive= " + in);
//	}
}
