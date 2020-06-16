package com.min.naementor.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ReviewDto;
import com.min.naementor.spring.comm.FindingMentor_MakeArrayList;
import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;
import com.min.naementor.spring.model.matching.Matching_IService;
import com.min.naementor.spring.model.report.Report_IService;
import com.min.naementor.spring.model.review.Review_IService;

@Controller
public class AjaxFindingMentor_CTRL {

	@Autowired
	private Review_IService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_MakeArrayList converter;
	
	
	// 멘토와 멘티 분기
	@RequestMapping("/review.do")
	public String review(HttpSession session, String boardseq, String menteeseq) {
		log.info("review.do : {}:{}",boardseq,menteeseq);
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		boolean isc = false;
		String mentorseq = "0";
		if(dto.getAuth().equalsIgnoreCase("ROLE_E")) {
			isc = true;
		}else if(dto.getAuth().equalsIgnoreCase("ROLE_R")) {
			isc = false;
		}
		return isc?"redirect:/Menteereview.do?boardseq="+boardseq+"&mentorseq="+mentorseq
						:"redirect:/Mentorreview.do?boardseq="+boardseq+"&menteeseq="+menteeseq;
	}
	
	// 멘토가 멘티의 후기 보기
	@RequestMapping(value = "/Mentorreview.do", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject denyMSearch(Model model,String menteeseq, String boardseq) {
		log.info("Review_CTRL_denyMSearch \t {}{}",menteeseq, boardseq);
		JSONObject obj = new JSONObject();
		List<ReviewDto> lists = service.denyMSearch(menteeseq);
		obj.put("reviews",converter.convertReviewList(lists));
		return obj;
	}
	
	// 멘티가 멘토의 후기 보기
	@RequestMapping(value = "/Menteereview.do", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject searchMStar(Model model, String mentorseq, String boardseq) {
		log.info("Review_CTRL_searchMStar \t {}:{}",mentorseq, boardseq);
		JSONObject obj = new JSONObject();
		if(!mentorseq.equals("0")) {
			List<ReviewDto> lists = service.denyMSearch(mentorseq);
			obj.put("reviews",converter.convertReviewList(lists));
		}else {
			obj.put("reviews","후기가 없습니다.");
		}
		return obj;
	}
	
	
	
}
