package com.min.naementor.spring.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.spring.comm.SplitUserComm;
import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;

@Controller
public class FindingMentor_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_IService service;
	
	// 게시판 리스트 
	@RequestMapping("FindingMentor_board.do")
	public String board(Model model) {
		model.addAttribute("board_lists", service.selectAll());
		return "FindingMentor/FindingMentor_board";
	}
	
	// 상세보기
	@RequestMapping(value = "detailContent.do", method = RequestMethod.GET)
	public String detailContent(Model model, String memberseq, String boardseq , SplitUserComm comm) {
		log.info("{}, {}",memberseq, boardseq);
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		FindingMentorDto dto = service.detailContent(map);
		String[] _memberseq = comm.splitId(dto.getMentorlist());
//		System.out.println(Arrays.toString(_memberseq)+"--------------------------------------------------------------------------");
		Map<String, String[]> map2 = new HashMap<String, String[]>();
		map2.put("_memberseq", _memberseq);
		List<NaememberDto> lists = service.chkMentor(map2);
		model.addAttribute("findMentor", lists);
		model.addAttribute("detail", dto);
		return "FindingMentor/detailContent";
	}
	
	// 단일 삭제
	@RequestMapping("deleteContent.do")
	public String deleteContent(String boardseq, String memberseq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq",boardseq);
		map.put("memberseq",memberseq);
		service.deleteContent(map);
		return "redirect:/FindingMentor_board.do";
	}
	
	// 수정하기
	@RequestMapping(value="modifyContent.do", method = RequestMethod.POST)
	public String modifyContent(FindingMentorDto dto) {
		log.info("{}",dto);
		service.modifyContent(dto);
		return "redirect:/FindingMentor_board.do";
	}
	
	// 작성페이지로 이동
	@RequestMapping("writeForm.do")
	public String writeForm() {
		log.info("{}",new Date());
		return "FindingMentor/writeForm";
	}
	
	// 글 작성하기
	@RequestMapping(value="insertContent.do",method = RequestMethod.POST)
	public String insertContent(FindingMentorDto dto) {
		dto.setMemberseq("1");
		log.info("{}",dto);
		boolean chk = service.insertContent(dto);
		return chk?"redirect:/FindingMentor_board.do":"redirect:/writeForm.do";
	}
	
	// 게시글 신고
	@RequestMapping(value="reportContentChk.do", method = RequestMethod.POST)
	@ResponseBody
	public String reportContentChk( String boardseq, HttpServletResponse res) {
		String memberseq = "1";
		log.info("{}, {}",memberseq,boardseq);
		res.setContentType("text/html; charset=utf-8");
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq",boardseq);
		// 세션에 있는 memberseq를 사용합니다.
		map.put("memberseq",","+memberseq+",");
		if(service.reportCntUpdate(map)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	// 멘토링 지원
	@RequestMapping(value="applyMentor.do", method = RequestMethod.POST)
	@ResponseBody
	public String applyMentor(String boardseq, HttpServletResponse res) {
		String memberseq = "1";
		log.info("{}, {}",memberseq,boardseq);
		res.setContentType("text/html; charset=utf-8");
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq",boardseq);
		// 세션에 있는 memberseq를 사용합니다.
		map.put("memberseq",","+memberseq+",");
		if(service.applyMentor(map)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	// 매칭 입력
	@RequestMapping(value="matching.do", method = RequestMethod.POST)
	@ResponseBody
	public String matching(MatchingDto dto, HttpServletResponse res) {
		// 세션에 있는 memberseq를 사용합니다.
		String memberseq = "1";
		dto.setMenteeseq(memberseq);
		log.info("{}",dto);
		res.setContentType("text/html; charset=utf-8");
		if(service.matching(dto)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
	
	
}
