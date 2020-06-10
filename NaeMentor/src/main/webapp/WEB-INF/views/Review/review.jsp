	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var xhr = null;	
	window.onload = function(){
		
		function chkBtn(){
			var btn1 = document.getElementById("reviewChk");
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
//	 					alert(xhr.responseText);
						if(xhr.responseText == "false"){
							btn1.style.display = "none";
						}else{
							btn1.style.display = "";
						}
					}
				}
			}
			xhr.open("post","./chkReview.do");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("boardseq="+${boardseq});
		}
		chkBtn();
	}
	
	function chkVal(){
		var stara = document.getElementsByClassName("starVal")[0].value;
		var contenta = document.getElementsByName("content")[0].value;
// 		alert("c:"+stara+"cc:"+contenta);
		if(stara == ''){
			alert('별점을 입력해주세요.');
		}else if(contenta == ''){
			alert('후기를 작성하세요.');
		}else{
			
			document.getElementsByTagName("form")[0].submit();
		}
	}
	
	
	function insertReview(){
		var hidDiv = document.getElementById("hDiv");
		if(hidDiv.style.display == 'none'){
			hidDiv.style.display = '';
		}else{
			hidDiv.style.display = 'none';
		}
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
<c:if test="${userinfo.auth eq 'ROLE_E'}">
<%-- 		<h1>누적별점:${reviews.menteestar}</h1> --%>
<%-- 		<h1>멘토링횟수:${reviews.boardseq}</h1> --%>
		<table>
			<thead>
			<tr>
				<th>별점</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
			</thead>
	<c:forEach var="review" items="${reviews}">
			<tr>
				<td>${review.mentorstar}</td>
				<td>${review.content}</td>
				<td>${review.writedate}</td>
			</tr>
	</c:forEach>
		</table>
</c:if>
<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<%-- 		<h1>누적별점:${reviews.menteestar}</h1> --%>
<%-- 		<h1>멘토링횟수:${reviews.boardseq}</h1> --%>
		<table>
			<thead>
			<tr>
				<th>별점</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
			</thead>
	<c:forEach var="review" items="${reviews}">
			<tr>
				<td>${review.menteestar}</td>
				<td>${review.content}</td>
				<td>${review.writedate}</td>
			</tr>
	</c:forEach>
		</table>
</c:if>
	<hr>
	<div>
		<button id="reviewChk" onclick="insertReview()">후기남기기</button>
		<div id="hDiv" style="display:none;">
			<form action="./insertReview.do" method="post">
				<input type="hidden" value="${boardseq}" name="boardseq">
				<c:if test="${userinfo.auth eq 'ROLE_R'}">
				멘티의 별점(1-5사이의 값을 입력하세요.)<input type="number" min="1" max="5" name="menteestar" class="starVal">
				</c:if>
				<c:if test="${userinfo.auth eq 'ROLE_E'}">
				멘토의 별점(1-5사이의 값을 입력하세요.)<input type="number" min="1" max="5" name="mentorstar" class="starVal">
				</c:if>
				<br><textarea name="content" cols="50" rows="3" placeholder="내용"></textarea><br>
				
				<input type="button" onclick="chkVal()" value="입력완료">
			</form>
		</div>
	</div>
	
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>