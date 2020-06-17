<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/basic.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/captcha.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<body>
<div id="container">
	<form id="forlogin" action="./logingo.do" method="POST">
	아이디 : <input type="email" id="email" name="email"> <br>
	비밀번호 : <input type="password" name="password"> <br>
	<br>
	<input name ="remember-me" type = "checkbox"/>로그인 유지
	<input type="button" onclick="searchLoginCnt()" value="제출"><br>
	</form>
	
<!--  캡차 -->
<div id="captcha" style="display: none;">
<img  src="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${key}">
<form method="get">
	<input type="hidden" id="key" name="key" value="${key}">
	입력 : 
	<input type="text" id="chk" name="chk">	
	<input type="button" value="제출" onclick="passCaptcha()">
</form>
</div>

	<a href="./yakGwanGo.do">회원가입</a>
	<a href="./searchIdPW.do">아이디/비밀번호 찾기</a>
</div>
</body>
</html>