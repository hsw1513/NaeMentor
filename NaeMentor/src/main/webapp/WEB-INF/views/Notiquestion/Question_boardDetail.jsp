<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판 상세글 보기</title>
</head>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		 <h2>1:1 문의 상세보기</h2>
  		<p>문의글을 읽고 답변을 달아주세요.</p>
		<div>
			<table class="table table-bordered">
				<tr><th>작성자</th><td>${userinfo.nickname}</td></tr>
				<tr><th>등록일</th><td>${dto.writedate}</td></tr>
				<tr><th>제목</th><td>${dto.title}</td></tr>
				<tr><th>내용</th><td>${dto.content}</td></tr>
			</table>
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<c:if test="${dto.delflag=='N'}">
			<input type="button" class="myButton" name="btn" onclick="quesdel()" value="삭제" >
			</c:if>
			<input type="button" class="myButton" name="btn" onclick="queslist()" value="목록보기" >
			<c:if test="${dto.delflag=='N'}">
			<input type="button" class="myButton" name="btn" onclick="quesreply()" value="답변" >
			</c:if>
		</div>
		<script type="text/javascript">
			function quesdel(){
				if (confirm("정말로 삭제하시겠습니까?")){
				location.href="./Question_boardDelete.do?adminseq="+${dto.adminseq};
				}
			}
			function queslist(){
				location.href="./Question_board.do";
			}
			function quesreply(){
				location.href="./Question_boardReply.do?adminseq="+${dto.adminseq};
			}
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>