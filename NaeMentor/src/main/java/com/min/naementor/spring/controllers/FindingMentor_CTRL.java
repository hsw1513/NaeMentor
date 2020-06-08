package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.FindingMentorDto;
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
	@RequestMapping(value = "detailContent.do", method = RequestMethod.GET)
	public String detailContent(Model model, String memberseq, String boardseq) {
		log.info("{}, {}",memberseq, boardseq);
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		model.addAttribute("detail", service.detailContent(map));
		return "FindingMentor/detailContent";
	}
	@RequestMapping("deleteContent.do")
	public String deleteContent(String boardseq, String memberseq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq",boardseq);
		map.put("memberseq",memberseq);
		service.deleteContent(map);
		return "redirect:/FindingMentor_board.do";
	}
	@RequestMapping(value="modifyContent.do", method = RequestMethod.POST)
	public String modifyContent(FindingMentorDto dto) {
		log.info("{}",dto);
		service.modifyContent(dto);
		return "redirect:/FindingMentor_board.do";
	}
}
