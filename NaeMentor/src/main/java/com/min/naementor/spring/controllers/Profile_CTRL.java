package com.min.naementor.spring.controllers;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
import com.min.naementor.spring.comm.AttachFile_Module;
import com.min.naementor.spring.model.attachfile.AttachFile_IService;
import com.min.naementor.spring.model.profile.Profile_IService;


@Controller
public class Profile_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Profile_IService service;
	@Autowired
	private AttachFile_IService fService;
	// 프로필 페이지로 이동
	@RequestMapping("/Profile.do")
	public String profile(Model model, HttpSession session) {
		log.info("Profile_IService_profile");
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		model.addAttribute("profile", service.encLogin(ndto.getMemberseq()));
		model.addAttribute("userfile", fService.chkFile(ndto.getMemberseq()));
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
	
	@RequestMapping(value="/goingApplyMentor.do", method = RequestMethod.GET)
	public String goingApplyMentor(Model model, HttpSession session) {
		log.info("Profile_IService_goingApplyMentor \t {}",new Date());
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		model.addAttribute("profile", service.encLogin(ndto.getMemberseq()));
		return "Profile/ApplyMentor";
	}
	//이걸 보시오. 멘토신청
	@Autowired
	private AttachFile_Module module;
	@RequestMapping(value="/applymentor.do", method = RequestMethod.POST)
	public String applymentor(ProfileDto dto,
			HttpServletRequest request, HttpServletResponse resp,@RequestParam("files") List<MultipartFile> files) {
		log.info("Profile_IService_applymentor \t {} ",dto);
		boolean isc = false;
		module.setMemberseq(dto.getMemberseq());
		if(service.insertProfile(dto)) {
			List<AttachFileDto> lists = module.attachFile(files, request, resp);
			for (AttachFileDto attachFileDto : lists) {
			 isc = service.insertFile(attachFileDto);
			}
		}
		return isc?"redirect:/goingApplyMentor.do":"redirect:/Profile.do";
	}
	
	
	
}
