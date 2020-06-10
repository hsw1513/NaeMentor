package com.min.naementor.spring.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.management.Notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.spring.model.notiquestion.Notiquestion_IService;

@Controller
public class Notification_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IService service;
	
	@RequestMapping("Notification_board.do")
	public String notiboard(Model model) {
		log.info("notiboard notiboardMain:\t {}", new Date());
		model.addAttribute("lists", service.notiAll());
		return "Notiquestion/Notification_board";
	}
	
	@RequestMapping(value = "Notification_boardDetail.do", method = RequestMethod.GET)
	public String notiboardDetail(Model model, String adminseq) {
		log.info("notiboard notiboardDetail:\t {}", adminseq);
		model.addAttribute("dto", service.searchNoti(adminseq));
		return "Notiquestion/Notification_boardDetail";
	}
	
	@RequestMapping(value = "Notification_boardWrite.do", method = RequestMethod.GET)
	public String notiboardWrite() {
		log.info("notiboard notiboardWrite:\t {}", new Date());
		return "Notiquestion/Notification_boardWrite";
	}
	
	@RequestMapping(value="NotiWrite.do", method = RequestMethod.POST)
	public String notiWrite(NotiQuestionDto dto) {
		log.info("notiboard notiWrite:\t {}", dto);
		service.insertNoti(dto);
		return "redirect:/Notification_board.do";
	}
	
	@RequestMapping(value="Notification_boardDelete.do", method = RequestMethod.GET)
	public String notiDel(String adminseq) {
		log.info("notiboard notiDel:\t", adminseq);
		service.deleteNoti(adminseq);
		return "redirect:/Notification_board.do";
	}
	
	@RequestMapping(value="Notification_boardMultiDel.do", method = RequestMethod.POST)
	public String notiMultiDel(Model model, String[] chks) {
		log.info("notiboard notiMultiDel:\t {}", Arrays.toString(chks));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("adminseqs", chks);
		int n = service.multiDeleteNoti(map);
		if(n>0) {
			return "redirect:/Notification_board.do";
		}else {
			model.addAttribute("url", "index.jsp");
			model.addAttribute("msg", "삭제 실패");
			return "redirect:/Notification_board.do";
		}
	}
	
	@RequestMapping(value="Notification_boardModify.do", method = RequestMethod.GET)
	public String notiboardModify(Model model, String adminseq) {
		log.info("notiboard notiboardModify:\t {}", new Date());
		model.addAttribute("dto", service.searchNoti(adminseq));
		return "Notiquestion/Notification_boardModify";
	}
	
	@RequestMapping(value="NotiModify.do", method = RequestMethod.POST)
	public String notiModify(NotiQuestionDto dto) {
		log.info("notiboard notiModify:\t {}", dto);
		service.modifyNoti(dto);
		return "redirect:/Notification_boardDetail.do?adminseq="+dto.getAdminseq();
	}
	
} 
