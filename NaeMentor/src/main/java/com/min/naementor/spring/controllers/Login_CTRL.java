package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
import com.min.naementor.spring.comm.AttachFile_Module;
import com.min.naementor.spring.model.capcha.Capcha_IService;
import com.min.naementor.spring.model.naemember.Naemember_IService;

@Controller
public class Login_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Naemember_IService service;

	@Autowired
	private AttachFile_Module module;

	//키를 받아오는 클래스
	@Resource(name = "gotKey")
	private Capcha_IService getKey;

	// 사용자 입력값 판단하는 클래스
	@Resource(name = "valChk")
	private Capcha_IService valchk;

	//캡챠가 구현되는 페이지
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String main(Model model) {

		String key = getKey.get("0");
		
		// json으로 key 값 뽑아오기
		JSONParser parser  = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(key);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject jsonobj = (JSONObject) obj;

		key = (String) jsonobj.get("key");
		System.out.println(key+"------------------------------------");
		if(key != null) {
			model.addAttribute("key",key);
		}
		return "Naemember/loginPage";
	}

	//결과값을 표출하는 페이지
	@RequestMapping(value = "/valchk.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean chk(Model model, String chk, String key) {
		log.info("****값을 확인해보자! chk"+chk+"이고요 키는"+key);
		String attach = "1&key="+key+"&value="+chk;
		String result = valchk.get(attach);
		System.out.println("일치여부"+result);
		 JSONParser parser  = new JSONParser();
	        Object obj = null;
			try {
				obj = parser.parse(result);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        JSONObject jsonobj = (JSONObject) obj;
	        boolean isc = (boolean) jsonobj.get("result");
		
	       return isc;
	}

	//약관 페이지로 이동
	@RequestMapping(value = "/yakGwanGo.do", method = RequestMethod.GET)
	public String YakGwango() {
		log.info("약관 페이지로 이동: SignUpgo");
		return "Naemember/yakGWan";
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
	public String insertProfile(ProfileDto dto, Model model, String email, 
			HttpServletRequest request, HttpServletResponse resp) {
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
			@RequestParam(value = "logout", required = false) String logout, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		if (error != null) { // 로그인 실패시 로그인 카운트 증가
			String email = request.getParameter("email");
			log.info("%%%%%%실패 들어옴?"+email);
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			service.loginCount(map); // 로그인 카운트 증가
			log.info("에러발생");
		}

		if (logout != null) {
			log.info("로그아웃 성공");
		}

		return "redirect:/index.do";
	}


	// 로그아웃시 시간 기록
	@RequestMapping(value = "/logoutgo.do", method = RequestMethod.GET)
	public String logoutTime(Model model, String email) {
		log.info("**************logout.do 들어왔다"+email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		service.logoutTime(map);
		return "redirect:/logout.do";
	}

	// 로그인 성공시 메인으로 이동
	@RequestMapping(value = "/loginresult.do", method = RequestMethod.GET)
	public String maingo(Authentication user, Model model,NaememberDto dto, HttpSession session) {

		if(user != null) {
			UserDetails userdto = (UserDetails) user.getPrincipal();
			log.info("%%%%%%들어옴?");
			// 로그인 시도 초기화
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", userdto.getUsername());
			service.initLoginCount(map);

			// 로그인 정보 세션에 담기
			NaememberDto ndto = service.encLogin(userdto.getUsername());
			ndto.setPassword("password");
			session.setAttribute("userinfo", ndto);
			
			// 휴면계정 로그인 시 비밀번호 변경 페이지로 이동
			NaememberDto gdto = (NaememberDto) session.getAttribute("userinfo");
			if(gdto.getUserstatus().equals("R")) {
				service.wakeUp(gdto.getMemberseq());
				return "Naemember/changePassword";
			}
			return "Naemember/login";
		}else {
			return "redirect:/index.do";
		}
	}


	// 아이디/비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "/searchIdPW.do", method = RequestMethod.GET)
	public String idPwSearch(String phone) {
		return "Naemember/searchIdPw";
	}

	@RequestMapping(value = "/changePassword.do", method = RequestMethod.GET)
	public String changePassword() {
		return "Naemember/changePassword";
	}

	@RequestMapping(value = "/newPassword.do", method = RequestMethod.POST)
	public String newPassword(NaememberDto dto) {
		service.changePassword(dto);
		return "Naemember/loginPage";
	}



}
