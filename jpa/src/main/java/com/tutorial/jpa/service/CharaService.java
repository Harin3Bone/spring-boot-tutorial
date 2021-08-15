package com.tutorial.jpa.service;

import java.util.List;

import com.tutorial.jpa.entity.CharaEntity;

public interface CharaService {

	public List<CharaEntity> findAllChara();
	
	public CharaEntity findCharaById(long id);
	
	public void createChara(CharaEntity chara);
	
	public void updateChara(CharaEntity chara);
	
	public void deleteAllChara();
	
	public void deleteCharaById(long id);
}
