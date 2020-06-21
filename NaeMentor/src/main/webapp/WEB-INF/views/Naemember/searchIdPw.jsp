<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
<link type="text/css" rel="stylesheet" href="./css/naeMember/searchIdPw.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script type="text/javascript" src="./js/searchIdPw.js"></script>
<body>
<%@include file="/WEB-INF/views/noneTopMenu.jsp"%>
	<div id="container">
		<div id="centerdiv">
			<h3 class="join_title">
				<label for="pswd1">아이디 찾기</label>
			</h3>
		<form id="idSend1" method="post">
			<span class="ps_box int_id">
			<input class="int" type="text" id="phone" name="phone" placeholder="휴대전화 번호입력(-포함)"><br>
			</span>
			<span class="ps_box int_id">
			<input class="int" type="text" id="birthday" name="birthday" placeholder="생년월일 입력(YYYYMMDD)"/><br>
			</span>
		</form>
		<button class="myButton1" onclick="idChk()">아이디 찾기</button>

			<h3 class="join_title1">
				<label for="pswd1">비밀번호 찾기</label>
			</h3>
		<form id="pwSend1" method="post">
			<span class="ps_box int_id">
			<input class="int" type="email" id="pwemail" name="email" placeholder="ID 입력"><br>
			</span>
			<span class="ps_box int_id">
			<input class="int" type="text" id="pwbirthday" name="birthday" placeholder="생년월일 입력(YYYYMMDD)"/><br>
			</span>
		</form>
		<button class="myButton1" onclick="pwChk()">비밀번호 찾기</button><br>
		<button class="myButton1" onclick="javascript:history.back(-1)">돌아가기</button>
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>