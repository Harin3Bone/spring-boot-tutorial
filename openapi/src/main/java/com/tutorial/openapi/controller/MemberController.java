package com.tutorial.openapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

}
