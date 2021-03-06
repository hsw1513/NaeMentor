<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세글 보기</title>
</head>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		<h1>상세보기</h1>
		<div>
			<table class="table table-bordered">
				<tr><th>작성자</th><td>관리자</td></tr>
				<tr><th>등록일</th><td>${dto.writedate}</td></tr>
				<tr><th>제목</th><td>${dto.title}</td></tr>
				<tr><th>내용</th><td>${dto.content}</td></tr>
				<tr><th>첨부파일</th><td><a href="${dto.attachfiledto.filepath}${dto.attachfiledto.searchfile}">${dto.attachfiledto.userfile}</a></td></tr>
			</table>
		</div>
			<div style="text-align: center; margin-top: 20px;">
			<c:if test="${userinfo.auth eq 'ROLE_A'}">	
			<input type="button" class="myButton" name="btn" onclick="notidel()" value="삭제" >
			</c:if>
			<input type="button" class="myButton" name="btn" onclick="notilist()" value="목록보기" >
			<c:if test="${userinfo.auth eq 'ROLE_A'}">
			<input type="button" class="myButton" name="btn" onclick="notimod()" value="수정">
			</c:if>
		</div>
		<script type="text/javascript">
			function notidel(){
				if (confirm("정말로 삭제하시겠습니까?")){
				location.href="./Notification_boardDelete.do?adminseq="+${dto.adminseq};
				}
			}
			function notilist(){
				location.href="./Notification_board.do";
			}
			function notimod(){
				location.href="./Notification_boardModify.do?adminseq="+${dto.adminseq};
			}
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>