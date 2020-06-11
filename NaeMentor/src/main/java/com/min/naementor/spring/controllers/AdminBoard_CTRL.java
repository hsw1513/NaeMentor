package com.min.naementor.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminBoard_CTRL {

	// 관리자 페이지로 이동
	@RequestMapping(value = "/adminBoard.do", method = RequestMethod.GET)
	public String goAdmin() {
		return "AdminBoard/adminPage";
	}
	
	
	
	
	
	
	
}