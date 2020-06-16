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

import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ReviewDto;
import com.min.naementor.spring.comm.FindingMentor_MakeArrayList;
import com.min.naementor.spring.model.matching.Matching_IService;
import com.min.naementor.spring.model.report.Report_IService;
import com.min.naementor.spring.model.review.Review_IService;

@Controller
public class AjaxFindingMentor_CTRL {

	@Autowired
	private Review_IService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Matching_IService mservice;
	@Autowired
	private Report_IService rservice;
	@Autowired
	private FindingMentor_MakeArrayList converter;
	// 리뷰게시판으로 이동(session 정보 탐색 후 분기)
	@RequestMapping("/review.do")
	@ResponseBody
	public JSONObject review(HttpSession session, String boardseq) {
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		MatchingDto mdto = (MatchingDto) mservice.chkMatching(boardseq);
		JSONObject obj = new JSONObject();
		// 멘티일 경우
		if(mdto != null) {
		if(dto.getAuth().equals("ROLE_E")) {
			String mentorseq = mdto.getMentorseq();
			log.info("Review_CTRL_searchMStar \t {}",mentorseq);
			List<ReviewDto> lists = service.searchMStar(mentorseq);
			obj.put("result", true);
			obj.put("oppositeSeq", mentorseq);
			obj.put("reviews", converter.convertReviewList(lists));
			obj.put("boardseq", boardseq);
		// 멘토일 경우
		}else if(dto.getAuth().equals("ROLE_R")) {
			String menteeseq = mdto.getMenteeseq();
			log.info("Review_CTRL_denyMSearch \t {}",menteeseq);
			List<ReviewDto> lists = service.denyMSearch(menteeseq);
			obj.put("result", true);
			obj.put("oppositeSeq", menteeseq);
			obj.put("reviews", converter.convertReviewList(lists));
			obj.put("boardseq", boardseq);
		}else {
			obj.put("result", false);
		}
		}else {
			obj.put("result", false);
		}
		return obj;
	}
	
	// 멘티가 멘토의 후기 보기
	@RequestMapping(value = "/searchMStar.do", method=RequestMethod.GET)
	public String searchMStar(Model model, String mentorseq, String boardseq) {
		log.info("Review_CTRL_searchMStar \t {}",mentorseq);
		List<ReviewDto> lists = service.searchMStar(mentorseq);
		model.addAttribute("oppositeSeq", mentorseq);
		model.addAttribute("reviews", lists);
		model.addAttribute("boardseq", boardseq);
		return "Review/review";
	}
	
	// 멘토가 멘티의 후기 보기
	@RequestMapping(value = "/denyMSearch.do", method=RequestMethod.GET)
	public String denyMSearch(Model model,String menteeseq, String boardseq) {
		log.info("Review_CTRL_denyMSearch \t {}",menteeseq);
		List<ReviewDto> lists = service.denyMSearch(menteeseq);
		model.addAttribute("oppositeSeq", menteeseq);
		model.addAttribute("reviews", lists);
		model.addAttribute("boardseq", boardseq);
		return "Review/review";
	}
}
