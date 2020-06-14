<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	function apply(){
		if(confirm(${detail.memberseq}+'님에게 멘토링을 신청합니다.')){
			applyMentor();
		}
	}
	
	function applyMentor(){
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback
		xhr.open("POST","./applyMentor.do");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
	}
	function matching(title, name){
// 		alert(title);
		// 회원정보 보여주기
		// 컨펌
		if(confirm(name+"님과 멘토링을 진행하시겠습니까?")){
			let info = "boardseq="+${detail.boardseq}+"&mentorseq="+title.trim();
// 			alert(info);
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback
			xhr.open("POST","./matching.do");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send(info);
			
		}else{
			alert("취소되었습니다.");
		}
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
	
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${detail.matchingchk eq 'N'}">
	<button onclick="del()">삭제하기</button>
	<input type="submit" value="수정하기">
	</c:if>
	</c:if>
	</form>
	
	<button onclick="javascript:history.back(-1)">뒤로가기</button>
	
	<c:if test="${userinfo.memberseq ne detail.memberseq}">
	<button onclick="report()">신고하기</button>
	</c:if>
	
	<c:if test="${detail.matchingchk eq 'N'}">
	<c:if test="${userinfo.memberseq eq 'ROLE_R'}">
	<button onclick="apply()">멘토링 신청</button>
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	</c:if>
	</c:if>
	<div>
		<table>
			<tr><td>신청 멘토 목록</td></tr>
			<c:forEach var="memtors" items="${findMentor}">
			<tr><td>
			<button onclick="matching(this.title, this.name)" name="${memtors.nickname}" title="${memtors.memberseq}">${memtors.nickname}</button>
			</td></tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	<c:if test="${detail.matchingchk eq 'Y'}">
	<div>
		<h1><a href="./review.do?boardseq=${detail.boardseq}">후기게시판 이동</a></h1>
		<h1><a href="./schedule.do?boardseq=${detail.boardseq}">스케줄게시판 이동</a></h1>
	</div>
	</c:if>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>