package com.min.naementor.spring.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.spring.model.notiquestion.Notiquestion_IService;

@Controller
public class Question_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IService service;
	
	@RequestMapping("Question_board.do")
	public String quesboard(Model model, HttpSession session) {
		log.info("quesboard quesboardMain:\t {}", new Date());
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		if(ndto.getAuth().equals("ROLE_A")) {
			model.addAttribute("lists", service.allOneToOneA());
			return "Notiquestion/Question_boardAdmin";
		}else if(ndto.getAuth().equals("ROLE_E") | ndto.getAuth().equals("ROLE_R")){
			model.addAttribute("lists", service.allOneToOneU(ndto.getMemberseq()));
			return "Notiquestion/Question_boardUser";
		}else {
			return "login/logout";
		}
	}
	
	@RequestMapping(value = "Question_boardDetail.do", method = RequestMethod.GET)
	public String quesboardDetail(Model model, String adminseq) {
		log.info("quesboard notiboardDetail:\t {}", adminseq);
		model.addAttribute("dto", service.searchOneToOne(adminseq));
		return "Notiquestion/Question_boardDetail";
	}
	
	@RequestMapping(value = "Question_boardWrite.do", method = RequestMethod.GET)
	public String quesboardWrite() {
		log.info("quesboard quesboardWrite:\t {}", new Date());
		return "Notiquestion/Question_boardWrite";
	}
	
	@RequestMapping(value="QuesWrite.do", method = RequestMethod.POST)
	public String quesWrite(NotiQuestionDto dto, HttpSession session) {
		log.info("quesboard quesWrite:\t {}", dto);
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		dto.setMemberseq(ndto.getMemberseq());
		service.insertOneToOne(dto);
		return "redirect:/Question_board.do";
	}
	
	@RequestMapping(value="Question_boardDelete.do", method = RequestMethod.GET)
	public String quesDel(String adminseq) {
		log.info("quesboard quesDel:\t", adminseq);
		service.deleteOneToOne(adminseq);
		return "redirect:/Question_board.do";
	}
	
	
}
