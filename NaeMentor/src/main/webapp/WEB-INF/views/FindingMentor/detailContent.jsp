<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/findingMentor/findingMentor.css">
</head>
<script type="text/javascript">
var xhr = null;
	window.onload = function(){
		reviewOnload();
		chkOffer();
	}		
	
	reviewOnload = function(){
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					let val = JSON.parse(xhr.responseText);
					document.getElementsByClassName("reviews")[0].innerHTML = val.reviews;
				}
			}
		}
		xhr.open("get","./review.do?menteeseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send();
	}
	
	chkOffer = function(){
		let xhr2 = new XMLHttpRequest();
		xhr2.onreadystatechange = function(){
			if(xhr2.readyState==4){
				if(xhr2.status==200){
					let val2 = xhr2.responseText;
					if(val2 == "true"){
						document.getElementById("offerchk").style.display = '';
					}else{
						document.getElementById("offerchk").style.display = 'none';
						document.getElementById("offerchk2").innerHTML = '<b>멘토링을 신청하셨습니다.</b>';
					}
				}
			}
		}
		xhr2.open("get","./chkOffer.do?boardseq="+${detail.boardseq});
		xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr2.send();
	}
	
	
	function del(){
		location.href="./deleteContent.do?memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq};
	}
	function modify(){
		var from1 = document.getElementsByTagName("form")[0];
		from1.method = "POST";
		from1.action = "./modifyContent.do";
		return true;
	}
	
	
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
	function modifyDate(e){
		e.stopPropagation();
		let obj = document.createElement("INPUT");
		obj.type="date";
		obj.name="mentoringdate"
		document.getElementById("objDiv").innerHTML = '일시';
		document.getElementById("objDiv").appendChild(obj);
	}
	
	function openApply(val){
		let objSt = document.getElementById(val.name);
		if(objSt.style.display == 'none'){
			val.value='멘토의 소개글 접기';
			objSt.style.display = '';
		}else{
			val.value='멘토의 소개글 보기';
			objSt.style.display = 'none';
		}
	}
	
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<div class="detailDiv">
	<div class="leftdiv">
	<form action="" onsubmit="return modify()">
	제목<input type="text" name="title" value="${detail.title}"><br>
	글번호<input type="text" name="boardseq" value="${detail.boardseq}"><br>
	작성자번호<input type="text" name="memberseq" value="${detail.memberseq}"><br>
	작성일<input type="text" value="${detail.writesdate}"><br>
	전문분야<input type="text" name="specialfield" value="${detail.specialfield}"><br>
	장소<input type="text" name="location" value="${detail.location}"><br>
	<div id="objDiv"></div>
	일시<input type="text" value="${detail.mentoringdate}"><br>

	내용<textarea rows="3" cols="20" name="content">${detail.content}</textarea><br>
	
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${detail.matchingchk eq 'N'}">
	<button onclick="del()">삭제하기</button>
	<input type="submit" value="수정하기">
	</c:if>
	</c:if>
	</form>
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${fn:length(findMentor) == 0}">
	<button onclick="modifyDate(event)">날짜수정</button>
	</c:if>
	</c:if>
	
	<button onclick="javascript:history.back(-1)">뒤로가기</button>
	
	<c:if test="${userinfo.memberseq ne detail.memberseq}">
	<button onclick="report()">신고하기</button>
	</c:if>
	</div>
	
	
	<!-- 오른쪽 영역 시작--------------------------------------------------------------------------- -->
	<div class="rightDiv">
	<c:if test="${userinfo.auth eq 'ROLE_E'}">
	<div class="reviews">
	<%@include file="/WEB-INF/views/FindingMentor/ajaxReview.jsp"%>
	</div>
	</c:if>
	<!-- 매칭이 되지 않은 글/멘토의 관점---------------------------------------------------------------- -->
	<c:if test="${detail.matchingchk eq 'N'}">
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<table class="table table-bordered">
		<thead>
			<c:forEach items="${findMentor}" var="mentee">
			<tr>
				<th>닉네임</th><td>${mentee.nickname}</td>
			</tr>
			<tr>
				<th>멘토링 횟수</th><td>${mentee.menteecnt}</td>
			</tr>
			<tr>
				<th>취소 횟수</th><td>${mentee.nickname}</td>
			</tr>
			<tr>	
				<th>누적 별점</th><td>${mentee.menteeaccstar}</td>
			</tr>
			</c:forEach>
		</thead>
			<tr><td colspan="2">멘티의 후기 보기</td></tr>
		<tbody>
		</tbody>
	</table>
		<span class="reviews"></span>
	<div id="offerchk">
		<form action="./insertOffer.do" method="post" onsubmit="return chkVal()">
			<input type="hidden" name="memberseq" value="${userinfo.memberseq}">
			<input type="hidden" name="boardseq" value="${detail.boardseq}">
			<textarea name="content" rows="2" cols="50" placeholder="멘티님께 하고싶은 말을 적어주세요." required="required"></textarea><br>
			<input type="number" name="price" placeholder="금액을 입력해주세요" required="required">원
			<input type="submit" value="요청서 제출">
		</form>
	<button onclick="apply()">멘토링 신청</button>
	</div>
	<div id="offerchk2"></div>
	</c:if>
	
	
	
	<!-- 오른쪽 영역 멘티의 관점 ---------------------------------------------------------->
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${userinfo.auth eq 'ROLE_E'}">
	
	<b>멘토지원자 명단</b>
	<table class="table table-bordered">
	<thead><tr>
	<th>멘토번호</th>
	<th>닉네임</th>
	<th>누적별점</th>
	<th>멘토링횟수</th>
	<th>금액</th>
	<th>버튼영역</th>
	</tr></thead>
	
	
	<tbody>
	<c:forEach items="${findMentor}" var="applyMentors">
		<tr>
			<td>${applyMentors.memberseq}</td>
			<td>${applyMentors.nickname}</td>
			<td>${applyMentors.profiledto.mentoaccstar}</td>
			<td>${applyMentors.profiledto.mentorcnt}</td>
			<td>0원(개발중)</td>
			<td><input type="button" value="멘토의 소개글 보기" onclick="openApply(this)" name="a${applyMentors.memberseq}st"></td>
		</tr>
		<tr id="a${applyMentors.memberseq}st" style="display:none;">
			<td colspan="1">자기소개</td>
			<td colspan="4"></td>
			<td><button onclick="matching(this.title,this.name)" name="${applyMentors.nickname}" title="${applyMentors.memberseq}">멘토선택</button></td>
		</tr>	
	</c:forEach>
	</tbody>
	</table>
	</c:if>
	</c:if>
	</c:if>
	
	
	
	
	<c:if test="${detail.matchingchk eq 'Y'}">
	<c:if test="${userinfo.memberseq eq matching.menteeseq || userinfo.memberseq eq matching.mentorseq}">
	<div>
		<h1><a href="./reviewBoard.do?boardseq=${detail.boardseq}">후기게시판 이동</a></h1>
		<c:if test="${userinfo.auth eq 'ROLE_R'}">
		<h1><a href="./schedule.do?boardseq=${detail.boardseq}">스케줄게시판 이동</a></h1>
		</c:if>
	</div>
	</c:if>
	</c:if>
	</div>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>