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
	
//	
//	@RequestMapping(value = "Payment.do", method = RequestMethod.GET)
//	public String payment() {
//		log.info("payment Payment:\t {}", new Date());
//		return "Payment/Payment_pay";
//	}
	
	private int price = 1;
	private final String NUM = "naementor";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "Payment_pay.do", method = RequestMethod.GET)
	public String paymentPay(String boardseq, HttpSession session) {
		
		log.info("payment Payment_pay.do:\n {}", new Date());
		
		boardseq = "000020000";
		String payNum = NUM+boardseq;
		
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
		String token = (String) jsonresult.get("payToken");
		String checkoutPage = (String) jsonresult.get("checkoutPage");
		
		System.out.println("token 값: "+token);
		System.out.println("checkoutPage: "+checkoutPage);
		
		session.setAttribute("payUrl", checkoutPage);

//		model.addAttribute("payed", checkoutPage);
//		session.setAttribute("token", token);
//		
		return "Payment/Payment_pay";
	}
	
	@RequestMapping(value = "Payment_result.do", method = RequestMethod.GET)
	public String paymentResult(String status, HttpSession session) {
		log.info("paymentResult Payment_result.do:\t {}", new Date());
		System.out.println("결제 완료: "+status);
		String token = (String)session.getAttribute("token");
		System.out.println("승인된 결제 토큰: "+token);
		
		session.setAttribute("token", token);

		return "Payment/Payment_result";
	}
	
	@RequestMapping(value = "/cancel.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String cancel(HttpSession session) {
		log.info("Welcome cancel.do:\t {}", new Date());
		System.out.println("나 취소했다 리말이야");
		
		URL url = null;
		URLConnection connection = null;
		StringBuilder responseBody = new StringBuilder();
		
		String token = (String)session.getAttribute("token");
		System.out.println(token + "나 환불 토큰이야 이것드라");
		try {
			url = new URL("https://pay.toss.im/api/v2/refunds");
			connection = url.openConnection();
			connection.addRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);

			org.json.simple.JSONObject jsonBody = new JSONObject();
			jsonBody.put("payToken",token);
			jsonBody.put("amount", "5000");
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
		
		return "cancel";
		
	}
	
	@RequestMapping(value = "payCheck.do", method = RequestMethod.GET)
	public String payCheck() {
		
		log.info("Welcome payCheck.do:\t {}", new Date());
		System.out.println("나 결제상태 왔어");
		
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
			jsonBody.put("orderNo", null);
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
		return "payCheck";
	}
	
}
