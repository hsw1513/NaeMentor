<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 게시판</title>
</head>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		<h1>문의 게시판</h1>
		<div style="text-align: center; margin-top: 20px;">
			<input type="button" value="새글쓰기" onclick ="questionBorardWrite()">
		</div>
		<form action="./Notification_boardMultiDel.do" id="delmChk" method="post" onsubmit="return multiDelChk()">
		<div>
			<table class="table table-hover">
				<tr>
						<th>제목</th>						
						<td>
									<c:choose>
										<c:when test="${fn:length(dto.title)>10 }">
											${fn:substring(dto.title,0,10)}...
										</c:when>
										<c:otherwise>${dto.title}</c:otherwise>
									</c:choose> 
						</td>
				</tr>
				<tr>
						<th>작성일</th>
						<td>${dto.writedate}</td>
				</tr>
				<tr>
						<th>삭제여부</th>
						<td>${dto.delflag}</td>
				</tr>
				<tr>
						<th>작성자</th>
						<td>작성자: 수정 필요</td>
				</tr>
				<tr>
						<td style="text-align: center; margin-top: 20px;">
							<input type="button" value="수정">
							<input type="button" value="삭제">
<!-- 							관리자만 -->
							<input type="button" value="답변">
						</td>
				</tr>
				 <c:if test="${empty lists}">
		 		<tr>
		 		<th colspan="5">문의 글을 남겨주세요.</th>
		 		</tr>
		 		</c:if>
			</table>
		</div>
		</form>
		
		<script type="text/javascript">
			function questionBorardWrite(){
				location.href="./Question_boardWrite.do";
			}
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>