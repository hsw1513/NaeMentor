package com.min.naementor.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.naementor.spring.model.naemember.Naemember_IService;

@Controller
public class Login_CTRL {

	@Autowired
	Naemember_IService service;
	
	@RequestMapping(value = "/index.do")
	public String login() {
		return "index";
	}
	
}
