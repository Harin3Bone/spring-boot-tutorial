package com.tutorial.redis.service;

import java.util.List;

import com.tutorial.redis.model.ConsoleModel;

public interface ConsoleService {

	List<ConsoleModel> getAllConsole();
	
	ConsoleModel getConsoleById();
	
	void createConsole();
	
	void updateConsole();
	
	void deleteConsole();
}
