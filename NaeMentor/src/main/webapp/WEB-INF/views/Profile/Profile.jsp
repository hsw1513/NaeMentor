<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<button onclick="updateAuth()" name="btn">멘토신청</button>
	<c:if test="${profile.profiledto.filechk eq 'N'}">
	</c:if>
	<button onclick="applyBye()" name="btn">회원탈퇴</button>
	<table class="table">
	    <thead>
	      <tr>
	        <th>정보명</th>
	        <th>나의 정보</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	      <tr>
	        <td>회원번호</td>
	        <td>${profile.memberseq}</td>
	      </tr>
	      <tr>
	        <td>아이디</td>
	        <td>${profile.email}</td>
	      </tr>
	      <tr>
	        <td>닉네임</td>
	        <td>${profile.nickname}</td>
	        <td><button onclick="modifyNickname()" name="btn">수정</button> </td>
	      </tr>
	      <tr>
	        <td>자기소개</td>
	        <td>${profile.introduce}</td>
	        <td><button onclick="modifyIntro()" name="btn">수정</button> </td>
	      </tr>
	      <tr>
	        <td>생년월일</td>
	        <td>${profile.birthday}</td>
	      </tr>
	      <tr>
	        <td>성별</td>
	        <td>${profile.gender}</td>
	      </tr>
	      <tr>
	        <td>전화번호</td>
	        <td>${profile.phone}</td>
	        <td><button onclick="modifyPhone()" name="btn">수정</button> </td>
	      </tr>
	      <tr>
	        <td>권한</td>
	        <td>${profile.auth}</td>
	      </tr>
	      <tr>
	        <td>유저상태</td>
	        <td>${profile.userstatus}</td>
	      </tr>
	      <tr>
	        <td>멘토레벨</td>
	        <td>${profile.mentortier}</td>
	      </tr>
	      <tr>
	        <td>logincnt</td>
	        <td>${profile.logincnt}</td>
	      </tr>
	      <tr>
	        <td>reportcnt</td>
	        <td>${profile.reportcnt}</td>
	      </tr>
	      <tr>
	        <td>joindate</td>
	        <td>${profile.joindate}</td>
	      </tr>
	      <tr>
	        <td>menteecnt</td>
	        <td>${profile.menteecnt}</td>
	      </tr>
	      <tr>
	        <td>menteeaccstar</td>
	        <td>${profile.menteeaccstar}</td>
	      </tr>
	      <tr>
	        <td>byebye</td>
	        <td>${profile.byebye}</td>
	      </tr>
	      <tr>
	        <td>photo</td>
	        <td>${profile.profiledto.photo}</td>
	      </tr>
	      <tr>
	        <td>school</td>
	        <td>${profile.profiledto.school}</td>
	      </tr>
	      <tr>
	        <td>major</td>
	        <td>${profile.profiledto.major}</td>
	      </tr>
	      <tr>
	        <td>career</td>
	        <td>${profile.profiledto.career}</td>
	      </tr>
	      <tr>
	        <td>certificate</td>
	        <td>${profile.profiledto.certificate}</td>
	      </tr>
	      <tr>
	        <td>specialfield</td>
	        <td>${profile.profiledto.specialfield}</td>
	      </tr>
	      <tr>
	        <td>pmdate</td>
	        <td>${profile.profiledto.pmdate}</td>
	      </tr>
	      <tr>
	        <td>mentorcnt</td>
	        <td>${profile.profiledto.mentorcnt}</td>
	      </tr>
	      <tr>
	        <td>mentoaccstar</td>
	        <td>${profile.profiledto.mentoaccstar}</td>
	      </tr>
	      <tr>
	        <td>filechk</td>
	        <td>${profile.profiledto.filechk}</td>
	        <c:if test="${profile.profiledto.filechk eq 'Y'}">
	        <td>올린 파일이름</td>
	        <td><a onclick="downFile()">
	        		${userfile.userfile} : ${userfile.filesize}</a></td>
	        </c:if>
	      </tr>
	    </tbody>
  	</table>
  	
  	<div id="newNick">
	<form action="./changeNick.do" id="changeNick" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<input type="text" name="nickname" id="newNickname" placeholder="새로운 닉네임"><br>
		<span id="result_nickname"></span>
	</form>
		<button class="myButton" onclick="closeWin1()">변경 완료</button>
		<button class="myButton" onclick="goback1()">돌아가기</button>
	</div>
	
	<div id="newIntro">
	<form action="./changeIntro.do" id="changeIntro" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<textarea rows="5" cols="30" id="introduce" name="introduce" placeholder="새로운 자기소개"></textarea>
	</form>
		<button class="myButton" onclick="closeWin2()">변경 완료</button>
		<button class="myButton" onclick="goback2()">돌아가기</button>
	</div>
	
	<div id="newPhoneNum">
	<form action="./changePhone.do" id="changePhone" method="post">
		<input type="hidden" name="memberseq" value="${profile.memberseq}">
		<input type="text" id="phone" name="phone" placeholder="새로운 휴대전화 번호(-포함)">
		<input type="button" class="" onclick="sendSms()" id="send" value="전송"/> <br>
		<input type="text" name="sms" id="sms" placeholder="인증 번호 입력" />
		<input type="button" id="smsCheck" class="" onclick="numberCheck()" value="인증"/><br> 
	</form>
		<button class="myButton" onclick="closeWin3()">변경 완료</button>
		<button class="myButton" onclick="goback3()">돌아가기</button>
	</div>

</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>