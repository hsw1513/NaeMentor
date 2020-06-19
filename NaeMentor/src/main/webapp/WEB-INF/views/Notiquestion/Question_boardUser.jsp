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
		 <h2>1:1 문의</h2>
  		<p>궁금하신 사항이 있으시면 글을 작성해 주세요. 관리자가 답변해 드립니다.</p>  
		<div style="text-align:center;">
		<input type="button" class="myButton" style="padding:6px 40%;" value="문의 글쓰기" onclick ="questBoardWrite()">
		</div>
		<div style="margin-top: 30px;">
			<table class="table table-hover">
				<c:forEach var="dto" items="${lists}">
				<c:if test="${dto.delflag=='N'}">
						<tr>
						</tr>
						<c:choose>
						<c:when test="${dto.namemberdto.memberseq==userinfo.memberseq}">
							<tr>
								<th>제목</th>	<td>${dto.title}</td><th>작성일</th><td>${dto.writedate}</td>
							</tr>
							<tr>
								<th>내용</th>	<td>${dto.content}</td>
								<th colspan="2" style="text-align: center;">
								<c:if test="${dto.namemberdto.memberseq==userinfo.memberseq}">
							<input type="button" class="myButton" name="btn" onclick="quesdel(${dto.adminseq})" value="삭제" >
							<input type="button" class="myButton" name="btn" onclick="quesmod(${dto.adminseq})" value="수정">
						</c:if>
								</th>
							</tr>
						</c:when>
						<c:otherwise>
								<th>┗ 답변</th>	<td>${dto.content}</td><th>작성일</th><td>${dto.writedate}</td>
						</c:otherwise>
						</c:choose>
						</c:if>
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
				if (confirm("정말로 삭제하시겠습니까?")){
				location.href="./Question_boardDeleteU.do?adminseq="+seq;
				}
			}
			
			function quesmod(seq){
				location.href="./Question_boardModify.do?adminseq="+seq;
			}
		</script>
</html>