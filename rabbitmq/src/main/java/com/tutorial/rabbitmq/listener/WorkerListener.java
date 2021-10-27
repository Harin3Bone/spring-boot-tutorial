package com.tutorial.rabbitmq.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.tutorial.rabbitmq.entity.TransactionEntity;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class WorkerListener {

	@RabbitListener(queues = "worker-string-queue")
	public void workerStringListener(String in) {
		log.info("workerStringListener receive= " + in);
	}

	@RabbitListener(queues = "worker-number-queue")
	public void workerNumberListener(int in) {
		log.info("workerNumberListener receive= " + in);
	}
	
	@RabbitListener(queues = "worker-reference-queue")
	public void workerNumberListener(Map<String,Object> in) {
		log.info("workerNumberListener receive= " + in.toString());
	}
	
	@RabbitListener(queues = "worker-object-queue")
	public void workerObjectListener(TransactionEntity in) {
		log.info("workerObjectListener receive= " + in.toString());
	}
}
