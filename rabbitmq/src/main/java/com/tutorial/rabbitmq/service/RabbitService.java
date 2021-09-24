package com.tutorial.rabbitmq.service;

import java.util.Map;

public interface RabbitService {

	void publishWorkerValueQueue(String value);
	
	void publishWorkerValueQueue(int value);
	
	void publishWorkerReferenceQueue(Map<String,Object> value);
}
