package com.tutorial.rabbitmq.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class WorkerListener {

	@RabbitListener(queues = "primitive-string-queue")
	public void workerStringListener(String in) {
		log.info("workerStringListener receive= " + in);
	}

	@RabbitListener(queues = "primitive-number-queue")
	public void workerNumberListener(int in) {
		log.info("workerNumberListener receive= " + in);
	}
	
	@RabbitListener(queues = "primitive-reference-queue")
	public void workerReferenceListener(Map<String,Object> in) {
		log.info("workerReferenceListener receive= " + in.toString());
	}
}
