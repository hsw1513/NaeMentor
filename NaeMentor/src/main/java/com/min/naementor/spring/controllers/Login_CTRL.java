package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
import com.min.naementor.spring.model.naemember.Naemember_IService;

@Controller
public class Login_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Naemember_IService service;
	
	// 로그인 페이지로 이동(기본페이지)
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String login() {
		log.info("로그인 기본");
		return "Naemember/loginPage";
	}
	
	//회원가입 페이지로 이동
	@RequestMapping(value = "/singUpGo.do", method = RequestMethod.GET)
	public String SignUpgo() {
		log.info("회원가입페이지로 이동: SignUpgo");
		return "Naemember/signUp";
	}
	
	// 회원가입 완료 => 프로필 입력 페이지 이동
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String SignUp(NaememberDto dto, Model model, String email) {
		log.info("회원가입 signUp: , {}", dto);
		service.signUp(dto);
		model.addAttribute("email", email);
		return "Naemember/insertProfile";
	}
	
	// 프로필 입력 후 로그인페이지로 이동
	@RequestMapping(value = "/proFile.do", method = RequestMethod.POST)
	public String insertProfile(ProfileDto dto, Model model, String email) {
		log.info("회원가입 프로필 입력 insertProfile: ,{}", dto);
		service.insertProFile(dto);
		return "Naemember/loginPage";
	}
	
	// 회원가입 취소시 기본정보 삭제
	@RequestMapping(value = "/cancel.do", method = RequestMethod.GET)
	public String cancelSignUp(Model model, String email) {
		log.info("프로필 입력 취소시 회원가입 취소 cancelSignUp");
		System.out.println("********"+email);
		service.cancelSignUp(email);
		return "Naemember/loginPage";
	}
	
	//로그인페이지로 가는 매핑
	@RequestMapping(value = "/logingo.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String login(@RequestParam(value = "error", required = false) String error,
	@RequestParam(value = "logout", required = false) String logout, Model model, Authentication user) {
		
	if (error != null) {
	model.addAttribute("msg", "로그인 에러");
	}

	if (logout != null) {
	model.addAttribute("msg", "로그아웃 성공");
	}
	
	return "Naemember/loginPage";
	}

	// 로그인 성공시 메인으로 이동
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String maingo(Authentication user, Model model,NaememberDto dto, HttpSession session) {
	UserDetails userdto = (UserDetails) user.getPrincipal();
	model.addAttribute("user", userdto.toString());
	NaememberDto ndto = service.encLogin(userdto.getUsername());
	session.setAttribute("userinfo", ndto);
	return "Naemember/login";
	}
	
	
	
}
