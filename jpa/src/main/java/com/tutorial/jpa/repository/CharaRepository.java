package com.tutorial.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.jpa.entity.CharaEntity;

@Repository(value = "charaRepository")
public interface CharaRepository extends JpaRepository<CharaEntity, Long> {

}
