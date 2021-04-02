package com.tutorial.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.h2.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
