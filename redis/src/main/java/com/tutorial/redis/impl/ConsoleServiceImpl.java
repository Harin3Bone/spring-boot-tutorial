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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsoleModel getConsoleById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createConsole(ConsoleModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConsole(ConsoleModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConsole(long id) {
		// TODO Auto-generated method stub
		
	}

}
