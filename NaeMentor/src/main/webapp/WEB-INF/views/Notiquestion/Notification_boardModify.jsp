<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
	<form action="./NotiModify.do" method="post">
		<input type="hidden" name="command" value="modify">
		<input type="hidden" name="adminseq" value="${dto.adminseq}">
		<table class="table talbe-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${dto.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="editor" rows="20" cols="40" name="content">${dto.content}</textarea></td>
			</tr>
		</table>
		<div style="text-align: center; margin-top: 20px;">
			<input type="submit" value="수정 완료"/>
		</div>
	</form>
	<script type="text/javascript">
	window.onload = function(){
	CKEDITOR.replace("editor",
			{filebrowserUploadUrl: "./upload.do",
			 width: "800px"
			});
	}
	</script>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>