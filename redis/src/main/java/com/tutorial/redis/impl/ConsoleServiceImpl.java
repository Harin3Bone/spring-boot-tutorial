package com.tutorial.redis.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.redis.model.ConsoleModel;
import com.tutorial.redis.repository.ConsoleRepository;
import com.tutorial.redis.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {

	@Resource
	ConsoleRepository consoleRepo;

	@Override
	public List<ConsoleModel> getAllConsole() {
		
		return null;
	}

	@Override
	public ConsoleModel getConsoleById() {
		
		return null;
	}

	@Override
	public void createConsole() {
		
	}

	@Override
	public void updateConsole() {
		
	}

	@Override
	public void deleteConsole() {
		
	}
}
