package com.min.naementor.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private Matching_IService mservice;
	@Autowired
	private Report_IService rservice;
	@Autowired
	private FindingMentor_IService fservice;
	@Autowired
	private FindingMentor_MakeArrayList converter;
	// 리뷰게시판으로 이동(session 정보 탐색 후 분기)
	
	
	// 멘토와 멘티 분기
	@SuppressWarnings("unchecked")
	@RequestMapping("/review.do")
	public String review(HttpSession session, String boardseq, String menteeseq) {
		log.info("review.do : {}:{}",boardseq,menteeseq);
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		boolean isc = false;
		if(dto.getAuth().equalsIgnoreCase("ROLE_E")) {
			isc = false;
		}else if(dto.getAuth().equalsIgnoreCase("ROLE_R")) {
			isc = true;
		}
		return isc?"redirect:/Menteereview.do":"redirect:/Menteereview.do";
	}
	
//	// 멘티가 멘토의 후기 보기
//	@RequestMapping(value = "/searchMStar.do", method=RequestMethod.GET)
//	public String searchMStar(Model model, String mentorseq, String boardseq) {
//		log.info("Review_CTRL_searchMStar \t {}",mentorseq);
//		List<ReviewDto> lists = service.searchMStar(mentorseq);
//		model.addAttribute("oppositeSeq", mentorseq);
//		model.addAttribute("reviews", lists);
//		model.addAttribute("boardseq", boardseq);
//		return "Review/review";
//	}
//	
//	// 멘토가 멘티의 후기 보기
//	@RequestMapping(value = "/denyMSearch.do", method=RequestMethod.GET)
//	public String denyMSearch(Model model,String menteeseq, String boardseq) {
//		log.info("Review_CTRL_denyMSearch \t {}",menteeseq);
//		List<ReviewDto> lists = service.denyMSearch(menteeseq);
//		model.addAttribute("oppositeSeq", menteeseq);
//		model.addAttribute("reviews", lists);
//		model.addAttribute("boardseq", boardseq);
//		return "Review/review";
//	}
}
