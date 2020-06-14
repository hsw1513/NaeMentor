package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.model.adminboard.AdminBoard_IService;
import com.min.naementor.spring.model.report.Report_IService;

@Controller
public class AdminBoard_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminBoard_IService service;
	
	@Autowired
	private Report_IService rservice;
	
	
	// 관리자 페이지로 이동
	@RequestMapping(value = "/adminBoard.do", method = RequestMethod.GET)
	public String goAdmin(Model model) {
		List<NaememberDto> lists = service.userBasicInfo();
		model.addAttribute("lists",lists);
		return "AdminBoard/adminPage";
	}
	
	// 신고카운트 증가
	@RequestMapping(value = "/changeSingoChk.do", method = RequestMethod.GET)
	public String changeSingoChk(String singoedmember) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("singoedmember", singoedmember);
		if(rservice.addReportCnt(map)) {
			rservice.changeSingoChk(map);
			return "true";
			
		}
			return "false";
	}
	
	// 탈퇴회원 탈퇴 승인
	@RequestMapping(value = "/changeBye.do", method = RequestMethod.GET)
	public String changeBye(String email, String userstatus) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		if(service.changeStatus(map)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	// 멘토승급 승인
	@RequestMapping(value = "/mentorPromotion.do", method = RequestMethod.GET)
	public String changeBye(String memberseq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberseq", memberseq);
		if(service.mentorPromotion(map)) {
			service.promotionDate(map);
			return "true";
		}else {
			return "false";
		}
	}
	
	
	
	
}