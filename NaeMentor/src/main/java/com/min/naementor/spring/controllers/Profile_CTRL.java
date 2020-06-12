package com.min.naementor.spring.controllers;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.model.profile.Profile_IService;


@Controller
public class Profile_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Profile_IService service;
	// 프로필 페이지로 이동
	@RequestMapping("/Profile.do")
	public String profile(Model model, HttpSession session) {
		log.info("Profile_IService_profile");
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		model.addAttribute("profile", service.encLogin(ndto.getMemberseq()));
		return "Profile/Profile";
	}
	// 회원탈퇴
	@RequestMapping(value="/applyBye.do", method=RequestMethod.GET)
	public String applyBye(String memberseq, HttpSession session){
		log.info("Profile_IService_applyBye \t {}",memberseq);
		if(service.applyBye(memberseq)) {
			session.invalidate();
			return "redirect:/index.do";
		}else {
			return "redirect:/Profile.do";
		}
	}
	
	
	
	
	
}
