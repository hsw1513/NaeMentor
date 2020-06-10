package com.min.naementor.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.MemberScheduleDto;
import com.min.naementor.spring.model.memberSchedule.MemberSchedule_IService;

@Controller
public class MemberSchedule_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MemberSchedule_IService service;
	
	@RequestMapping("/schedule.do")
	public String schedule(String boardseq, Model model) {
		model.addAttribute("boardseq", boardseq);
		return "MemberSchedule/schedule";
	}
	
	@RequestMapping(value="/insertSchedule.do", method = RequestMethod.POST)
	public String insertSchedule(String date, String time, String loc, String boardseq, Model model) {
		model.addAttribute("boardseq", boardseq);
		String[] dateA = date.split("-");
		String[] timeA = time.split(":");
		String conDate = dateA[0]+dateA[1]+dateA[2];
		String conTime = timeA[0]+timeA[1];
		log.info("{}{}{}",conDate,conTime,loc);
		MemberScheduleDto dto = new MemberScheduleDto();
		dto.setBoardseq(boardseq);
		dto.setMentoringplace(loc);
		dto.setMentoringtime(conDate+conTime);
		service.insertSchedule(dto);
		return "redirect:/schedule.do";
	}
	@RequestMapping(value="/modifySchedule.do", method = RequestMethod.POST)
	public String modifySchedule(String date, String time, String loc, String boardseq, Model model) {
		model.addAttribute("boardseq", boardseq);
		String[] dateA = date.split("-");
		String[] timeA = time.split(":");
		String conDate = dateA[0]+dateA[1]+dateA[2];
		String conTime = timeA[0]+timeA[1];
		log.info("{}{}{}",conDate,conTime,loc);
		MemberScheduleDto dto = new MemberScheduleDto();
		dto.setBoardseq(boardseq);
		dto.setMentoringplace(loc);
		dto.setMentoringtime(conDate+conTime);
		service.modifySchedule(dto);
		return "redirect:/schedule.do";
	}
	@RequestMapping(value="/deleteSchedule.do", method = RequestMethod.GET)
	public String deleteSchedule(String boardseq, Model model) {
		model.addAttribute("boardseq", boardseq);
		service.deleteSchedule(boardseq);
		return "redirect:/schedule.do";
	}
	
	
}
