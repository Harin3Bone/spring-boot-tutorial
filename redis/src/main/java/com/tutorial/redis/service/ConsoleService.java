package com.tutorial.redis.service;

import java.util.List;

import com.tutorial.redis.model.ConsoleModel;

public interface ConsoleService {

	List<ConsoleModel> getAllConsole();

	ConsoleModel getConsoleById(long id);

	void createConsole(ConsoleModel model);

	void updateConsole(long id, ConsoleModel model);

	void deleteConsole(long id);
}
