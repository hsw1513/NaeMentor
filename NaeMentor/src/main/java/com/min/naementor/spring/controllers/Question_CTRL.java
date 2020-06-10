package com.min.naementor.spring.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.model.notiquestion.Notiquestion_IService;

@Controller
public class Question_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IService service;
	
	@RequestMapping("Question_board.do")
	public String quesboard(Model model, HttpSession session) {
		log.info("notiboard quesboardMain:\t {}", new Date());
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		if(ndto.getAuth()=="A") {
			model.addAttribute("lists", service.allOneToOneA());
		}else if(ndto.getAuth()=="U"){
			model.addAttribute("lists", service.allOneToOneU(ndto.getMemberseq()));
		}
		return "Notiquestion/Question_board";
		}
}
