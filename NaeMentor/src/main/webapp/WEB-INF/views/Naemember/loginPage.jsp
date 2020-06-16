<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="./yakGwanGo.do">회원가입</a>
	<a href="./searchIdPW.do">아이디/비밀번호 찾기</a>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>	
</body>
</html>