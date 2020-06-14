package com.min.naementor.spring.controllers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Payment_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	private int price = 1;
	private final String NUM = "naementor";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "Payment_pay.do", method = RequestMethod.GET)
	public String paymentPay(Model model, String boardseq, HttpSession session) {
		
		log.info("payment Payment_pay.do:\n {}", new Date());
		
		boardseq = "000040018";
		String payNum = NUM+boardseq;
		System.out.println("payNum: "+payNum);
		
		URL url = null;
		URLConnection connection = null;
		StringBuilder responseBody = new StringBuilder();
		
		try {
			
			url = new URL("https://pay.toss.im/api/v2/payments");
			connection = url.openConnection();
			connection.addRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			org.json.simple.JSONObject jsonBody = new JSONObject();
			jsonBody.put("orderNo", payNum);
			jsonBody.put("amount", price);
			jsonBody.put("amountTaxFree", 0);
			jsonBody.put("productDesc", "테스트 결제");
			jsonBody.put("autoExecute", true);
			jsonBody.put("apiKey", "sk_test_w5lNQylNqa5lNQe013Nq");
			jsonBody.put("resultCallback", "http://localhost:8093/NaeMentor/Payment_callback.do");
			jsonBody.put("callbackVersion", "V2");  
		    jsonBody.put("retUrl", "http://localhost:8093/NaeMentor/Payment_result.do?orderno="+payNum);
		    jsonBody.put("retCancelUrl", "http://localhost:8093/NaeMentor/Payment_close.do");

			BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			
		    bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
			bos.flush();
			bos.close();

		    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			br.close();
		} catch (Exception e) {
			responseBody.append(e);
		}
		System.out.println("응답 받은 내용: "+responseBody.toString());
		
		String s = responseBody.toString();
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject jsonresult = (JSONObject) obj;
		String paytoken = (String) jsonresult.get("payToken");
		String checkoutPage = (String) jsonresult.get("checkoutPage");
		
		System.out.println("token 값: "+paytoken);
		System.out.println("checkoutPage: "+checkoutPage);

		session.setAttribute("payUrl", checkoutPage);

//		model.addAttribute("payed", checkoutPage);
//		session.setAttribute("token", paytoken);
//		session.setAttribute("menteepay", menteepay);
//		session.setAttribute("menteepaytime", menteepaytime);
		
		return "Payment/Payment_pay";
	}

	@RequestMapping(value = "Payment_result.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String paymentResult(String status, String payToken, String paidAmount, String paidTs, HttpSession session) {
		log.info("paymentResult Payment_result.do:\t {}", new Date());
		
		System.out.println("**************결제 상태: "+status);
		System.out.println("**************결제 토큰: "+payToken);
		System.out.println("**************승인 금액: "+paidAmount);
		System.out.println("**************승인 시간: "+paidTs);
			
		return "Payment/Payment_result";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "Payment_close.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String paymentClose(HttpSession session) {
		log.info("paymentClose Payment_close.do:\t {}", new Date());
		System.out.println("취소했음");
		
		URL url = null;
		URLConnection connection = null;
		StringBuilder responseBody = new StringBuilder();
		
		String paytoken = (String)session.getAttribute("paytoken");
//		String payNum = (String)session.getAttribute("payNum");
		String menteepay = (String)session.getAttribute("menteepay");
		System.out.println("환불토큰: "+paytoken);
		System.out.println("환불금액: "+menteepay);
		
		try {
			url = new URL("https://pay.toss.im/api/v2/refunds");
			connection = url.openConnection();
			connection.addRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);

			org.json.simple.JSONObject jsonBody = new JSONObject();
			jsonBody.put("payToken",paytoken);
			jsonBody.put("amount", menteepay);
			jsonBody.put("apiKey", "sk_test_w5lNQylNqa5lNQe013Nq");

			BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			
		    bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
			bos.flush();
			bos.close();

			
		    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			br.close();
		} catch (Exception e) {
			responseBody.append(e);
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&"+responseBody.toString());
		String s = responseBody.toString();
		
		return "Payment/Payment_close";
		
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "Payment_check.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String paymentCheck(String orderNo, HttpSession session) {
		
		log.info("paymentCheck Payment_check.do:\t {}", new Date());
		System.out.println("결제상태");
		
		URL url = null;
		URLConnection connection = null;
		StringBuilder responseBody = new StringBuilder();
		try {
			url = new URL("https://pay.toss.im/api/v2/status");
			connection = url.openConnection();
			connection.addRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);

			org.json.simple.JSONObject jsonBody = new JSONObject();
			jsonBody.put("orderNo", orderNo);
			jsonBody.put("apiKey", "sk_test_w5lNQylNqa5lNQe013Nq");

			BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			
		    bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
			bos.flush();
			bos.close();

			
		    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			br.close();
		} catch (Exception e) {
			responseBody.append(e);
		}
		System.out.println(responseBody.toString());
		return "Payment/Payment_check";
	}
	
}
