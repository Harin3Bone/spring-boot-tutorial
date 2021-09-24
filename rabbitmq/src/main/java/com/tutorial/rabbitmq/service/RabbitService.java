package com.tutorial.rabbitmq.service;

public interface RabbitService {

	void publishWorkerValueQueue(String value);
	
	void publishWorkerValueQueue(int value);
}
