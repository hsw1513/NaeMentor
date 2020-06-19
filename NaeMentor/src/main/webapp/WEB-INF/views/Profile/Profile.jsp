<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<link type="text/css" rel="stylesheet" href="./css/profile/profile.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script type="text/javascript" src="./js/profile.js"></script>
<script type="text/javascript">
	function applyBye(){
// 		alert('applyBye');
		if(confirm('회원탈퇴 정말로 할고야?')){
			location.href="./applyBye.do?memberseq="+${userinfo.memberseq};
		}
	}
	function updateAuth(){
// 		alert('updateAuth');
	location.href="./goingApplyMentor.do";
	}
	
	function downFile(){
		let sendFile = "filepath=${userfile.filepath}&userfile=${userfile.userfile}&searchfile=${userfile.searchfile}";
// 		alert(sendFile);
	let xhr = new XMLHttpRequest();
	xhr.open("post","./download.do");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
// 			alert(xhr.status);
			if(xhr.status == 200){
				alert(xhr.responseText);
			}
		}else{
// 			alert(xhr.responseText);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send(sendFile);
	}
	
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<div class="divProfile">
		<c:if test="${profile.profiledto.filechk eq 'N'}">
			<button class="myButton" onclick="updateAuth()" name="btn">멘토신청</button>
		</c:if>
			<button class="myButton" onclick="applyBye()" name="btn">회원탈퇴</button>
	</div>
	<table class="table">
	       <tr>
	        <th>사진</th>
	        <td>${profile.profiledto.photo}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>이메일</th>
	        <td>${profile.email}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>닉네임</th>
	        <td>${profile.nickname}</td>
	        <td><button onclick="modifyNickname()" class="myButton3" name="btn">수정</button> </td>
	      </tr>
	      <tr>
	        <th>휴대전화 번호</th>
	        <td>${profile.phone}</td>
	        <td><button onclick="modifyPhone()" class="myButton3" name="btn">수정</button> </td>
	      </tr>
	        <tr>
	        <th>자기소개</th>
	        <td>${profile.introduce}</td>
	        <td><button onclick="modifyIntro()" class="myButton3" name="btn">수정</button> </td>
	      </tr>
	      <tr>
	        <th>생년월일</th>
	        <td>${profile.birthday}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>성별</th>
	    	<c:if test="${profile.gender eq 'M'}">   
	        <td>남자</td>
	        </c:if>
	    	<c:if test="${profile.gender eq 'F'}">   
	        <td>여자</td>
	        </c:if>
	        <td></td>
	      </tr>
<!-- 	      권한별 이름 표시 -->
	      <tr>
	        <th>권한</th>
	        <c:if test="${profile.auth eq 'ROLE_E'}">   
	        <td>멘티</td>
	        </c:if>
	        <c:if test="${profile.auth eq 'ROLE_R'}">   
	        <td>멘토</td>
	        </c:if>
	        <td></td>
	      </tr>
	      <tr>
	        <th>가입일</th>
	        <td>${profile.joindate}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>학교</th>
	        <td>${profile.profiledto.school}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>전공</th>
	        <td>${profile.profiledto.major}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>경력</th>
	        <td>${profile.profiledto.career}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>자격증</th>
	        <td>${profile.profiledto.certificate}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>전문 분야</th>
	        <td>${profile.profiledto.specialfield}</td>
	        <td></td>
	      </tr>
	
	      <tr>
	        <th>오늘까지 참가한 멘토링 횟수 (멘티)</th>
	        <td>${profile.menteecnt}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>오늘까지 받은 별 개수 (멘티)</th>
	        <td>${profile.menteeaccstar}</td>
	        <td></td>
	      </tr>
		<c:if test="${userinfo.auth eq 'ROLE_R'}">
	      <tr>
	        <th>멘토 승급일</th>
	        <td>${profile.profiledto.pmdate}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>오늘까지 참가한 멘토링 횟수 (멘토)</th>
	        <td>${profile.profiledto.mentorcnt}</td>
	        <td></td>
	      </tr>
	      <tr>
	        <th>오늘까지 받은 별 개수 (멘토)</th>
	        <td>${profile.profiledto.mentoaccstar}</td>
	        <td></td>
	      </tr>
	        <tr>
	        <th>멘토 레벨</th>
	         <c:if test="${profile.mentortier eq 'B'}">   
	        	<td>BRONZE</td>
	        </c:if>
	         <c:if test="${profile.mentortier eq 'S'}">   
	        	<td>SILVER</td>
	        </c:if>
	         <c:if test="${profile.mentortier eq 'G'}">   
	        	<td>GOLD</td>
	        </c:if>
	         <c:if test="${profile.mentortier eq 'P'}">   
	        	<td>PLATINUM</td>
	        </c:if>
	        <td>${profile.mentortier}</td>
	      </tr>
	      </c:if>
	      <td></td>
  	</table>
  	
  	<div id="newNick">
	<form action="./changeNick.do" id="changeNick" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<input type="text" name="nickname" id="newNickname" placeholder="새로운 닉네임"><br>
		<span id="result_nickname"></span>
	</form>
		<div class="profileButton">
		<button class="myButton3" onclick="closeWin1()">변경 완료</button>
		<button class="myButton3" onclick="goback1()">돌아가기</button>
		</div>
	</div>
	
	<div id="newIntro">
	<form action="./changeIntro.do" id="changeIntro" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<textarea rows="5" cols="30" id="introduce" name="introduce" placeholder="새로운 자기소개" style="width: 100%; vertical-align: middle; text-align: center;"></textarea>
	</form>
		<div class="profileButton">
		<button class="myButton3" onclick="closeWin2()">변경 완료</button>
		<button class="myButton3" onclick="goback2()">돌아가기</button>
		</div>
	</div>
	
	<div id="newPhoneNum">
	<form action="./changePhone.do" id="changePhone" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<input type="text" id="phone" name="phone" placeholder="새로운 휴대전화 번호(-포함)">
		<input type="button" class="" onclick="sendSms()" id="send" value="전송"/> <br>
		<input type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
		<input type="button" id="smsCheck" onclick="numberCheck()" value="인증"/><br> 
	</form>
		<div class="profileButton">
		<button class="myButton3" onclick="closeWin3()">변경 완료</button>
		<button class="myButton3" onclick="goback3()">돌아가기</button>
		</div>
	</div>

</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>