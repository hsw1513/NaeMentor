<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/basic.css">
</head>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
	<h1>hello</h1>
	${lists}
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
  </body>
</html>