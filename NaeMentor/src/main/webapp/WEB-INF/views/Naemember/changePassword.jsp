<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript" src="./js/changePW.js"></script>
</head>
<body>
	
	<form action="./newPassword.do" method="post" onsubmit="return pwCheck()">
		<input type="email" name="email" placeholder="아이디를 입력해주세요"><br>
		<input type="password" id="password" name="password" placeholder="비밀번호"><br>
		<input type="password" id="passOk" placeholder="비밀번호 확인 "><br>
		<input type="submit" class="btn btn-success" value="비밀번호 변경">
	</form>


</body>
</html>