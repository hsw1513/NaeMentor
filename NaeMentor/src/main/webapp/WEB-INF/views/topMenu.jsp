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
    		<li><a href="./Notification_board.do">공지사항</a></li>
    		<li><a href="./Question_board.do">1:1 문의</a></li>
    		<li><a href="./Profile.do">나의 프로필 관리</a></li>
    	<c:if test="${fn:trim(userinfo.auth) eq 'ROLE_A'}">
    		<li><a href="./adminBoard.do">관리자페이지</a></li>
    	</c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
     	 <a href="./userInfo.do">
      		<span class="glyphicon glyphicon-user">${userinfo.nickname}님 환영합니다.</span> 
      		<c:if test="${userinfo.auth eq 'ROLE_E'}">(멘티)</c:if>
      		<c:if test="${userinfo.auth eq 'ROLE_R'}">(멘토)</c:if>
      		<c:if test="${userinfo.auth eq 'ROLE_A'}">(관리자)</c:if>
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