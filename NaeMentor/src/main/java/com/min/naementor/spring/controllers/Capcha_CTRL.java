package com.min.naementor.spring.controllers;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.min.naementor.spring.model.capcha.Capcha_IService;

@Controller
public class Capcha_CTRL {
		//키를 받아오는 클래스
		@Qualifier("gotKey")
		private Capcha_IService getKey;
		
		// 사용자 입력값 판단하는 클래스
		@Qualifier("valChk")
		private Capcha_IService valchk;
		
		
		//캡챠가 구현되는 페이지
		@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
		public String main(Model model) {
			
			String key = getKey.get("0");
			System.out.println(key+"키 받아왔나요?");
			
			// json으로 key 값 뽑아오기
	        JSONParser parser  = new JSONParser();
	        Object obj = null;
			try {
				obj = parser.parse(key);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        JSONObject jsonobj = (JSONObject) obj;
	        
	        key = (String) jsonobj.get("key");
	        System.out.println(key);
	        if(key != null) {
	        	model.addAttribute("key",key);
	        }

	        return "Naemember/loginPage";
		}
		
		//결과값을 표출하는 페이지
		@RequestMapping(value = "/valchk.do", method = RequestMethod.POST)
		public String chk(Model model, String chk, String key) {
			
			String attach = "1&key="+key+"&value="+chk;
			String result = valchk.get(attach);
			System.out.println(result);
			
			//json으로 결과 값 뽑아오기
			 JSONParser parser  = new JSONParser();
		        Object obj = null;
				try {
					obj = parser.parse(result);
				} catch (ParseException e) {
					e.printStackTrace();
				}
		        JSONObject jsonobj = (JSONObject) obj;
		        boolean isc = (boolean) jsonobj.get("result");
		        Double time = (Double) jsonobj.get("responseTime");
		        model.addAttribute("result", isc);
		        model.addAttribute("time", time);
			
			return "Naemember/loginPage";
		}
}
