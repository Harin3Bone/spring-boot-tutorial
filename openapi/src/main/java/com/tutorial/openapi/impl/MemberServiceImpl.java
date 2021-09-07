package com.tutorial.openapi.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.openapi.entity.MemberEntity;
import com.tutorial.openapi.repo.MemberRepository;
import com.tutorial.openapi.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Resource
	MemberRepository memberRepo;

	public List<MemberEntity> getAllMember() {
		return memberRepo.findAll();
	}

	public MemberEntity getMemberById(long id) {
		try {
			var opt = memberRepo.findById(id);
			return opt.isPresent() ? opt.get() : new MemberEntity();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void createMember(MemberEntity entity) {
		memberRepo.save(entity);
	}

	public void updateMember(MemberEntity entity) {
		try {
			Optional<MemberEntity> opt = memberRepo.findById(entity.getId());
			
			if (opt.isPresent()) {
				MemberEntity data = opt.get();
				
				data.setName(entity.getName());
				data.setName(entity.getName());
				data.setJob(entity.getJob());
				data.setLang(entity.getLang());
				
				memberRepo.save(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void deleteMemberById(long id) {
		memberRepo.deleteById(id);
	}
}
