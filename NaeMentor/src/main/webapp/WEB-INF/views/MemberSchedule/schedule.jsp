<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 조율</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<!-- 등록 -->
	<div>
	<form action="./insertSchedule.do" method="post">
		날짜<input type="date" name="date"><br>
		시간<input type="time" name="time"><br>
		<hr>
		장소<input type="text" name="loc" required="required"><br>
		<input type="submit">
	</form>
	</div>
	<!-- 삭제 -->
	<div>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>