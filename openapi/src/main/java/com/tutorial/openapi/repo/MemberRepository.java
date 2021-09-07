package com.tutorial.openapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.openapi.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
