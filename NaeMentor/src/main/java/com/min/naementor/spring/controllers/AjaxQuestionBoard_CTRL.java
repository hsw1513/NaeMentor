package com.min.naementor.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.spring.comm.RowNumUtil;
import com.min.naementor.spring.model.notiquestion.Notiquestion_IService;

@Controller
public class AjaxQuestionBoard_CTRL {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IService service;
	
	
	@RequestMapping(value = "/questionpage.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
	@ResponseBody
	public String qpage(HttpSession session, RowNumUtil rUtil) {
		log.info("questionpage qpage, {}", rUtil);
		
		JSONObject json = null;
		
		rUtil.setTotal(service.OtOBoardListTotal());
		json = makeJson(service.allOneToOneA(rUtil), rUtil);
		
		session.removeAttribute("row");
		session.setAttribute("row", rUtil);
		
		return json.toString();
	}
	@SuppressWarnings("unchecked")
	private JSONObject makeJson(List<NotiQuestionDto>lists, RowNumUtil row) {
		JSONArray jLists = new JSONArray(); // [{"":""},{"":""},{"":""},....]
		JSONObject jdto = new JSONObject(); // {"":""}
		JSONObject json = new JSONObject(); // {"":"[{"":""},{"":""},{"":""},....]"}
		
		
		// 화면 리스트 관련
		for (NotiQuestionDto dto : lists) {
			jdto = new JSONObject();
			jdto.put("adminseq", dto.getAdminseq());
			jdto.put("nickname", dto.getNamemberdto().getNickname());
			jdto.put("title", dto.getTitle());
			jdto.put("content", dto.getContent());
			jdto.put("delflag", dto.getDelflag());
			jdto.put("writedate", dto.getWritedate());
			jLists.add(jdto); // [{"":""},{"":""},{"":""},....]
		}
		System.out.println(jdto.get(jdto));
		
		// 페이지 관련
		jdto = new JSONObject(); // {"":""}
		jdto.put("pageList", row.getPageList());
		jdto.put("index", row.getIndex());
		jdto.put("pageNum", row.getPageNum());
		jdto.put("listNum", row.getListNum());
		jdto.put("total", row.getTotal());
		jdto.put("count", row.getCount());
		
		json.put("lists", jLists);
		json.put("row", jdto);
		
		System.out.println(json.toString());
		
		return json;
	}
}