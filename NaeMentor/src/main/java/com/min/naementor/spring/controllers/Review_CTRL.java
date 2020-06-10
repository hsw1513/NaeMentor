package com.min.naementor.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ReviewDto;
import com.min.naementor.spring.model.matching.Matching_IService;
import com.min.naementor.spring.model.review.Review_IService;

@Controller
public class Review_CTRL {
	
	@Autowired
	private Review_IService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Matching_IService mservice;
	
	// 리뷰게시판으로 이동(session 정보 탐색 후 분기)
	@RequestMapping("/review.do")
	public String review(HttpSession session, String boardseq) {
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		// 멘토일 경우
		if(dto.getAuth().equals("ROLE_R")) {
			return "redirect:/denyMSearch.do?boardseq="+boardseq;
		// 멘티일 경우
		}else if(dto.getAuth().equals("ROLE_E")) {
			return "redirect:/denyMSearch.do?boardseq="+boardseq;
		}else {
		 return "redirect:/FindingMentor_board.do";
		}
	}

	// 멘토 후기 보기
	@RequestMapping(value = "/searchMStar.do", method=RequestMethod.GET)
	public String searchMStar(HttpSession session, Model model, String boardseq) {
		// 여기서부터 작업!
		log.info("Review_CTRL_searchMStar \t {}",boardseq);
		List<ReviewDto> lists = service.searchMStar(boardseq);
		model.addAttribute("reviews", lists);
		return "Review/review";
	}
	
	// 멘티 후기 보기
	@RequestMapping(value = "/denyMSearch.do", method=RequestMethod.GET)
	public String denyMSearch(String menteeseq, Model model, String memberseq) {
		log.info("Review_CTRL_denyMSearch \t {}",menteeseq);
		List<ReviewDto> lists = service.denyMSearch(menteeseq);
		model.addAttribute("reviews", lists);
		return "Review/review";
	}
	// 후기 입력
	@RequestMapping(value= "/insertReview.do", method=RequestMethod.POST)
	@ResponseBody
	public String insertReview(ReviewDto dto) {
		log.info("Review_CTRL_insertReview \t {}",dto);
		if(service.insertReview(dto)) {
			return "review_success";
		}else {
			return "review_fail";
		}
	}
	

}
