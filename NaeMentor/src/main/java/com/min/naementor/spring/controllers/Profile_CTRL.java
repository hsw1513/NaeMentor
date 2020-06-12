package com.min.naementor.spring.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.naementor.dtos.NaememberDto;

@Controller
public class Profile_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 프로필 페이지로 이동
	@RequestMapping("/Profile.do")
	public String profile(Model model) {
		return "Profile/Profile";
	}
	
	
	
}
