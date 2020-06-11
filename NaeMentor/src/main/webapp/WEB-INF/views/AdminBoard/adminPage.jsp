<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
EMAIL , NICKNAME , PHONE , BIRTHDAY , 
			GENDER , AUTH , USERSTATUS ,MENTORTIER, REPORTCNT ,
			TO_CHAR(JOINDATE, 'YYYY-MM-DD') AS JOINDATE , MENTEECNT, 
			MENTEEACCSTAR, LASTACCESS , BYEBYE
	<div id="container">
		<table>
			<thead>
				<tr>
					<th>이메일</th><th>닉네임</th><th>전화번호</th>
					<th>생년월일</th><th>성별</th><th>권한</th>
					<th>상태</th><th>멘토등급</th><th>신고당한 횟수</th>
					<th>가입일</th><th>최근접속일</th><th>탈퇴신청</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="userinfo" items="${lists}">
					<td>${userinfo.email}</td><td>${userinfo.nickname}</td>
					<td>${userinfo.phone}</td><td>${userinfo.birthday}</td><td>${userinfo.gender}</td>
					<td>${userinfo.auth}</td><td>${userinfo.userstatus}</td><td>${userinfo.mentortier}</td>
					<td>${userinfo.reportcnt}</td><td>${userinfo.joindate}</td><td>${userinfo.lastaccess}</td>
					<td>${userinfo.byebye}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>