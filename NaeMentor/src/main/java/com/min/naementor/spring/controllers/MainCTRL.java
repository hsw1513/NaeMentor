package com.min.naementor.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCTRL {

	@RequestMapping("index.do")
	public String index() {
		return "index";
	}
}
