<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function del(){
		location.href="./deleteContent.do?memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq};
	}
	function modify(){
		var from1 = document.getElementsByTagName("form")[0];
		from1.method = "POST";
		from1.action = "./modifyContent.do";
		return true;
	}
	var xhr = null;
	
	function report(){
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback
		xhr.open("POST","./reportContentChk.do");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
	}
	function callback(){
		if(xhr.readyState==4){
// 			alert(xhr.status);
			if(xhr.status==200){
				alert(xhr.responseText);
			}
		}
	}
	
	function applyMentor(){
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback
		xhr.open("POST","./applyMentor.do");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<form action="" onsubmit="return modify()">
	제목<input type="text" name="title" value="${detail.title}"><br>
	글번호<input type="text" name="boardseq" value="${detail.boardseq}"><br>
	작성자번호<input type="text" name="memberseq" value="${detail.memberseq}"><br>
	작성일<input type="text" value="${detail.writesdate}"><br>
	전문분야<input type="text" name="specialfield" value="${detail.specialfield}"><br>
	장소<input type="text" name="location" value="${detail.location}"><br>
	내용<textarea rows="3" cols="20" name="content">${detail.content}</textarea><br>
	<button onclick="del()">삭제하기</button>
	<input type="submit" value="제출하기">
	</form>
	<button onclick="javascript:history.back(-1)">뒤로가기</button>
	<button onclick="report()">신고하기</button>
	<button onclick="applyMentor()">멘토링 신청</button>
	<button onclick="matching()">멘토 수락</button>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>