package com.tutorial.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springboot.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
