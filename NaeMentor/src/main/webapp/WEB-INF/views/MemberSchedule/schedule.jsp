<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 조율</title>
</head>
<script type="text/javascript">
	function delSchedule(seq){
		if(confirm('정말 삭제하실거에요?')){
		location.href="./deleteSchedule.do?boardseq="+seq;
		}else{
			alert("취소되었습니다.");
		}
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<!-- 등록 -->
	<div>
	<form action="./insertSchedule.do" method="post">
		<input type="hidden" name="boardseq" value="${boardseq}">
		날짜<input type="date" name="date"><br>
		시간<input type="time" name="time"><br>
		<hr>
		장소<input type="text" name="loc" required="required"><br>
		<input type="submit">
	</form>
	</div>
	<!-- 수정 -->
	
	<!-- 삭제 -->
	<button onclick="delSchedule(${boardseq})">스케줄 삭제</button>
	<div>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>