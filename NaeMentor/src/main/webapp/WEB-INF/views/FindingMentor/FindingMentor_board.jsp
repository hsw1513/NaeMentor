<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link type="text/css" rel="stylesheet" href="./css/mainPage.css">
</head>
<script type="text/javascript">
	function writeBoard(){
		location.href="./writeForm.do";
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<div class="div1">
<!-- 	<h1>매칭이 되지 않은 게시글들이 있는 영역</h1> -->
	<!-- 멘티의 영역 -->
	<div class="div6">
	<h1><b>${userinfo.nickname}님, 환영합니다.</b></h1><br>
	<c:if test="${userinfo.auth eq 'ROLE_E'}">
	<p style="font-size: 30px; margin: 0px;">오늘까지 멘토링 횟수: ${userinfo.menteecnt}회</p><br>
	<p style="font-size: 30px;">오늘까지 받은 별점: ${userinfo.menteeaccstar}★</p><br>
	</c:if>
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<p style="font-size: 30px; margin: 0px;">오늘까지 멘토링 횟수: ${userinfo.menteecnt}회</p><br>
	<p style="font-size: 30px;">오늘까지 받은 별점: ${userinfo.menteeaccstar}★</p><br>
	</c:if>
	</div>
	<div class="div7">
	<c:if test="${userinfo.auth eq 'ROLE_E'}">
	<button class="myButton2" onclick="writeBoard()">멘토 찾기</button>
	</c:if>
	</div>
	</div>
<!-- 	공지사항 -->
	<div class="div2">
	<p class="boardTitle">&nbsp;&nbsp;내멘토 공지</p>
	<a href="./Notification_board.do" style="cursor: pointer; float: right;">더보기</a>
	<table class="table table-hover">
    <tbody>
	<c:forEach items="${lists2}" var="nlists">
      <tr>
      	<td>공지</td>
        <td><a href='./Notification_board.do?adminseq=${nlists.adminseq}'>${nlists.title}</a></td>
        <td>${nlists.writedate}</td>
      </tr>
      </c:forEach>
       </tbody>
  		</table>
	</div>
	
	
	<div class="div3">
	<p class="boardTitle">&nbsp;&nbsp;매칭 대기 중</p>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>제목</th>
        <th>희망 일자</th>
        <th>신청 멘토</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${board_lists}" var="lists">
	<c:if test="${userinfo.memberseq eq lists.memberseq}">
      <tr>
        <td><a href='./detailContent.do?boardseq=${lists.boardseq}&memberseq=${lists.memberseq}'>${lists.title}</a></td>
        <td>${lists.mentoringdate}</td>
        <td>${lists.mentorlist}</td>
      </tr>
       </c:if>
      
	<!-- 멘토의 영역 -->
       
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<c:if test="${userinfo.target eq lists.target}">
	
      <tr>
        <td><a href='./detailContent.do?boardseq=${lists.boardseq}&memberseq=${lists.memberseq}'>${lists.title}</a></td>
        <td>${lists.mentoringdate}</td>
        <td>${lists.mentorlist}</td>
      </tr>
       </c:if>
       </c:if>
	</c:forEach>
    </tbody>
  </table>
 
 </div>
 <div class="div4">
<!--  <h1>매칭이 된 글들이 위치하는 영역</h1> -->
 <!-- 멘티의 영역 -->
	<p class="boardTitle">&nbsp;&nbsp;매칭 완료</p>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>제목</th>
        <th>멘토링 일자</th>
        <th>장소</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${matching_lists}" var="mlists">
	<c:if test="${userinfo.memberseq eq mlists.memberseq}">
      <tr>
        <td><a href='./detailContent.do?boardseq=${mlists.boardseq}&memberseq=${mlists.memberseq}'>${mlists.title}</a></td>
        <td>${mlists.mentoringdate}</td>
        <td>${mlists.location}</td>
      </tr>
       </c:if>
       
       
	<!-- 멘토의 영역 -->
       
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	
      <tr>
        <td><a href='./detailContent.do?boardseq=${mlists.boardseq}&memberseq=${mlists.memberseq}'>${mlists.title}</a></td>
        <td>${mlists.mentoringdate}</td>
        <td>${mlists.location}</td>
      </tr>
       </c:if>
	</c:forEach>
    </tbody>
  </table>
 
 	</div>
 	<div class="div5">
<!--  <h1>완료가 된 글들이 위치하는 영역</h1> -->
 <!-- 멘티의 영역 -->
	<p class="boardTitle">&nbsp;&nbsp;멘토링 완료</p>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>제목</th>
        <th>멘토링 일자</th>
        <th>장소</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${complete_lists}" var="clists">
	<c:if test="${userinfo.memberseq eq clists.memberseq}">
      <tr>
        <td><a href='./detailContent.do?boardseq=${clists.boardseq}&memberseq=${clists.memberseq}'>${clists.title}</a></td>
        <td>${clists.mentoringdate}</td>
        <td>${clists.location}</td>
      </tr>
       </c:if>
       
       
	<!-- 멘토의 영역 -->
       
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	
      <tr>
        <td><a href='./detailContent.do?boardseq=${clists.boardseq}&memberseq=${clists.memberseq}'>${clists.title}</a></td>
        <td>${clists.mentoringdate}</td>
        <td>${clists.location}</td>
      </tr>
       </c:if>
	</c:forEach>
    </tbody>
  </table>
 	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>