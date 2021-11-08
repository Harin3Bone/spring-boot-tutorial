package com.tutorial.redis.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tutorial.redis.model.ConsoleModel;
import com.tutorial.redis.repository.ConsoleRepository;
import com.tutorial.redis.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {

	@Resource
	ConsoleRepository consoleRepo;

	@Override
	@Cacheable(value = "consoles", key = "", unless = "#result==null")
	public List<ConsoleModel> getAllConsole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Cacheable(value = "console", key = "#id", unless = "#result==null")
	public ConsoleModel getConsoleById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createConsole(ConsoleModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	@CachePut(value = "console", key = "#id")
	public void updateConsole(long id, ConsoleModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	@CacheEvict(value = "console", key = "#id")
	public void deleteConsole(long id) {
		// TODO Auto-generated method stub

	}

}
