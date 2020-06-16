<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/signUp.js"></script>
<script type="text/javascript" src="./js/sms.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<body>

	<div id="container">
		<input type="hidden" id="chkval" value="0">
	
	<form action="./signUp.do" method="post" id="frm" name="frm" onsubmit="return check()">
		<div id="info">
			<div id="leftInfo">회원가입</div>
			<div id="centerInfo">
				<span>아이디: <input type="email" name="email" id="email" placeholder="이메일"></span>
				<input type="button" id="emailConfirm" onclick="emailConfirm1()" value="이메일 인증"><br>
				<span id="result"></span>
				인증번호: <input type="text" name="emailNum" id="emailNum" placeholder="인증 번호 입력">
				<input type="button" id="emailChk" onclick="emailChk1()" value="인증"><br>
				비밀번호: <input type="password" id="password" name="password" placeholder="숫자, 특수문자 각 1회 이상 사용하여 8자리 이상 입력"><br>
				비밀번호 확인: <input type="password" id="passOk" placeholder="비밀번호 확인 "><br>
				<span id="result_pw"></span>
				닉네임: <input type="text" id="nickname" name="nickname" placeholder="닉네임"><br>
				<span id="result_nickname"></span>
				자기소개: <textarea rows="5" cols="30" id="introduce" name="introduce" placeholder="자기소개"></textarea><br>
				휴대폰 번호: <input type="text" id="phone" name="phone" placeholder="휴대폰 번호입력(- 포함)">
				<input type="button" class="btn btn-primary" onclick="sendSms()" id="send" value="전송"/> <br>
				인증번호: <input type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
				<input type="button" id="smsCheck" class="btn btn-info" onclick="numberCheck()" value="인증"/><br> 
				생년월일: <input type="text" id="birthday" name="birthday" placeholder="생년월일(19900101)"><br>
				성별:
				<select name="gender">
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select><br>
				관심분야:
				<select name="target">
					<option value="실무">실무</option>
					<option value="취업">취업</option>
					<option value="자격증">자격증</option>
					<option value="취미">취미</option>
					<option value="교육">교육</option>
				</select><br>
			</div>
				<div id="button">
						<input type="submit" class="btn btn-success" value="프로필 작성">
						<input type="button" class="btn btn-primary" value="돌아가기" onclick="javascript:history.back(-1)">
				</div>
		</div>
	</form>
	
	</div>



</body>
</html>