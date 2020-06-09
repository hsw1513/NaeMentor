package com.min.naementor.spring.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
import com.min.naementor.spring.comm.SplitUserComm;
import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;

@Controller
public class FindingMentor_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_IService service;
	
	@RequestMapping("FindingMentor_board.do")
	public String board(Model model) {
		model.addAttribute("board_lists", service.selectAll());
		return "FindingMentor/FindingMentor_board";
	}
	@RequestMapping(value = "detailContent.do", method = RequestMethod.GET)
	public String detailContent(Model model, String memberseq, String boardseq , SplitUserComm comm) {
		log.info("{}, {}",memberseq, boardseq);
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		FindingMentorDto dto = service.detailContent(map);
		String[] _memberseq = comm.splitId(dto.getMentorlist());
		System.out.println(Arrays.toString(_memberseq)+"--------------------------------------------------------------------------");
		Map<String, String[]> map2 = new HashMap<String, String[]>();
		map2.put("_memberseq", _memberseq);
		model.addAttribute("findMentor", service.chkMentor(map2));
		model.addAttribute("detail", dto);
		return "FindingMentor/detailContent";
	}
	@RequestMapping("deleteContent.do")
	public String deleteContent(String boardseq, String memberseq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq",boardseq);
		map.put("memberseq",memberseq);
		service.deleteContent(map);
		return "redirect:/FindingMentor_board.do";
	}
	@RequestMapping(value="modifyContent.do", method = RequestMethod.POST)
	public String modifyContent(FindingMentorDto dto) {
		log.info("{}",dto);
		service.modifyContent(dto);
		return "redirect:/FindingMentor_board.do";
	}
	@RequestMapping("writeForm.do")
	public String writeForm() {
		log.info("{}",new Date());
		return "FindingMentor/writeForm";
	}
	@RequestMapping(value="insertContent.do",method = RequestMethod.POST)
	public String insertContent(FindingMentorDto dto) {
		dto.setMemberseq("1");
		log.info("{}",dto);
		boolean chk = service.insertContent(dto);
		return chk?"redirect:/FindingMentor_board.do":"redirect:/writeForm.do";
	}
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
	@RequestMapping(value="applyMentor.do", method = RequestMethod.POST)
	@ResponseBody
	public String applyMentor(String memberseq, String boardseq, HttpServletResponse res) {
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
	
	
	
	
}
