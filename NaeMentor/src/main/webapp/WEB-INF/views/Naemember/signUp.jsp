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
	
	<form action="./signUp.do" method="post" id="frm" name="frm" enctype="multipart/form-data" onsubmit="return check()">
		<div id="info">
			<div id="leftInfo">회원가입</div>
			<div id="centerInfo">
				<input type="email" name="email" id="email" placeholder="이메일"><br>
				<span id="result"></span>
				<input type="password" id="password" name="password" placeholder="비밀번호"><br>
				<input type="password" id="passOk" placeholder="비밀번호 확인 "><br>
				<span id="result_pw"></span>
				<input type="text" id="nickname" name="nickname" placeholder="닉네임"><input type="button" onclick="nickChk()"><br>
				<textarea rows="5" cols="30" id="introduce" name="introduce" placeholder="자기소개"></textarea><br>
				<input type="text" id="phone" name="phone" placeholder="휴대폰 번호입력(- 포함)"><br>
				<input type="button" class="btn btn-primary" onclick="sendSms()" id="send" value="전송"/> <br>
				<input type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
				<input type="button" class="btn btn-info" onclick="numberCheck()" value="인증"/><br> 
				<input type="text" id="birthday" name="birthday" placeholder="생년월일"><br>
				성별:
				<select name="gender">
					<option value="M">남자</option>
					<option value="F">여자</option>
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