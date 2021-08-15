package com.tutorial.jpa.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.jpa.entity.CharaEntity;
import com.tutorial.jpa.repository.CharaRepository;
import com.tutorial.jpa.service.CharaService;

@Service
public class CharaServiceImpl implements CharaService {

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
			Optional<CharaEntity> opt = charaRepo.findById(id);
			return opt.isPresent() ? opt.get() : new CharaEntity();
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
			Optional<CharaEntity> opt = charaRepo.findById(chara.getId());
			if (opt.isPresent()) {
				CharaEntity data = opt.get();
				
				data.setName(chara.getName());
				data.setClss(chara.getClss());
				data.setLabel(chara.getLabel());
				data.setLv(chara.getLv());
				
				charaRepo.save(data);
			}
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
