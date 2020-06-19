<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th{
	vertical-align: middle;
	text-align-last: center;
}

input, select {
	height: 30px;
	width: 300px;
	margin: 5px;
	border: 1.5px solid lightgrey;
	border-radius: 5px;
	vertical-align: middle;
	text-align-last: center;
	}
</style>
</head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<script type="text/javascript">
function chkFMwrite(){
	let valflag = true;
	let titleVal = document.getElementsByName("title")[0].value;
	if(titleVal.length>2 && titleVal.length<20){
	}else{
		alert('제목은 3글자 이상 20글자 미만의 값을 입력해주세요.');
		valflag = false;
	}
	let locationVal =document.getElementsByName("location")[0].value;
	if(titleVal.length>1 && titleVal.length<20){
	}else{
		alert('장소는 3글자 이상 20글자 미만의 값을 입력해주세요.');
		valflag = false;
	}
	let mentoringdateVal1 =document.getElementsByName("date")[0].value;
	if(mentoringdateVal1 == ''){
		alert('날짜 값을 입력하세요.');
		valflag = false;
		}
	let mentoringdateVal2 =document.getElementsByName("time")[0].value;
	if(mentoringdateVal2 == ''){
		alert('시간 값을 입력하세요.');
		valflag = false;
		}

	return valflag;
}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<form action="./insertContent.do" method="post" enctype="multipart/form-data" onsubmit="return chkFMwrite()">
		<table class="table">
			<tr>
			<th>관심 분야</th>
			<td>
				<select name="target">
				<option value="실무">실무</option>
				<option value="취업">취업</option>
				<option value="자격증">자격증</option>
				<option value="취미">취미</option>
				<option value="교육">교육</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td>
				<input type="text" name="title">
			</td>
		</tr>
		<tr>
			<th>전문 분야</th>
			<td>
				<select name="specialfield">
					<option value="엑셀">엑셀</option>
					<option value="파워포인트">파워포인트</option>
					<option value="워드,한글(문서)">워드,한글(문서)</option>
					<option value="웹개발">웹개발</option>
					<option value="앱개발">앱개발</option>
					<option value="워드프레스">워드프레스</option>
					<option value="C++">C++</option>
					<option value="C언어">C언어</option>
					<option value="Java">Java</option>
					<option value="C#">C#</option>
					<option value="ASP">ASP</option>
					<option value="Delphi">Delphi</option>
					<option value="ASP.NET">ASP.NET</option>
					<option value="Javascript">Javascript</option>
					<option value="HTML.CSS">HTML.CSS</option>
					<option value="XML">XML</option>
					<option value="Python">Python</option>
					<option value="기타프로그래밍">기타프로그래밍</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>내수준</th>
			<td>
				<select name="menteelevel">
					<option value="H">상</option>
					<option value="M">중</option>
					<option value="L">하</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>방식</th>
			<td>
				<select name="howto">
					<option value="Y">대면</option>
					<option value="N">비대면</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>장소</th>
			<td>
				<input type="text" name="location">
			</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>
				<input type="date" name="date">
			</td>
		</tr>
		<tr>
			<th>시간</th>
			<td>
				<input type="time" name="time">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea id="editor" rows="20" cols="40" name="content"></textarea>
			</td>
		</tr>

	</table>	
	<div style="text-align: center;">
		<input type="submit" class="myButton" value="작성완료">
	</div>
	</form>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script type="text/javascript">
window.onload = function(){	
	// ck에디터 설정
	CKEDITOR.replace("editor",
			{filebrowserUploadUrl: "./upload.do",
			 width: "800px"
			});
	}

</script>
</body>
</html>