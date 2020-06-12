<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	
	<form action="./applymentor.do" method="post">
	<input type="hidden" name="memberseq" value="${userinfo.memberseq}">
	<input type="image" name="photo" value="${userinfo.photo}">
	<input type="text" name="content" value="${userinfo.content}">
	<input type="text" name="school" value="${userinfo.school}">
	<input type="text" name="major" value="${userinfo.major}">
	<input type="text" name="career" value="${userinfo.career}">
	<input type="text" name="certificate" value="${userinfo.certificate}">
	<input type="text" name="specialfield" value="${userinfo.specialfield}">
	</form>
	
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>