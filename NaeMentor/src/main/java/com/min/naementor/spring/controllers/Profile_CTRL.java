package com.min.naementor.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Profile_CTRL {

	@RequestMapping("/Profile.do")
	public String profile(Model model) {
		return "Profile/Profile";
	}
	
	
	
}
