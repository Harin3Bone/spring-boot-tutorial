package com.tutorial.openapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.openapi.entity.MemberEntity;
import com.tutorial.openapi.impl.MemberServiceImpl;
import com.tutorial.openapi.util.ResponseUtil;

@RestController
@RequestMapping(value = "/member")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MemberController {

	@Autowired
	MemberServiceImpl memberService;

	@GetMapping(value = "")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil getAllMember() {
		var res = memberService.getAllMember();
		return new ResponseUtil("Get all member success.", res);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil getAllMemberById(@PathVariable(name = "id") long id) {
		var res = memberService.getMemberById(id);
		return new ResponseUtil("Get all member success.", res);
	}

	@PostMapping(value = "")
	public ResponseUtil createMember(@RequestBody MemberEntity body) {
		memberService.createMember(body);
		return new ResponseUtil("Create member success.", new HashMap<String, String>());
	}

	@PutMapping(value = "")
	public ResponseUtil updateMember(@RequestBody MemberEntity body) {
		memberService.updateMember(body);
		var res = memberService.getMemberById(body.getId());
		return new ResponseUtil("Update member success.", res);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil deleteAllMemberById(@PathVariable(name = "id") long id) {
		memberService.deleteMemberById(id);
		return new ResponseUtil("Delete member success.", new HashMap<String, String>());
	}
}
