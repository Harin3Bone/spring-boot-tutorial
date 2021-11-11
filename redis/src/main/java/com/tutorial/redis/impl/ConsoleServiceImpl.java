package com.tutorial.redis.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tutorial.redis.model.ConsoleModel;
import com.tutorial.redis.repository.ConsoleRepository;
import com.tutorial.redis.service.ConsoleService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConsoleServiceImpl implements ConsoleService {

	@Resource
	ConsoleRepository consoleRepo;

	@Override
	@Cacheable(value = "consoles", key = "", unless = "#result==null")
	public List<ConsoleModel> getAllConsole() {
		log.info("getAllConsole Begin.");
		try {
			return consoleRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@Cacheable(value = "console", key = "#id", unless = "#result==null")
	public ConsoleModel getConsoleById(long id) {
		log.info("getConsoleById Begin.");
		try {
			Optional<ConsoleModel> model = consoleRepo.findById(id);
			return model.isPresent() ? model.get() : new ConsoleModel();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public ConsoleModel createConsole(ConsoleModel model) {
		log.info("createConsole Begin.");
		try {
			return consoleRepo.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	@CachePut(value = "console", key = "#id")
	public Optional<ConsoleModel> updateConsole(long id, ConsoleModel model) {
		log.info("updateConsole Begin.");
		try {
			Optional<ConsoleModel> oldModel = consoleRepo.findById(id);

			if (oldModel.isPresent()) {
				ConsoleModel updModel = oldModel.get();

				Optional<String> nameOpt = Optional.ofNullable(model.getName());
				Optional<String> comOpt = Optional.ofNullable(model.getCompany());
				updModel.setName(nameOpt.isPresent() ? nameOpt.get() : "");
				updModel.setCompany(comOpt.isPresent() ? comOpt.get() : "");

				return Optional.of(consoleRepo.save(updModel));
			} else {
				return Optional.empty();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	@CacheEvict(value = "console", key = "#id")
	public boolean deleteConsole(long id) {
		log.info("deleteConsole Begin.");
		try {
			consoleRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
