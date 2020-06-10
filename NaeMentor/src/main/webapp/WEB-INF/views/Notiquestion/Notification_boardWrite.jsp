<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
	<form action="./NotiWrite.do" method="post">
		<table class="table talbe-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="editor" rows="20" cols="40" name="content"></textarea></td>
			</tr>
		</table>
		<div>
			<input type="button" value="글 작성" onclick="save()"/>
		</div>
	</form>
	<script type="text/javascript">
	window.onload = function(){
	CKEDITOR.replace("editor",
			{filebrowserUploadUrl: "./upload.do",
			 width: "800px"
			});
	}
	function save(){
		document.forms[0].submit();
	}
	</script>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>