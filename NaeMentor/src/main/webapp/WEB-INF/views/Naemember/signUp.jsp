<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
<link type="text/css" rel="stylesheet" href="./css/naeMember/signUp.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/signUp.js"></script>
<script type="text/javascript" src="./js/sms.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<body>
<%@include file="/WEB-INF/views/noneTopMenu.jsp"%>
	
	<div id="container" style="margin: 0 auto;">
	<input type="hidden" id="chkval" value="0">
	<form action="./signUp.do" method="post" id="frm" name="frm" onsubmit="return check()">
		<div id="info">
			<div id="centerInfo">
				<h3 class="join_title1">
					<label for="pswd1">*아이디</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="email" name="email" id="email" placeholder="이메일">
				</span>
				<span id="result"></span>
				<input type="button" class="myButton" id="emailConfirm" onclick="emailConfirm1()" value="이메일 인증"><br>
				<h3 class="join_title">
					<label for="pswd1">*인증번호</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="emailNum" id="emailNum" placeholder="인증 번호 입력">
				</span>
				<input type="button" class="myButton" id="emailChk" onclick="emailChk1()" value="인증"><br>
				<h3 class="join_title">
					<label for="pswd1">*비밀번호</label>
				</h3> 
				<span class="ps_box int_id">
				<input class="int" type="password" id="password" name="password" placeholder="숫자,특수문자 각 1회 이상 사용, 8자리 이상">
				</span>
				<h3 class="join_title">
					<label for="pswd1">*비밀번호 확인</label>
				</h3> 
				<span class="ps_box int_id">
				<input class="int" type="password" id="passOk" placeholder="비밀번호 확인 ">
				</span>
				<h3 class="join_title">
					<label for="pswd1">*닉네임</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" id="nickname" name="nickname" placeholder="닉네임"><br>
				</span>
				<span id="result_nickname"></span>
				<h3 class="join_title">
					<label for="pswd1">*자기소개</label>
				</h3>
				<textarea class="int1" rows="5" cols="30" id="introduce" name="introduce" placeholder="자기소개"></textarea><br>
				<h3 class="join_title">
					<label for="pswd1">*휴대전화 번호</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" id="phone" name="phone" placeholder="휴대폰 번호입력(- 포함)">
				</span>
				<input type="button" class="myButton" onclick="sendSms()" id="send" value="전송"/> <br>
				<h3 class="join_title">
					<label for="pswd1">*인증번호</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
				</span>
				<input type="button" id="smsCheck" class="myButton" onclick="numberCheck()" value="인증"/><br> 
				<h3 class="join_title">
					<label for="pswd1">*생년월일</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" id="birthday" name="birthday" placeholder="생년월일(YYYYMMDD)"><br>
				</span>
				<h3 class="join_title">
					<label for="pswd1">*성별</label>
				</h3>
				<span class="ps_box int_id">
				<select class="int" name="gender">
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select><br>
				</span>
				<h3 class="join_title">
					<label for="pswd1">*관심분야</label>
				</h3>
				<span class="ps_box int_id">
				<select class="int" name="target">
					<option value="실무">실무</option>
					<option value="취업">취업</option>
					<option value="자격증">자격증</option>
					<option value="취미">취미</option>
					<option value="교육">교육</option>
				</select><br>
				</span>
			</div>
				<div id="button">
						<input type="submit" class="myButton" value="프로필 작성">
						<input type="button" class="myButton" value="돌아가기" onclick="javascript:history.back(-1)">
				</div>
		</div>
	</form>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>


</body>
</html>