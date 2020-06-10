package com.min.naementor.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberSchedule_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/schedule.do")
	public String schedule() {
		return "MemberSchedule/schedule";
	}
	
	@RequestMapping(value="/insertSchedule.do", method = RequestMethod.POST)
	public String insertSchedule(String date, String time, String loc) {
//		2020-06-1914:49서울
		String[] dateA = date.split("-");
		String[] timeA = time.split(":");
		String conDate = dateA[0]+dateA[1]+dateA[2];
		String conTime = timeA[0]+timeA[1];
		log.info("{}{}{}",conDate,conTime,loc);
		
		return "redirect:/schedule.do";
	}
	
}
