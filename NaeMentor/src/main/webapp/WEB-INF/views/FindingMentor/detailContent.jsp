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
		let onloadxhr = new XMLHttpRequest();
		onloadxhr.onreadystatechange = function(){
			if(onloadxhr.readyState==4){
				if(onloadxhr.status==200){
					let val = JSON.parse(onloadxhr.responseText);
					document.getElementsByClassName("reviews")[0].innerHTML = val.reviews;
				}
			}
		}
		onloadxhr.open("get","./review.do?menteeseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
		onloadxhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		onloadxhr.send();
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
		let reportxhr = new XMLHttpRequest();
		reportxhr.onreadystatechange = function(){
			if(reportxhr.readyState==4){
				if(reportxhr.status==200){
					alert(reportxhr.responseText);
				}
			}
		}
		reportxhr.open("POST","./reportContentChk.do");
		reportxhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		reportxhr.send("memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
	}
	function callback(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				alert(xhr.responseText);
			}
		}
	}
	function apply(){
		let num = document.getElementsByName("price")[0];
		if(num.value.length>3 && num.value.length<7 && num.value>0){
		if(confirm(${detail.memberseq}+'님에게 멘토링을 신청합니다.')){
			applyMentor();
			return true;
			}
		}else{
			alert('금액은 천 원이상 백만 원 미만의 값만 입력 가능합니다.')
			return false;
		}
	}
	
	function applyMentor(){
		let applyxhr = new XMLHttpRequest();
		applyxhr.onreadystatechange = function(){
			if(applyxhr.readyState==4){
				if(applyxhr.status==200){
					alert(applyxhr.responseText);
				}
			}
		}
		applyxhr.open("POST","./applyMentor.do");
		applyxhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		applyxhr.send("memberseq="+${detail.memberseq}+"&boardseq="+${detail.boardseq});
	}
	function matching(title, name){
		// 회원정보 보여주기
		// 컨펌
		if(confirm(name+"님과 멘토링을 진행하시겠습니까?")){
			let info = "boardseq="+${detail.boardseq}+"&mentorseq="+title.trim();
			let matchingxhr = new XMLHttpRequest();
			matchingxhr.onreadystatechange = function(){
				if(matchingxhr.readyState==4){
					if(matchingxhr.status==200){
						location.href="detailContent.do?boardseq="+${detail.boardseq}+"&memberseq="+${detail.memberseq};
					}
				}
			}
			matchingxhr.open("POST","./matching.do");
			matchingxhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			matchingxhr.send(info);
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
		let objSt = document.getElementById("a"+val.name+"st");
		if(objSt.style.display == 'none'){
			val.value='멘토의 소개글 접기';
			objSt.style.display = '';
			viewOffer(val);
		}else{
			val.value='멘토의 소개글 보기';
			objSt.style.display = 'none';
		}
	}
	function viewOffer(val){
		let xhr3 = new XMLHttpRequest();
		xhr3.onreadystatechange = function(){
			if(xhr3.readyState==4){
				if(xhr3.status==200){
				let val3 = JSON.parse(xhr3.responseText);
				document.getElementsByName("intro_"+val.name)[0].innerHTML = val3.offer.price;
				document.getElementsByName("intro_"+val.name)[1].innerHTML = val3.offer.content;
				}
			}
		}
		xhr3.open("get","./viewOffer.do?mentorseq="+val.name+"&boardseq="+${detail.boardseq});
		xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr3.send();
	}
	
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<div class="detailDiv">
	<div class="leftdiv">
	<form action="" onsubmit="return modify()">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${detail.title}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>글번호</th>
			<td><input type="hidden" name="boardseq" value="${detail.boardseq}"></td>
		</tr>
		<tr>
			<th>작성자번호</th>
			<td><input type="hidden" name="memberseq" value="${detail.memberseq}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" value="${detail.naememberdto.nickname}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><input type="text" value="${detail.writesdate}"></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><input type="text" value="${detail.writesdate}"></td>
		</tr>
		<tr>
			<th>전문분야</th>
			<td><input type="text" name="specialfield" value="${detail.specialfield}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>장소</th>
			<td><input type="text" name="location" value="${detail.location}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>일시</th>
			<td><div id="objDiv"></div>
				<input type="text" value="${detail.mentoringdate}" readonly="readonly">
			</td>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content" value="${detail.content}"></td>
		</tr>
		</tr>
	</table>
	
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${detail.matchingchk eq 'N'}">
	<button class="myButton" style="margin-top: 10px; onclick="del()">삭제하기</button>
	</c:if>
	</c:if>
	<c:if test="${userinfo.memberseq eq detail.memberseq}">
	<c:if test="${fn:length(findMentor) == 0}">
	<button class="myButton"" onclick="modifyDate(event)">날짜수정</button>
	</c:if>
	</c:if>
	</form>
	<input type="submit" value="수정하기">
	
	<br>
	<button class="myButton" style="margin-top: 10px;" onclick="javascript:history.back(-1)">뒤로가기</button>
	
	<c:if test="${userinfo.memberseq ne detail.memberseq}">
	<button class="myButton" onclick="report()">신고하기</button>
	</c:if>
	</div>
	
	
	<!-- 오른쪽 영역 시작--------------------------------------------------------------------------- -->
	<div class="rightDiv">
	<c:if test="${userinfo.auth eq 'ROLE_R' && detail.delflag eq 'N'}">
	<div class="reviews">
	<%@include file="/WEB-INF/views/FindingMentor/ajaxReview.jsp"%>
	</div>
	</c:if>
	<!-- 매칭이 되지 않은 글/멘토의 관점---------------------------------------------------------------- -->
	<c:if test="${detail.matchingchk eq 'N'}">
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>닉네임</th><td>${detail.naememberdto.nickname}</td>
			</tr>
			<tr>
				<th>멘토링 횟수</th><td>${detail.naememberdto.menteecnt}회</td>
			</tr>
			<tr>	
				<th>누적 별점</th><td>${detail.naememberdto.menteeaccstar}점</td>
			</tr>
		</thead>
			<tr><td colspan="2">멘티의 후기 보기</td></tr>
		<tbody>
		</tbody>
	</table>
		<span class="reviews"></span>
	<div id="offerchk">
		<form action="./insertOffer.do" method="post" onsubmit="return apply()">
			<input type="hidden" name="memberseq" value="${userinfo.memberseq}">
			<input type="hidden" name="boardseq" value="${detail.boardseq}">
			<textarea name="content" rows="2" cols="50" placeholder="멘티님께 하고싶은 말을 적어주세요." required="required"></textarea><br>
			<input type="number" name="price" placeholder="금액을 입력해주세요" required="required">원
			<input type="submit" value="요청서 제출">
		</form>
	</div>
	<div id="offerchk2"></div>
	</c:if>
	
	
	
	<!-- 매칭이 되지 않은 글/멘티의 관점 ---------------------------------------------------------->
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
			<td name="intro_${applyMentors.memberseq}">멘토정보를 확인하세요.</td>
			<td><input type="button" class="myButton" value="멘토의 소개글 보기" onclick="openApply(this)" name="${applyMentors.memberseq}"></td>
		</tr>
		<tr id="a${applyMentors.memberseq}st" style="display:none;">
			<td colspan="1">자기소개</td>
			<td colspan="4" name="intro_${applyMentors.memberseq}"></td>
			<td><button class="myButton;" onclick="matching(this.title,this.name)" name="${applyMentors.nickname}" title="${applyMentors.memberseq}">멘토선택</button></td>
		</tr>	
	</c:forEach>
	</tbody>
	</table>
	</c:if>
	</c:if>
	</c:if>
	
	<!-- 매칭이 된 글 ---------------------------------------------------------------------------------------------------------------->
	<c:if test="${detail.delflag eq 'M'}">
	<h1>매칭된 글</h1>
	<!-- 멘티의 관점 -->
	<c:if test="${userinfo.auth eq 'ROLE_E' && userinfo.memberseq eq matching.menteeseq}">
	<b>매칭된 멘토</b>
	<table class="table table-bordered">
	<thead>
	<tr>
		<th>멘토 닉네임</th>
		<th>멘토링 횟수</th>
		<th>누적 별점</th>
		<th>금액</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>${mentorInfo.nickname}</td>
		<td>${mentorInfo.profiledto.mentorcnt}</td>
		<td>${mentorInfo.profiledto.mentoaccstar}</td>
		<td>${offer.price}</td>
	</tr>
	<tr>
		<td>신청사유</td>
		<td colspan="3">${offer.content}</td>
	</tr>
	<tr>
		<td colspan="4">멘토의 후기 보기</td>
	</tr>
	</tbody>
	</table>
	<div>${rlists}</div>
	
	
	</c:if>
	<!-- 멘토의 관점 -->
	<c:if test="${userinfo.auth eq 'ROLE_R' && userinfo.memberseq eq matching.mentorseq}">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th>멘토 닉네임</th>
		<th>멘토링 횟수</th>
		<th>누적 별점</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>${menteeInfo.nickname}</td>
		<td>${menteeInfo.menteecnt}</td>
		<td>${menteeInfo.menteeaccstar}</td>
	</tr>
	<tr>
		<td colspan="4">멘티의 후기 보기</td>
	</tr>
	</tbody>
	</table>
	<div>${rlists}</div>
	
	</c:if>
	
	</c:if>
	
	
	
	
	<!-- 멘토링이 종료된 글 // 후기게시판으로 이동(후기 남기기로 변경) ----------------------------------------------------->
	<c:if test="${detail.matchingchk eq 'Y'}">
	<c:if test="${userinfo.memberseq eq matching.menteeseq || userinfo.memberseq eq matching.mentorseq}">
	<c:if test="${detail.delflag eq 'C'}">
	<div>
		<h1><a href="./reviewBoard.do?boardseq=${detail.boardseq}">후기게시판 이동</a></h1>
	</div>
	</c:if>
	</c:if>
	</c:if>
	</div>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>