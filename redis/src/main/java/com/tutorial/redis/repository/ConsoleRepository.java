package com.tutorial.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.redis.model.ConsoleModel;

@Repository(value = "consoleRepository")
public interface ConsoleRepository extends JpaRepository<ConsoleModel, Long>  {

}
