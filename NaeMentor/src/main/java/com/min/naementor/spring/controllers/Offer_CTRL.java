package com.min.naementor.spring.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.OfferDto;
import com.min.naementor.spring.model.offer.Offer_IService;

@Controller
public class Offer_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Offer_IService oservice;
	
	@RequestMapping(value = "/insertOffer.do", method = RequestMethod.POST)
	public String insertOffer(OfferDto dto, HttpServletResponse resp) {
		log.info("Offer_CTRL insertOffer \t {}",dto);
		oservice.insertOffer(dto);
		return "redirect:/FindingMentor_board.do";
	}
	@RequestMapping("/chkOffer.do")
	@ResponseBody
	public boolean chkOffer(HttpSession session, String boardseq) {
		log.info("Offer_CTRL chkOffer \t {}",boardseq);
		NaememberDto dto = (NaememberDto) session.getAttribute("userinfo");
		Map<String,String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		map.put("memberseq", dto.getMemberseq());
		return oservice.chkOffer(map);
	}
	
}
