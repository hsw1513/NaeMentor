package com.min.naementor.spring.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.dtos.OfferDto;
import com.min.naementor.spring.comm.AttachFile_Module;
import com.min.naementor.spring.comm.RowNumUtil;
import com.min.naementor.spring.comm.SplitUserComm;
import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;
import com.min.naementor.spring.model.matching.Matching_IService;
import com.min.naementor.spring.model.notiquestion.Notiquestion_IService;
import com.min.naementor.spring.model.offer.Offer_IService;

@Controller
public class FindingMentor_CTRL {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_IService service;
	@Autowired
	private Matching_IService mservice;
	@Autowired
	private Notiquestion_IService nservice;
	
	// 게시판 리스트 
	@RequestMapping("FindingMentor_board.do")
	public String board(Model model, HttpSession session) {
		NaememberDto dto = (NaememberDto) session.getAttribute("userinfo");
		model.addAttribute("board_lists", service.selectAll());
		Map<String,String> map = new HashMap<String, String>();
		if(dto.getAuth().equalsIgnoreCase("ROLE_E")) {
			map.put("menteeseq", dto.getMemberseq());
		}else {
			map.put("mentorseq", dto.getMemberseq());
		}
		model.addAttribute("complete_lists", service.chkComplete(map));
		model.addAttribute("matching_lists", service.chkMatching(map));
		model.addAttribute("complete_lists", service.chkComplete(map));
		
		// 공지사항
		RowNumUtil rUtil = new RowNumUtil();
		rUtil.setTotal(nservice.notiBoardListTotal());
		
		List<NotiQuestionDto> lists = nservice.notiAll(rUtil);
		List<NotiQuestionDto> lists2 = new ArrayList<NotiQuestionDto>();
		
		model.addAttribute("row", rUtil);
		model.addAttribute("lists", lists);
		
		lists2.add(lists.get(0));
		lists2.add(lists.get(1));
		lists2.add(lists.get(2));
		lists2.add(lists.get(3));
		lists2.add(lists.get(4));
		model.addAttribute("lists2", lists2);
		
		return "FindingMentor/FindingMentor_board";
	}
	
	// 상세보기
	@RequestMapping(value = "detailContent.do", method = RequestMethod.GET)
	public String detailContent(HttpSession session,Model model, String memberseq, String boardseq , SplitUserComm comm) {
		log.info("{}, {}",memberseq, boardseq);
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardseq", boardseq);
		NaememberDto ndto = (NaememberDto) session.getAttribute("userinfo");
		String[] _memberseq = null;
		List<NaememberDto> lists = null;
		Map<String, String[]> map2 = new HashMap<String, String[]>();
		// 게시물 조회
		FindingMentorDto dto = service.detailContent(map);
		if(ndto.getAuth().equalsIgnoreCase("ROLE_E")) {
		// 멘토 지원자 조회
		_memberseq = comm.splitId(dto.getMentorlist());
		map2.put("_memberseq", _memberseq);
		// 멘티 정보 조회
		}else {
		_memberseq = new String[1];
		_memberseq[0] = ndto.getMemberseq();
		map2.put("_memberseq", _memberseq);
		}
		// 매칭 정보 확인
		MatchingDto mdto = mservice.chkMatching(boardseq);
		lists = service.chkUser(map2);
		
		model.addAttribute("findMentor", lists);
		model.addAttribute("detail", dto);
		model.addAttribute("matching", mdto);
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
	@Autowired
	private AttachFile_Module module;
	@RequestMapping(value="insertContent.do",method = RequestMethod.POST)
	public String insertContent(String date, String time,FindingMentorDto dto, HttpSession session,@RequestParam("file") List<MultipartFile> files, HttpServletRequest request, HttpServletResponse resp) {
		NaememberDto ndto = (NaememberDto) session.getAttribute("userinfo");
		dto.setMemberseq(ndto.getMemberseq());
		String[] dateA = date.split("-");
		String[] timeA = time.split(":");
		String conDate = dateA[0]+dateA[1]+dateA[2];
		String conTime = timeA[0]+timeA[1];
		dto.setMentoringdate(conDate+conTime);
		List<AttachFileDto> lists = null;
		int fileCnt = files.size();
		log.info("fileCnt{}::::::{}",fileCnt,dto);
		module.setMemberseq(ndto.getMemberseq());
		if(fileCnt!=0) {
		 lists = module.attachFile(files, request, resp);
		}
		boolean chk =  service.insertContent(dto);
		
		return chk?"redirect:/FindingMentor_board.do":"redirect:/writeForm.do";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject upload(@RequestParam MultipartFile upload, HttpServletRequest request, HttpServletResponse resp) {
		log.info("ajax image upload");
		return module.ckImgUpload(upload, request, resp);
	}
	
	// 게시글 신고
	@RequestMapping(value="reportContentChk.do", method = RequestMethod.POST)
	@ResponseBody
	public String reportContentChk( String boardseq, HttpServletResponse res, HttpSession session) {
		NaememberDto ndto = (NaememberDto) session.getAttribute("userinfo");
		String memberseq = ndto.getMemberseq();
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
	public String applyMentor(String boardseq, HttpServletResponse res, HttpSession session) {
		NaememberDto ndto = (NaememberDto) session.getAttribute("userinfo");
		String memberseq = ndto.getMemberseq();
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
	@RequestMapping(value="/matching.do", method = RequestMethod.POST)
	@ResponseBody
	public String matching(MatchingDto dto, HttpServletResponse res, HttpSession session) {
		// 세션에 있는 memberseq를 사용합니다.
		NaememberDto ndto = (NaememberDto) session.getAttribute("userinfo");
		String memberseq = ndto.getMemberseq();
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
