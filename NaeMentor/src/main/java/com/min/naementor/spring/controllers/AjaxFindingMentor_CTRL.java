package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.OfferDto;
import com.min.naementor.dtos.ReviewDto;
import com.min.naementor.spring.comm.AttachFile_Module;
import com.min.naementor.spring.comm.FindingMentor_MakeArrayList;
import com.min.naementor.spring.model.matching.Matching_IService;
import com.min.naementor.spring.model.offer.Offer_IService;
import com.min.naementor.spring.model.review.Review_IService;

@Controller
public class AjaxFindingMentor_CTRL {

	@Autowired
	private Review_IService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_MakeArrayList converter;
	@Autowired
	private Matching_IService mservice;
	@Autowired
	private Offer_IService oservice;
	@Autowired
	private AttachFile_Module module;
	
	// 멘토와 멘티 분기
	@RequestMapping("/review.do")
	public String review(HttpSession session, String boardseq, String menteeseq, String mentorseq) {
		log.info("review.do : {}:{}",boardseq, menteeseq);
		NaememberDto dto = (NaememberDto)session.getAttribute("userinfo");
		MatchingDto mdto = mservice.chkMatching(boardseq);
		boolean isc = false;
		if(dto.getAuth().equalsIgnoreCase("ROLE_E")) {
			isc = true;
		}else if(dto.getAuth().equalsIgnoreCase("ROLE_R")) {
			isc = false;
		}
		if(mdto != null) {
			mentorseq = mdto.getMentorseq();
			menteeseq = mdto.getMenteeseq();
		}
		return isc?"redirect:/Menteereview.do?boardseq="+boardseq+"&mentorseq="+ mentorseq
						:"redirect:/Mentorreview.do?boardseq="+boardseq+"&menteeseq="+menteeseq;
	}
	
	// 멘토가 멘티의 후기 보기
	@RequestMapping(value = "/Mentorreview.do", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject denyMSearch(Model model,String menteeseq, String boardseq) {
		log.info("Review_CTRL_denyMSearch \t {}{}",menteeseq, boardseq);
		JSONObject obj = new JSONObject();
		if(!menteeseq.equals("null")) {
			List<ReviewDto> lists = service.denyMSearch(menteeseq);
			obj.put("reviews",converter.convertReviewList(lists));
		}else {
			obj.put("reviews","");
		}
		return obj;
	}
	
	// 멘티가 멘토의 후기 보기
	@RequestMapping(value = "/Menteereview.do", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject searchMStar(Model model, String mentorseq, String boardseq) {
		log.info("Review_CTRL_searchMStar \t {}:{}",mentorseq, boardseq);
		JSONObject obj = new JSONObject();
		if(!mentorseq.equals("null")) {
			List<ReviewDto> lists = service.searchMStar(mentorseq);
			obj.put("reviews",converter.convertReviewList(lists));
		}else {
			obj.put("reviews","");
		}
		return obj;
	}
	// 멘티가 선택한 멘토의 오퍼 확인하기
	@RequestMapping(value = "/viewOffer.do", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject viewOffer(String mentorseq, String boardseq) {
		JSONObject obj = new JSONObject();
		Map<String,String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		map.put("memberseq", mentorseq);
		OfferDto odto = oservice.viewOffer(map);
		obj.put("offer", odto);
		return obj;
	}
	
	@RequestMapping(value = "/imgUpload.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject imgUpload(@RequestParam MultipartFile photofile,HttpServletRequest request, HttpServletResponse resp) {
		JSONObject obj = null;
		log.info("{}",photofile.toString());
		obj = module.ckImgUpload(photofile,request, resp);
		log.info("{}",obj.toJSONString());
		return obj;
	}
}
