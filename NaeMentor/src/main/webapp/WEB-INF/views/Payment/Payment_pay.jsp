<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토링 결제 생성</title>
</head>
<body>
	<a href=${payUrl}>결제하러가기</a>
	<input type="button" value="결제하기" onclick ="location.href=${payUrl}">
	<button onclick ="location.href='${payUrl}'">결제</button>
</body>
</html>