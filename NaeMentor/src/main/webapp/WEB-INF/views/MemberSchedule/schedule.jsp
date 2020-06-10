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
	
	function chkVal(){
		var dateVal = document.getElementsByName("date")[0].value;
		var timeVal = document.getElementsByName("time")[0].value;
		var locVal = document.getElementsByName("loc")[0].value;
// 		alert(dateVal + timeVal);
		if(dateVal != '' && timeVal !=''){
			if(confirm('선택하신 날짜와 시간, 장소는 \n'+dateVal+':'+timeVal+':'+locVal)){
				return true;
			}else{
				return false;
			}
		}else{
			alert('날짜와 시간을 입력하세요.');
			return false;
		}
	}
	function chkVal2(){
		var dateVal = document.getElementsByName("date")[0].value;
		var timeVal = document.getElementsByName("time")[0].value;
		var locVal = document.getElementsByName("loc")[0].value;
		if(dateVal != '' && timeVal !='' && locVal != ''){
			if(confirm('선택하신 날짜와 시간, 장소는 \n'+dateVal+':'+timeVal+':'+locVal)){
				return true;
			}else{
				return false;
			}
		}else{
			alert('날짜와 시간, 장소를 입력하세요.');
			return false;
		}
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<!-- 등록 -->
	<c:if test="${schedule eq null}">
	<div>
	<form action="./insertSchedule.do" method="post" onsubmit="return chkVal()">
		<input type="hidden" name="boardseq" value="${boardseq}">
		날짜<input type="date" name="date"><br>
		시간<input type="time" name="time"><br>
		<hr>
		장소<input type="text" name="loc" required="required"><br>
		<input type="submit" value="등록">
	</form>
	</div>
	</c:if>
	<!-- 수정 -->
	<c:if test="${schedule ne null}">
	<div>
		<p>멘토링일자:${schedule.mentoringtime}</p>
		<p>멘토링장소:${schedule.mentoringplace}</p>
	</div>
	<hr>
	<div>
	<form action="./modifySchedule.do" method="post" onsubmit="return chkVal2()">
		<input type="hidden" name="boardseq" value="${boardseq}">
		날짜<input type="date" name="date"><br>
		시간<input type="time" name="time"><br>
		<hr>
		장소<input type="text" name="loc"><br>
		<input type="submit" value="수정">
	</form>
	</div>
	<!-- 삭제 -->
	<button onclick="delSchedule(${boardseq})">스케줄 삭제</button>
	</c:if>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>