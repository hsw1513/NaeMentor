package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
		MatchingDto mdto = (MatchingDto) mservice.chkMatching(boardseq);
		// 멘티일 경우
		if(dto.getAuth().equals("ROLE_E")) {
			return "redirect:/searchMStar.do?boardseq="+boardseq+"&mentorseq="+mdto.getMentorseq();
		// 멘토일 경우
		}else if(dto.getAuth().equals("ROLE_R")) {
			return "redirect:/denyMSearch.do?boardseq="+boardseq+"&menteeseq="+mdto.getMenteeseq();
		}else {
		 return "redirect:/FindingMentor_board.do";
		}
	}

	// 멘티가 멘토의 후기 보기
	@RequestMapping(value = "/searchMStar.do", method=RequestMethod.GET)
	public String searchMStar(Model model, String mentorseq, String boardseq) {
		// 여기서부터 작업!
		log.info("Review_CTRL_searchMStar \t {}",mentorseq);
		List<ReviewDto> lists = service.searchMStar(mentorseq);
		model.addAttribute("reviews", lists);
		model.addAttribute("boardseq", boardseq);
		return "Review/review";
	}
	
	// 멘토가 멘티의 후기 보기
	@RequestMapping(value = "/denyMSearch.do", method=RequestMethod.GET)
	public String denyMSearch(Model model,String menteeseq, String boardseq) {
		log.info("Review_CTRL_denyMSearch \t {}",menteeseq);
		List<ReviewDto> lists = service.denyMSearch(menteeseq);
		model.addAttribute("reviews", lists);
		model.addAttribute("boardseq", boardseq);
		return "Review/review";
	}
	// 후기 입력
	@RequestMapping(value= "/insertReview.do", method=RequestMethod.POST)
	public String insertReview(ReviewDto dto, HttpSession session) {
		NaememberDto ndto = (NaememberDto)session.getAttribute("userinfo");
		MatchingDto mdto = (MatchingDto) mservice.chkMatching(dto.getBoardseq());
		Map<String, String> map = new HashMap<String, String>();
		map.put("menteeaccstar",dto.getMenteestar());
		map.put("mentoaccstar",dto.getMentorstar());
		log.info("Review_CTRL_insertReview \t {}",dto);
		// 멘티일 경우
		if(ndto.getAuth().equals("ROLE_E")) {
			if(service.insertReviewMentee(dto)) {
				map.put("memberseq", mdto.getMentorseq());
				service.updateMentoAccStar(map);
			}
		// 멘토일 경우
		}else if(ndto.getAuth().equals("ROLE_R")) {
			if(service.insertReviewMentor(dto)) {
				map.put("memberseq", mdto.getMenteeseq());
				service.updateMenteeAccStar(map);
			}
		}else {
		 return "redirect:/FindingMentor_board.do";
		}
		return "redirect:/review.do?boardseq="+dto.getBoardseq();
	}
	// 후기 체크
	@RequestMapping(value= "/chkReview.do", method=RequestMethod.POST)
	@ResponseBody
	public String chkReview(String boardseq, HttpSession session) {
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		log.info("Review_CTRL_chkReview \t {}",boardseq);
		// 멘티일 경우
		if(dto.getAuth().equals("ROLE_E")) {
			if(service.chkReviewMentee(boardseq)) {
				return "true";
			}else {
				return "false";
			}
		// 멘토일 경우
		}else if(dto.getAuth().equals("ROLE_R")) {
			if(service.chkReviewMentor(boardseq)) {
				return "true";
			}else {
				return "false";
			}
		}else {
		 return "false";
		}
	}
	

}
