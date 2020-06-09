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
			</table>
		</div>
		<div style="text-align: center; margin-top: 20px;">
<!-- 			관리자만 보이게-->
			<input type="button" name="btn" id="Notification_boardDelete" value="삭제">
			<input type="button" name="btn" id="Notification_boardModify" value="수정">
		</div>
		<script type="text/javascript">
			onload = function(){
				var btns = document.getElementsByName("btn");
				for (var i = 0; i < btns.length; i++) {
					btns[i].onclick = function(){
						location.href="./"+this.id+".do?adminseq="+${dto.adminseq};
					}
				}
			}
		
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>