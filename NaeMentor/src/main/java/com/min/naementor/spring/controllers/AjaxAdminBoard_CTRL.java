package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
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

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
import com.min.naementor.dtos.ReportDto;
import com.min.naementor.spring.comm.RowNumUtil;
import com.min.naementor.spring.model.adminboard.AdminBoard_IService;
import com.min.naementor.spring.model.naemember.Naemember_IService;
import com.min.naementor.spring.model.report.Report_IService;

@Controller
public class AjaxAdminBoard_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminBoard_IService service;
	
	@Autowired
	private Report_IService rservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
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
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/reportContent.do", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject memberList(Model model, String memberList, HttpSession session) {
		JSONArray jLists = new JSONArray();
		log.info("******회원고르기"+memberList);
		JSONObject jsono = new JSONObject();
		
//		NaememberDto dto = (NaememberDto) session.getAttribute("userinfo");
		if(memberList.equalsIgnoreCase("reportContent")) {
			List<FindingMentorDto> fdto = service.SearchRC();
			for (int i = 0; i < fdto.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("boardseq", fdto.get(i).getBoardseq());
				json.put("title", fdto.get(i).getTitle());
				json.put("content", fdto.get(i).getContent());
				json.put("writesdate", fdto.get(i).getWritesdate());
				json.put("specialfield", fdto.get(i).getSpecialfield());
				json.put("target", fdto.get(i).getTarget());
				json.put("menteelevel", fdto.get(i).getMenteelevel());
				json.put("howto", fdto.get(i).getHowto());
				json.put("location", fdto.get(i).getLocation());
				json.put("delflag", fdto.get(i).getDelflag());
				json.put("mentorlist", fdto.get(i).getMentorlist());
				json.put("findreporter", fdto.get(i).getFindreporter());
				jLists.add(json);
				jsono.put("reportC", jLists); // {"report":jLists}
				}
			} // 신고당한 글 조회
		
		else if(memberList.equalsIgnoreCase("mentorMember")) {
			List<NaememberDto> ldto2 = service.searchApplier();
			for (int i = 0; i < ldto2.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("memberseq", ldto2.get(i).getMemberseq());
				json.put("email", ldto2.get(i).getEmail());
				json.put("nickname", ldto2.get(i).getNickname());
				json.put("introduce", ldto2.get(i).getIntroduce());
				json.put("phone", ldto2.get(i).getPhone());
				json.put("birthday", ldto2.get(i).getBirthday());
				json.put("gender", ldto2.get(i).getGender());
				json.put("reportcnt", ldto2.get(i).getReportcnt());
				json.put("joindate", ldto2.get(i).getJoindate());
				json.put("photo", ldto2.get(i).getProfiledto().getPhoto());
				json.put("school", ldto2.get(i).getProfiledto().getSchool());
				json.put("major", ldto2.get(i).getProfiledto().getMajor());
				json.put("career", ldto2.get(i).getProfiledto().getCareer());
				json.put("certificate", ldto2.get(i).getProfiledto().getCertificate());
				json.put("specialfield", ldto2.get(i).getProfiledto().getSpecialfield());
				json.put("mentoaccstar", ldto2.get(i).getProfiledto().getMentoaccstar());
				json.put("filechk", ldto2.get(i).getProfiledto().getFilechk());
				json.put("userfile", ldto2.get(i).getProfiledto().getAttachfiledto().getUserfile());
				json.put("uploaddate", ldto2.get(i).getProfiledto().getAttachfiledto().getUploaddate());
				jLists.add(json);
				jsono.put("mentor", jLists);
			}
		} // 멘토신청 회원 조회
		
		else if(memberList.equalsIgnoreCase("reportMember")) {
			List<ReportDto> rdto = rservice.searchReportU();
			List<NaememberDto> ldto = service.userBasicInfo();
			for (int i = 0; i < rdto.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("singomember", rdto.get(i).getSingomember());
				json.put("singoedmember", rdto.get(i).getSingoedmember());
				json.put("singoreason", rdto.get(i).getSingochk());
				json.put("singochk", rdto.get(i).getSingochk());
				json.put("reviewseq", rdto.get(i).getReviewseq());
				json.put("boardseq", rdto.get(i).getBoardseq());
				json.put("content", rdto.get(i).getReviewdto().getContent());
				json.put("writedate", rdto.get(i).getReviewdto().getWritedate());
				json.put("delflag", rdto.get(i).getReviewdto().getDelflag());
				json.put("mentoringplace", rdto.get(i).getReviewdto().getMatchingdto().getMemberscheduledto().getMentoringplace());
				json.put("mentoringtime", rdto.get(i).getReviewdto().getMatchingdto().getMemberscheduledto().getMentoringtime());
				jLists.add(json);
				jsono.put("reportM", jLists);
			} // 신고당한 회원 조회
		}else {
			List<NaememberDto> ldto = service.userBasicInfo();
			for (int i = 0; i < ldto.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("memberseq", ldto.get(i).getMemberseq());
				json.put("email", ldto.get(i).getEmail());
				json.put("nickname", ldto.get(i).getNickname());
				json.put("phone", ldto.get(i).getPhone());
				json.put("birthday", ldto.get(i).getBirthday());
				json.put("gender", ldto.get(i).getGender());
				json.put("auth", ldto.get(i).getAuth());
				json.put("userstatus", ldto.get(i).getUserstatus());
				json.put("mentortier", ldto.get(i).getMentortier());
				json.put("reportcnt", ldto.get(i).getReportcnt());
				json.put("joindate", ldto.get(i).getJoindate());
				json.put("lastaccess", ldto.get(i).getLastaccess());
				json.put("byebye", ldto.get(i).getByebye());
				jLists.add(json);
				jsono.put("allUser", jLists);
			}
		}
		return jsono;
	}
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/userInfo.do", method = RequestMethod.GET)
		@ResponseBody
		public JSONObject userInfo(String memberseq) {
			JSONObject json = new JSONObject();
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberseq", memberseq);
			NaememberDto dto = service.personalInfo(map);
			json.put("memberseq", dto.getMemberseq());
			json.put("email", dto.getEmail());
			json.put("nickname", dto.getNickname());
			json.put("phone", dto.getPhone());
			json.put("birthday", dto.getBirthday());
			json.put("gender", dto.getGender());
			json.put("auth", dto.getAuth());
			json.put("userstatus", dto.getUserstatus());
			json.put("mentortier", dto.getMentortier());
			json.put("reportcnt", dto.getReportcnt());
			json.put("joindate", dto.getJoindate());
			json.put("lastaccess", dto.getLastaccess());
			json.put("byebye", dto.getByebye());
			System.out.println(dto+"@@@@@@@@@@@@@@@");
			return json;
		}
	
	
	// 신고카운트 증가, 신고체크 초기화(Y)
		@RequestMapping(value = "/changeSingoChk.do", method = RequestMethod.GET)
		@ResponseBody
		public String changeSingoChk(String singoedmember) {
			log.info("신고카운트 증가 changeSingoChk, {}", singoedmember);
			Map<String, String> map = new HashMap<String, String>();
			map.put("singoedmember", singoedmember);
			
			String setFrom = "hsw1513@gmail.com"; // 보낼 아이디
			String toEmail = rservice.searchSingoedMember(map);
			String content = "<h2>특정한 이유로 신고당하셨습니다. 3회 경고카운트 누적시 한달간 이용이 제한됩니다.<br> 자세한 사항은 1대1문의 게시판에서 질문해주새요.</h2><br><a href='http://localhost:8093/NaeMentor/Question_board.do'>내멘토 1대1 문의게시판 이동</a>";
			String title= "Naementor 신고 관련"; // 메일제목
			MimeMessage message = mailSender.createMimeMessage();
			
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
			
			if(rservice.addReportCnt(map)) {
				rservice.changeSingoChk(map);
				return "true";
			}
				return "false";
		}
		
		// 탈퇴회원 탈퇴 승인 => 회원권한 변경
		@RequestMapping(value = "/changeBye.do", method = RequestMethod.GET)
		@ResponseBody
		public String changeBye(String email, String userstatus) {
			log.info("탈퇴회원 승인시 권한 변경");
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			if(service.changeStatusBye()) {
				return "true";
			}else {
				return "false";
			}
		}
		
		// 멘토승급 승인 + 승급시간 기록
		@RequestMapping(value = "/mentorPromotion.do", method = RequestMethod.GET)
		@ResponseBody
		public String changeBye(String memberseq) {
			log.info("멘토승급 승인 및 승급시간 기록");
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberseq", memberseq);
			if(service.mentorPromotion(map)) {
				service.promotionDate(map);
				service.tierPromotion(map);
				return "true";
			}else {
				return "false";
			}
		}
		
		// 신고된 게시글 삭제
		@RequestMapping(value = "/deleteReport.do", method = RequestMethod.GET)
		@ResponseBody
		public String deleteReport(String boardseq) {
			log.info("신고 게시글 삭제");
			Map<String, String> map = new HashMap<String, String>();
			map.put("boardseq", boardseq);
			if(service.deleteReport(map)) {
				return "true";
			}else {
				return "false";
			}
		}
		
		// 멘토신고 거절시 filechk 상태 변경(N)
		@RequestMapping(value = "/mentorCancel.do", method = RequestMethod.GET)
		@ResponseBody
		public String mentorCancel(String memberseq) {

			Map<String, String> map = new HashMap<String, String>();
			map.put("memberseq", memberseq);
			
			log.info("멘토승인 거절");
			if(service.mentorCancel(map)) {
			
			// 메일보내기
			String setFrom = "hsw1513@gmail.com"; // 보낼 아이디
			String toEmail = service.denyId(map);// 받을 아이디
			String content = "<h2>신청하신 멘토 승급 요청이 거절되셨습니다. 자세한 사항은 1대1문의 게시판에서 질문해주새요.</h2><br><a href='http://localhost:8093/NaeMentor/Question_board.do'>내멘토 1대1 문의게시판 이동</a>"; // 받을 내용
			String title= "Naementor 멘토 승급 실패"; // 메일제목
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
		
		// 신고카운트 감소
		@RequestMapping(value = "/delSingoChk.do", method = RequestMethod.GET)
		public String delSingoChk(String singoedmember) {
			log.info("신고카운트 감소"+singoedmember);
			Map<String, String> map = new HashMap<String, String>();
			map.put("singoedmember", singoedmember);
			if(service.delSingoChk(map)) {
				rservice.changeSingoChk(map);
				return "true";
			}else {
				return "false";
			}
		}
		
//		@RequestMapping(value = "/adminPaging.do", method = RequestMethod.POST)
//		public String adminPaging(RowNumUtil rUtil, HttpSession session) {
//			log.info("questionpage qpage, {}", rUtil);
//		      
//		      JSONObject json = null;
//		      
//		      rUtil.setTotal(service.OtOBoardListTotal());
//		      json = makeJson(service.allOneToOneA(rUtil), rUtil);
//		      
//		      session.removeAttribute("row");
//		      session.setAttribute("row", rUtil);
//		      
//		      return json.toString();
//		   }
//		   @SuppressWarnings("unchecked")
//		   private JSONObject makeJson(List<NotiQuestionDto>lists, RowNumUtil row) {
//		      JSONArray jLists = new JSONArray(); // [{"":""},{"":""},{"":""},....]
//		      JSONObject jdto = new JSONObject(); // {"":""}
//		      JSONObject json = new JSONObject(); // {"":"[{"":""},{"":""},{"":""},....]"}
//		      
//		      
//		      // 화면 리스트 관련
//		      for (NotiQuestionDto dto : lists) {
//		         jdto = new JSONObject();
//		         jdto.put("adminseq", dto.getAdminseq());
//		         jdto.put("nickname", dto.getNamemberdto().getNickname());
//		         jdto.put("title", dto.getTitle());
//		         jdto.put("content", dto.getContent());
//		         jdto.put("delflag", dto.getDelflag());
//		         jdto.put("writedate", dto.getWritedate());
//		         jLists.add(jdto); // [{"":""},{"":""},{"":""},....]
//		      }
//		      System.out.println(jdto.get(jdto));
//		      
//		      // 페이지 관련
//		      jdto = new JSONObject(); // {"":""}
//		      jdto.put("pageList", row.getPageList());
//		      jdto.put("index", row.getIndex());
//		      jdto.put("pageNum", row.getPageNum());
//		      jdto.put("listNum", row.getListNum());
//		      jdto.put("total", row.getTotal());
//		      jdto.put("count", row.getCount());
//		      
//		      json.put("lists", jLists);
//		      json.put("row", jdto);
//		      
//		      System.out.println(json.toString());
//		      
//		      return json;
//		   }
//
//		}
	
}
	
