package com.min.naementor.spring.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

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
			String email = service.searchId(dto);
			return email;
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
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('메일이 발송되었습니다.'); location.href='./index.do'</script>");
			out.flush();// Stream 객체는 flush 안해주면 작동이 되지 않음(flush:  stream에 남아 있는 데이터를 강제로 내보내는 역할)
			
			return "<script>alert('비밀번호 변경 페이지 메일이 발송되었습니다. 확인해주세요.');</script>";
		}
		
}
