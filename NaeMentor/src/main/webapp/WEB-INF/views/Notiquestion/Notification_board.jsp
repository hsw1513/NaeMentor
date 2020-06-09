<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<script type="text/javascript" src="./js2/Notiquestion.js"></script>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		<h1>자 이제 시작!</h1>
		<form action="./">
		
		<div>
			<table class="table table-hover">
				<tr>
					<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
						<th>글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>삭제여부</th>
				</tr>
				 <c:if test="${empty lists}">
		 		<tr>
		 		<th colspan="6">작성된 글이 존재하지 않습니다.</th>
		 		</tr>
		 		</c:if>
		 		<c:forEach var="dto" items="${lists}" varStatus="vs">
		 			<tr>
					<td><input type="checkbox" name="chk" value="${dto.adminseq}"></td>
						<td>${fn:length(lists) - vs.index}</td>
						<td>
							<a title="${dto.title}" href="./Notification_boardDetail.do?adminseq=${dto.adminseq}" style="color: black;">
									<c:choose>
										<c:when test="${fn:length(dto.title)>10 }">
											${fn:substring(dto.title,0,10)}...
										</c:when>
										<c:otherwise>${dto.title}</c:otherwise>
									</c:choose> 
							</a>
						</td>
						<td>관리자</td>
						<td>${dto.writedate}</td>
<!-- 					관리자만 보이게 -->
						<td>${dto.delflag}</td>
					</tr>
		 		</c:forEach>
			</table>
		</div>
		</form>
		<div style="text-align: center; margin-top: 20px;">
<!-- 			관리자만 보이게-->
			<input type="submit" value="삭제">
			<input type="button" value="글쓰기" onclick ="notiBorardWrite()">
		</div>
		<script type="text/javascript">
			function notiBorardWrite(){
				location.href="./Notification_boardWrite.do";
			}
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>