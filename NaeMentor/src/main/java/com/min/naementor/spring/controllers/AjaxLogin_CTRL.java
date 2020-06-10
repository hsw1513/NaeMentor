package com.min.naementor.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.naementor.spring.model.naemember.Naemember_IService;

@Controller
public class AjaxLogin_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Naemember_IService service;
	
	// 이메일 중복검사 아작스
		@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> idDupleCheck(String email) {
			log.info("이메일 중복검사");
			Map<String, String> map = new HashMap<String, String>();
			boolean isc = service.idDupleChk(email);
			map.put("isc", isc+"");
			return map;
		}
	
}
