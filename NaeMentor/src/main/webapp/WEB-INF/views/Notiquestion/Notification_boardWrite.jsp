<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
	<form action="./NotiWrite.do" method="post">
		<table class="table talbe-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content"></td>
			</tr>
		</table>
		<div>
			<input type="reset" value="초기화"/>
			<input type="button" value="글 작성" onclick="save()"/>
		</div>
	</form>
	<script type="text/javascript">
	function save(){
		document.forms[0].submit();
	}
	</script>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>