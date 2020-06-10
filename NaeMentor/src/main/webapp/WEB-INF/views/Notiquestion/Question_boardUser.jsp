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
		<div>
		<input type="button" value="문의 글쓰기" onclick ="questBoardWrite()">
		</div>
		<div>
			<table class="table table-hover">
				<c:forEach var="dto" items="${lists}">
						<tr>
						<th>제목</th>
						<td>
							${dto.title}
						</td>
						</tr>
						<tr>
						<th>작성일</th><td>${dto.writedate}</td>
						</tr>
						<tr>
						<th>내용</th><td>${dto.content}</td>
						</tr>
						<tr>
						<td>
							<input type="button" name="btn" onclick="quesdel(${dto.adminseq})" value="삭제" >
							<input type="button" name="btn" onclick="quesmod(${dto.adminseq})" value="수정">
						</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		
		
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
<script type="text/javascript">
			function questBoardWrite(){
				location.href="./Question_boardWrite.do";
			}
			function quesdel(seq){
				location.href="./Question_boardDelete.do?adminseq="+seq;
			}
			
			function quesmod(){
				location.href="./Question_boardModify.do?adminseq="+seq;
			}
		</script>
</html>