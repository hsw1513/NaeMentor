<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
	<button onclick="updateAuth()">멘토신청</button>
	<c:if test="${profile.profiledto.filechk eq 'N'}">
	</c:if>
	<button onclick="applyBye()">회원탈퇴</button>
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

</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>