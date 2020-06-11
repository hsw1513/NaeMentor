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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script type="text/javascript">
// 	var dataf = "";
// 	window.onload = function(){
// 		dataf = "birthday="+document.getElementById("birthday").value+"&phone="+document.getElementById("phone").value;
// 	}
	
// 	$(function(){
// 		$.ajax(function(){
// 			url:"./idSend.do",
// 			data: dataf,
// 			method: "post",
// 			success: function(msg){
// 				alert(msg);
// // 				$("#birthday").prepend("<div>회원님의 ID는"+msg+"입니다.</div>");
// 		},
// 		error: function(){
// 				alert("정확한 아이디와 생년월일을 입력해주세요");
// 		}
// 	});
		
// 	});
	
// 	function btn1(){
// 		alert(dataf);
// 	}
</script>
<body>
	<div id="container">
			<h2>아이디 찾기</h2>
		<form action="./idSend.do" method="post">
			<input type="text" id="phone" name="phone" placeholder="휴대전화 번호입력(-포함)"><br>
			<input type="text" id="birthday" name="birthday" placeholder="생년월일 입력(ex:19990101)"/><br>
			<div id="button">
				<input type="submit" value="아이디 찾기">
			</div>
		</form>
<!-- 		<button onclick="btn1()">버튼</button> -->

			<h2>비밀번호 찾기</h2>
		<form action="./passwordSend.do" method="post">
			<input type="email" id="email" name="email" placeholder="ID 입력"><br>
			<input type="text" id="birthday" name="birthday" placeholder="생년월일 입력(ex:19990101)"/><br>
			<div id="button">
				<input type="submit" value="비밀번호 변경 URL 전송">
			</div>
		</form>
	</div>
</body>
</html>