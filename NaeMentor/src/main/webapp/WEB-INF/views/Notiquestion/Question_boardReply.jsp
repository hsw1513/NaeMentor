<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 답변 작성</title>
</head>
<script type="text/javascript">
	window.onload = function(){
	CKEDITOR.replace("editor",
			{filebrowserUploadUrl: "./upload.do",
			 width: "800px"
			});
	}
	</script>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
	<form action="./QuesReply.do" method="post">
		<input type="hidden" name="command" value="reply">
		<input type="hidden" name="adminseq" value="${dto.adminseq}">
		<table class="table talbe-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="RE:${dto.title}" readonly="readonly"></td>
			</tr>
			<tr>
			<th>작성일</th><td>${dto.writedate}</td>
		</tr>
			<tr>
				<th>내용</th>
				<td>
				<input type="hidden" id="hidecontent" value="${dto.content}">
				<textarea style="color: gray;" id="editor" rows="20" cols="40" name="content" required="required">
				</textarea></td>
			</tr>
		</table>
			<div style="text-align: center; margin-top: 20px;">
			<input type="button" class="myButton" value="취소" onclick="javascript:history.back(-1);">
			<input type="submit" class="myButton" value="답변 작성">
		</div>
	</form>
	
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>