<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="./css/basic.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="height: 100px;">
    <div class="navbar-header">
      <a class="navbar-brand" href="./boardList.do">
      	<img alt="logo" src="./img/naementor.png" style="width:auto; height: 50px;">
      </a>
    </div>
    <ul class="nav navbar-nav">
    		<li><a href="./boardList.do">게시판</a></li>
    		<li><a href="./FindingMentor_board.do">FindgingMentor보드로 이동</a></li>
<%--     	<c:if test="${fn:trim(mem.auth) eq 'U'}"> --%>
    		<li><a href="./writeForm.do">글작성</a></li>
<%--     	</c:if> --%>
<%--     	<c:if test="${fn:trim(mem.auth) eq 'A'}"> --%>
    		<li><a href="./memberListMAV.do">회원리스트</a></li>
<%--     	</c:if> --%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
     	 <a href="./userInfo.do">
      		<span class="glyphicon glyphicon-user">${mem.name}님 환영합니다.(${mem.auth eq 'U'?'일반':'관리자'})</span> 
      	</a>
     </li>
      <li>
      	<a href="./logout.do">
      		<span class="glyphicon glyphicon-log-out">로그아웃</span> 
      	</a>
      </li>
    </ul>
  </div>
</nav>