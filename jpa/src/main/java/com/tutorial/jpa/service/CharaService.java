package com.tutorial.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.jpa.entity.CharaEntity;
import com.tutorial.jpa.repository.CharaRepository;

@Service
public class CharaService {

	@Resource
	private CharaRepository charaRepo;

	public List<CharaEntity> findAllChara() {
		try {
			return charaRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public CharaEntity findCharaById(long id) {
		try {
			return charaRepo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void createChara(CharaEntity chara) {
		try {
			charaRepo.save(chara);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateChara(CharaEntity chara) {
		try {
			CharaEntity defChara = charaRepo.findById(chara.getId()).get();

			defChara.setName(chara.getName());
			defChara.setClss(chara.getClss());
			defChara.setLabel(chara.getLabel());
			defChara.setLv(chara.getLv());
			
			charaRepo.save(defChara);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void deleteAllChara() {
		try {
			charaRepo.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteCharaById(long id) {
		try {
			charaRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
