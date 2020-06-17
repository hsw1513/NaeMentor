<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/basic.css">
</head>
<body>
<div id="container">
	<form action="./logingo.do" method="POST">
	아이디 : <input type="email" name="email"> <br>
	비밀번호 : <input type="password" name="password"> <br>
	<br>
	<input name ="remember-me" type = "checkbox"/>로그인 유지
	<input type="submit" value="제출"><br>
	</form>
	
	<!--  키가 있으면 캡챠 이미지를 띄운다. -->
	<c:choose>
	<c:when test="${!empty key}">
	<img  src="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${key}">

	<form action="./valchk.do" method="post">
		<input type="hidden" name="key" value="${key}">
		입력 : 
		<input type="text" name="chk">
		<input type="submit" value="제출">
	</form>
	</c:when>

	<c:otherwise>
	캡챠 오류입니다. 다시 시도해주세요
	</c:otherwise>

</c:choose>
	<a href="./yakGwanGo.do">회원가입</a>
	<a href="./searchIdPW.do">아이디/비밀번호 찾기</a>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>	
</body>
</html>