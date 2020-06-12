package com.min.naementor.spring.controllers;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
import com.min.naementor.spring.model.adminboard.AdminBoard_IService;

@Controller
public class AjaxAdminBoard_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminBoard_IService service;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/userDetail.do", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject userDetail(Model model, String memberseq) {
		JSONObject json = new JSONObject();
		ProfileDto pdto = service.userDetail(memberseq);
		json.put("memberseq", pdto.getMemberseq());
		json.put("photo", pdto.getPhoto());
		json.put("school", pdto.getSchool());
		json.put("major", pdto.getMajor());
		json.put("career", pdto.getCareer());
		json.put("certificate", pdto.getCertificate());
		json.put("specialfield", pdto.getSpecialfield());
		json.put("pmdate", pdto.getPmdate());
		json.put("mentorcnt", pdto.getMentorcnt());
		json.put("mentoraccstar", pdto.getMentoaccstar());
		log.info("Welcome userDetail {}", json.toString());
		return json;
	}
	
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	@ResponseBody
	public String memberList(Model model, String memList) {
		return null;
	}
	
	
	
}
