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
	
	<form action="./applymentor.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="memberseq" value="${profile.memberseq}">
	photo<input type="text" name="photo" value="${profile.profiledto.photo}"><br>
	school<input type="text" name="school" value="${profile.profiledto.school}"><br>
	major<input type="text" name="major" value="${profile.profiledto.major}"><br>
	career<input type="text" name="career" value="${profile.profiledto.career}"><br>
	certificate<input type="text" name="certificate" value="${profile.profiledto.certificate}"><br>
	specialfield<input type="text" name="specialfield" value="${profile.profiledto.specialfield}"><br>
	files<input type="file" name="files"><br>
	<input type="submit" value="멘토신청">
	</form>
	
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>