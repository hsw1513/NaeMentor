<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/forlogin.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/captcha.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<body>
<div id="container" class="forlogin">
	<form id="forlogin" action="./logingo.do" method="POST">
		<div class="div0">
		<img alt="내멘토 로고_검정" class="logo_img" src="./img/logo_black.png">
		</div>
		<div class="div2">
			<input type="email" id="email" name="email" class="idinput" placeholder="아이디 (이메일)"> <br>
			<input type="password" name="password" class="idinput" placeholder="비밀번호"> <br>
		</div>
		<div class="div1">
			<input type="button" onclick="searchLoginCnt()" class="myButton" value="로그인"><br>
		</div>
		<div class="div3">
			<input name ="remember-me" type = "checkbox"/>로그인 유지
		</div>
	</form>
	
<!--  캡차 -->
<div id="captcha" style="display: none;">
	<img src="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${key}">
	<form method="get">
		<input type="hidden" id="key" name="key" value="${key}">
		<input type="text" id="chk" name="chk" placeholder="입력">	
		<input type="button" class="myButton1" value="제출" onclick="passCaptcha()">
	</form>
</div>
<div class="div4">
	<a href="./yakGwanGo.do">회원가입</a>
	<a href="./searchIdPW.do">아이디/비밀번호 찾기</a>
</div>
</div>
</body>
</html>