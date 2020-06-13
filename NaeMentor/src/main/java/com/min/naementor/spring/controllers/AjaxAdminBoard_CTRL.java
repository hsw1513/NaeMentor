package com.min.naementor.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.FindingMentorDto;
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
	
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/reportContent.do", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject memberList(Model model, String memberList, HttpSession session) {
		
		JSONArray jLists = new JSONArray();
		log.info("******회원고르기"+memberList);
		JSONObject jsono = new JSONObject();
		
//		NaememberDto dto = (NaememberDto) session.getAttribute("userinfo");
		if(memberList.equalsIgnoreCase("reportMember")) {
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
				jsono.put("report", jLists); // {"report":jLists}
				}
			} // 신고당한 글 조회
		
		else if(memberList.equalsIgnoreCase("byeMember")) {
			List<NaememberDto> ldto = service.searchByeU();
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
				json.put("menteecnt", ldto.get(i).getMenteecnt());
				json.put("menteeaccstar", ldto.get(i).getMenteeaccstar());
				json.put("lastaccess", ldto.get(i).getLastaccess());
				json.put("byebye", ldto.get(i).getByebye());
				jLists.add(json);
				jsono.put("bye", jLists);
			}
		} // 탈퇴신청 회원 조회
		
		else if(memberList.equalsIgnoreCase("mentorMember")) {
			List<NaememberDto> ldto2 = service.searchByeU();
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
		
		return jsono;
	}
	
	
}
	