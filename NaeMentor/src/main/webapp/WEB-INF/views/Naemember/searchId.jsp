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
<script type="text/javascript" src="./js/searchIdSms.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script type="text/javascript">
	$(function(){
		$("input:eq(3)").click(function(){
			$("input:eq(2)").toggle();
			$(this).toggle();
		});
	});
</script>
<body>
	
	<div id="container">
			<h2>휴대폰 본인인증</h2>
		<form action="./searchId.do">
			<input type="text" id="phone" name="phone" placeholder="휴대폰 번호입력(- 포함)">
			<input type="button" class="btn btn-primary" onclick="sendSms()" id="send" value="안증번호 전송"/> <br>
			<input type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
			<input type="button" id="numchk" class="btn btn-info" onclick="#" value="인증"/><br>
			
			<div id="button">
				<input type="button" class="btn btn-primary" value="돌아가기" onclick="javascript:history.back(-1)">
			</div>
		</form>
	</div>
</body>
</html>