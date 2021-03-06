package com.min.naementor.spring.controllers;

import java.util.List;

import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	
	
	// 관리자 페이지로 이동
	@RequestMapping(value = "/adminBoard.do", method = RequestMethod.GET)
	public String goAdmin(Model model) {
		log.info("관리자 페이지로 이동 goAdmin");
		List<NaememberDto> lists = service.userBasicInfo();
		model.addAttribute("lists",lists);
		return "AdminBoard/adminPage";
	}
	
	
	
	
	
}