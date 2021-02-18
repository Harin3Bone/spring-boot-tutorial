package com.tutorial.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
