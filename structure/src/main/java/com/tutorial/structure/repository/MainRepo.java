package com.tutorial.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.structure.entity.MainEntity;

@Repository
public interface MainRepo extends JpaRepository<MainEntity, Long> {

}
