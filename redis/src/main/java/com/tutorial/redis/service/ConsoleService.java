package com.tutorial.redis.service;

import java.util.List;
import java.util.Optional;

import com.tutorial.redis.model.ConsoleModel;

public interface ConsoleService {

	List<ConsoleModel> getAllConsole();

	ConsoleModel getConsoleById(long id);

	ConsoleModel createConsole(ConsoleModel model);

	Optional<ConsoleModel> updateConsole(long id, ConsoleModel model);

	boolean deleteConsole(long id);
}
