package com.min.naementor.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;

@Controller
public class FindingMentor_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_IService service;
	
	@RequestMapping("FindingMentor_board.do")
	public String board(Model model) {
		model.addAttribute("board_lists", service.selectAll());
		return "FindingMentor/FindingMentor_board";
	}
}
