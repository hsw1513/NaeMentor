package com.min.naementor.spring.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.model.naemember.Naemember_IService;

@Controller
public class AjaxLogin_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Naemember_IService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
		// 이메일 중복검사 아작스
		@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> idDupleCheck(String email) {
			log.info("이메일 중복검사");
			Map<String, String> map = new HashMap<String, String>();
			boolean isc = service.idDupleChk(email);
			map.put("isc", isc+"");
			return map;
		}
		
		
		//닉네임 중복검사
		@RequestMapping(value = "/nickNameCheck.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> nickDupleChk(String nickname) {
			log.info("닉네임 중복검사");
			Map<String, String> map = new HashMap<String, String>();
			boolean isc = service.nickDupleChk(nickname);
			map.put("isc", isc+"");
			return map;
		}
	
		// 아이디 찾기
		@RequestMapping(value = "/idSend.do", method = RequestMethod.POST)
		@ResponseBody
		public String idSend(Model model, NaememberDto dto) {
			log.info("아이디찾기****{}", dto);
			String email = service.searchId(dto);
			if(email != null) {
				return email;
			}else {
				return "no";
			}
		}
		
		@RequestMapping(value = "/searchLoginCnt.do", method = RequestMethod.POST)
		@ResponseBody
		public int searchLoginCnt(String email) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			int cnt = service.searchLoginCnt(map);
			if(cnt>0) {
				return cnt;
			}else {
				return 0;
			}
		}
				
				
				
				
		// 비밀번호 변경 링크 보내주기
		@RequestMapping(value = "/passwordSend.do", method = RequestMethod.POST)
		@ResponseBody
		public String sendEmail(HttpServletResponse response, NaememberDto dto) throws IOException {
			
			String setFrom = "hsw1513@gmail.com"; // 보낼 아이디
			String toEmail = service.searchPassword(dto);// 받을 아이디
			String content = "<h2>내멘토 비밀번호 변경 페이지 링크입니다.</h2><br><a href='http://localhost:8093/NaeMentor/changePassword.do'>내멘토 비밀번호 변경 페이지</a>"; // 받을 내용
			String title= "Naementor 비밀번호 찾기"; // 메일제목
			MimeMessage message = mailSender.createMimeMessage(); //메일 내용
			
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setFrom);
				messageHelper.setTo(toEmail);
				messageHelper.setSubject(title);
				messageHelper.setText(content, true);
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			return "true";
		}
		
		
		// UUID 생성
		private String makeUUID() {
			String emailUUID = UUID.randomUUID().toString().substring(0, 8);
			return emailUUID;
		}
		
		private String randomEmail = null;
		
		// 아이디 확인 UUID 이메일 발송
		@RequestMapping(value = "/emailConfirm.do", method = RequestMethod.POST)
		@ResponseBody
		public String emailConfirm(HttpServletResponse response, String email) throws IOException {
			
			if(!service.idDupleChk(email)) {
			String setFrom = "hsw1513@gmail.com"; // 보낼 아이디
			log.info(email);
			String toEmail = email;// 받을 아이디
			this.randomEmail = makeUUID();
			
			log.info("*****"+randomEmail);
			
			String content = "<h2>내멘토 인증번호는</h2>"+randomEmail+"입니다"; // 받을 내용
			String title= "Naementor 아이디 인증"; // 메일제목
			MimeMessage message = mailSender.createMimeMessage(); //메일 내용
			
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setFrom);
				messageHelper.setTo(toEmail);
				messageHelper.setSubject(title);
				messageHelper.setText(content, true);
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return "true";
			}else {
				return "false";
			}
		}
		
		@RequestMapping(value = "/emailChk.do", method = RequestMethod.POST)
		@ResponseBody
		public String emailChk(String emailNum) {
			String chkCode = this.randomEmail;
			if(emailNum.equals(chkCode)) {
				log.info("Welcome emailChk.do 인증성공: \t 인증번호 : {} , 입력값 : {}", chkCode, emailNum);
				return "ok";
			}else {
				log.info("Welcome emailChk.do 인증실패: \t 인증번호 : {} , 입력값 : {}", chkCode, emailNum);
				return "no";
			}
		}
		
		
		
		
}
