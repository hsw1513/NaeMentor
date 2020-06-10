package com.min.naementor.spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.ReviewDto;
import com.min.naementor.spring.model.review.Review_IService;

@Controller
public class Review_CTRL {
	
	@Autowired
	private Review_IService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 리뷰게시판으로 이동(session 정보 탐색 후 분기)
	@RequestMapping("/review.do")
	public String review() {
		// 멘토일 경우 auth = 1
		String auth = "1";
		if(auth.equals("1")) {
			return "redirect:/denyMSearch.do";
		// 멘티일 경우 auth = 2
		}else if(auth.equals("2")) {
			return "redirect:/denyMSearch.do";
		}else {
		 return "redirect:/FindingMentor_board.do";
		}
	}

	// 멘토 후기 보기
	@RequestMapping(value = "/searchMStar.do", method=RequestMethod.POST)
	public String searchMStar(String mentorseq, Model model) {
		log.info("Review_CTRL_searchMStar \t {}",mentorseq);
		List<ReviewDto> lists = service.searchMStar(mentorseq);
		model.addAttribute("reviews", lists);
		return "Review/review";
	}
	
	// 멘티 후기 보기
	@RequestMapping(value = "/denyMSearch.do", method=RequestMethod.POST)
	public String denyMSearch(String menteeseq, Model model) {
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
