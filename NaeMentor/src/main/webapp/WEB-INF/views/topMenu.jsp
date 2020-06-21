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
<script type="text/javascript">
	function changeAuth(chkRole){
		if(chkRole == 'ROLE_E'){
			if(confirm('멘토로 권한을 변경합니다.')){
				location.href = "./changeAuth.do";
			}else{
				alert('취소되었습니다.');
			}
		}else if(chkRole == 'ROLE_R'){
			if(confirm('멘티로 권한을 변경합니다.')){
				location.href = "./changeAuth.do";
			}else{
				alert('취소되었습니다.');
			}
		}
	}
</script>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="height: 100px;">
    <div class="navbar-header">
      <a class="navbar-brand" href="./FindingMentor_board.do">
      	<img alt="logo" src="./img/naementor.png" style="width:auto; height: 50px;">
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<c:if test="${fn:trim(userinfo.auth) eq 'ROLE_A'}">
    		<li><a href="./adminBoard.do">관리자페이지</a></li>
    	</c:if>
    </ul>
    <ul>
      				<c:if test="${userinfo.authorchk eq 'Y' && userinfo.auth eq 'ROLE_E'}"><button value="${userinfo.auth}" onclick="changeAuth(this.value)">멘티_11</button></c:if>
      				<c:if test="${userinfo.authorchk eq 'Y' &&userinfo.auth eq 'ROLE_R'}"><button value="${userinfo.auth}" onclick="changeAuth(this.value)">멘토_11</button></c:if>
    	</ul>
    <ul class="nav navbar-nav navbar-right">
    	
      <li>
     	 <a href="./Profile.do">
      		<span class="glyphicon glyphicon-user">
      				<c:if test="${userinfo.auth eq 'ROLE_E'}">멘티_</c:if>
      				<c:if test="${userinfo.auth eq 'ROLE_R'}">멘토_</c:if>
      		<c:if test="${userinfo.auth eq 'ROLE_A'}">관리자_</c:if>${userinfo.nickname}님, 환영합니다.</span> 
      		
      	</a>
     </li>
      <li>
      	<a href="./Question_board.do">
      		<span class="glyphicon 	glyphicon glyphicon-question-sign">&nbsp;1:1 문의</span> 
      	</a>
      </li>
      <li>
      	<a href="./logoutgo.do?email=${userinfo.email}">
      		<span class="glyphicon glyphicon-log-out">&nbsp;로그아웃</span> 
      	</a>
      </li>
      
    </ul>
  </div>
</nav>