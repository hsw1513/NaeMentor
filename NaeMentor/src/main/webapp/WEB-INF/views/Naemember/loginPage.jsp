<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./logingo.do" method="POST">
	아이디 : <input type="text" name="email"> <br>
	비밀번호 : <input type="text" name="password"> <br>
	<br>
	<input name ="remember-me" type = "checkbox"/>로그인 유지
	<input type="submit" value="제출"><br>
</form>
	<a href="./singUpGo.do">회원가입</a>
</body>
</html>