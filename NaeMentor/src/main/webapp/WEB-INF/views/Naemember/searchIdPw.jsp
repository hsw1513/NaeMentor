<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script type="text/javascript" src="./js/searchIdPw.js"></script>
<body>

	<div id="container">
			<h2>아이디 찾기</h2>
		<form id="idSend1" method="post">
			<input type="text" id="phone" name="phone" placeholder="휴대전화 번호입력(-포함)"><br>
			<input type="text" id="birthday" name="birthday" placeholder="생년월일 입력(ex:19990101)"/><br>
		</form>
		<button class="myButton" onclick="idChk()">아이디 찾기</button>

			<h2>비밀번호 찾기</h2>
		<form id="pwSend1" method="post">
			<input type="email" id="pwemail" name="email" placeholder="ID 입력"><br>
			<input type="text" id="pwbirthday" name="birthday" placeholder="생년월일 입력(ex:19990101)"/><br>
		</form>
		<button class="myButton" onclick="pwChk()">아이디 찾기</button><br>
		<button class="myButton" onclick="javascript:history.back(-1)">돌아가기</button>
	</div>
</body>
</html>