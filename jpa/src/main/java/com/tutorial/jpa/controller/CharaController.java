package com.tutorial.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.jpa.dto.CharaDTO;
import com.tutorial.jpa.entity.CharaEntity;
import com.tutorial.jpa.impl.CharaServiceImpl;

@RestController
@RequestMapping(value = "/chara")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CharaController {

	@Autowired
	private CharaServiceImpl charaService;

	@GetMapping(value = "")
	public ResponseEntity<Object> getAllChara() {
		List<CharaEntity> charaLst = charaService.findAllChara();
		return ResponseEntity.status(HttpStatus.OK).body(charaLst);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getOnceChara(@PathVariable(name = "id") long id) {
		CharaEntity chara = charaService.findCharaById(id);
		return ResponseEntity.status(HttpStatus.OK).body(chara);
	}

	@PostMapping(value = "")
	public ResponseEntity<Object> createOnceChara(@RequestBody CharaDTO body) {
		CharaEntity model = new CharaEntity(body);
		charaService.createChara(model);
		return ResponseEntity.status(HttpStatus.CREATED).body("created success");
	}

	@PutMapping(value = "")
	public ResponseEntity<Object> updateOnceChara(@RequestBody CharaDTO body) {
		CharaEntity model = new CharaEntity(body.getId(),body);
		charaService.updateChara(model);
		return ResponseEntity.status(HttpStatus.CREATED).body("update success");
	}

	@DeleteMapping(value = "")
	public ResponseEntity<Object> deleteAllChara() {
		charaService.deleteAllChara();
		return ResponseEntity.status(HttpStatus.OK).body("Delete all character success.");
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteOnceChara(@PathVariable(name = "id") long id) {
		charaService.deleteCharaById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete character id " + id + " success.");
	}
}
