<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
<link type="text/css" rel="stylesheet" href="./css/naeMember/changePassword.css">
<title>비밀번호 변경</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script type="text/javascript" src="./js/changePW.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/noneTopMenu.jsp"%>
<div id="container">
	<div id="centerdiv">
	<form id="newPWForm" action="./newPassword.do" method="post" onsubmit="return pwCheck()">
		<h3 class="join_title">
			<label for="pswd1">아이디</label>
		</h3>
		<span class="ps_box int_id">
		<input class="int" type="email" name="email" id="email" placeholder="아이디를 입력해주세요"><br>
		</span>
		<h3 class="join_title">
			<label for="pswd1">비밀번호</label>
		</h3>
		<span class="ps_box int_id">
		<input class="int" type="password" id="password" name="password" placeholder="새로운 비밀번호"><br>
		</span>
		<h3 class="join_title">
				<label for="pswd1">비밀번호 확인</label>
		</h3>
		<span class="ps_box int_id">
		<input class="int" type="password" id="passOk" placeholder="비밀번호 확인 "><br>
		</span>
	</form>
		<c:if test="${toEmail eq null}">
			<input type="hidden" name="myEmail" id="myEmail" value="${myEmail}">
			<button class="myButton1" onclick="myEmailChk()">비밀번호 변경</button>
		</c:if>
		
		<c:if test="${toEmail ne null }">
		<input type="hidden" name="toEmail" id="toEmail" value="${toEmail}">
			<button class="myButton1" onclick="emailChk()">비밀번호 변경</button>
		</c:if>
		
		<c:if test="${myREmail ne null }">
		<input type="hidden" name="myREmail" id="myREmail" value="${myREmail}">
			<button class="myButton1" onclick="myREmailChk()">비밀번호 변경</button>
		</c:if>
	</div>
</div>	
<%@include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>