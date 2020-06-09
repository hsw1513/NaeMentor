<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">

<c:if test="${session.auth} eq 'E'">
	"SELECT r.MENTORSTAR, r.CONTENT, r.WRITEDATE, p.MENTOACCSTAR, p.MENTORCNT 
FROM REVIEW r 
JOIN MATCHING m ON r.BOARDSEQ = m.BOARDSEQ
JOIN PROFILE p ON m.MENTORSEQ = p.MEMBERSEQ
WHERE m.MENTORSEQ =2;"
</c:if>
<c:if test="${session.auth} eq 'R'">
"SELECT r.MENTEESTAR , r.CONTENT, r.WRITEDATE, p.MENTEEACCSTAR , p.MENTEECNT 
FROM REVIEW r 
JOIN MATCHING m ON r.BOARDSEQ = m.BOARDSEQ
JOIN NAEMEMBER p ON m.MENTEESEQ = p.MEMBERSEQ
WHERE m.MENTEESEQ =1;"
</c:if>
<%-- <c:if test="${session.auth} eq 'A'"> --%>
"SELECT r.MENTORSTAR, r.CONTENT, r.WRITEDATE, p.MENTOACCSTAR, p.MENTORCNT 
FROM REVIEW r 
JOIN MATCHING m ON r.BOARDSEQ = m.BOARDSEQ
JOIN PROFILE p ON m.MENTORSEQ = p.MEMBERSEQ
WHERE m.MENTORSEQ =2;"
"SELECT r.MENTEESTAR , r.CONTENT, r.WRITEDATE, p.MENTEEACCSTAR , p.MENTEECNT 
FROM REVIEW r 
JOIN MATCHING m ON r.BOARDSEQ = m.BOARDSEQ
JOIN NAEMEMBER p ON m.MENTEESEQ = p.MEMBERSEQ
WHERE m.MENTEESEQ =1;"
<%-- </c:if> --%>

	
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>