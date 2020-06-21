package com.min.naementor.spring.comm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.min.naementor.spring.model.naemember.Naemember_IService;

public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private Naemember_IService service;
	
	private String email;
	private String password;
	private String errormsgname;
	private String defaultFailureUrl;
	
	public LoginFailureHandler() {
		
	}
	
	public LoginFailureHandler(String email, String password, String errormsgname, String defaultFailureUrl) {
		super();
		this.email = email;
		this.password = password;
		this.errormsgname = errormsgname;
		this.defaultFailureUrl = defaultFailureUrl;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrormsgname() {
		return errormsgname;
	}

	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		if(!service.loginCount(map)) {
		System.out.println("******실패**********");
		
		}
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("아이디와 비밀번호를 확인해주세요", errormsgname);
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
	
}
