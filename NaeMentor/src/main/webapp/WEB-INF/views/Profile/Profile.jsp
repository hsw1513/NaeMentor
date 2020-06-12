<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">

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
	        <td>${userinfo.memberseq}</td>
	      </tr>
	      <tr>
	        <td>아이디</td>
	        <td>${userinfo.email}</td>
	      </tr>
	      <tr>
	        <td>닉네임</td>
	        <td>${userinfo.nickname}</td>
	      </tr>
	      <tr>
	        <td>생년월일</td>
	        <td>${userinfo.birthday}</td>
	      </tr>
	      <tr>
	        <td>성별</td>
	        <td>${userinfo.gender}</td>
	      </tr>
	      <tr>
	        <td>전화번호</td>
	        <td>${userinfo.phone}</td>
	      </tr>
	      <tr>
	        <td>권한</td>
	        <td>${userinfo.auth}</td>
	      </tr>
	      <tr>
	        <td>유저상태</td>
	        <td>${userinfo.userstatus}</td>
	      </tr>
<!-- 	      <tr> -->
<!-- 	        <td>멘토레벨</td> -->
<%-- 	        <td>${userinfo.mentotier}</td> --%>
<!-- 	      </tr> -->
	      <tr>
	        <td></td>
	        <td>${userinfo.logincnt}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.reportcnt}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.joindate}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.menteecnt}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.menteeaccstar}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.byebye}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.photo}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.major}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.career}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.certificate}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.specialfield}</td>
	      </tr>
<!-- 	      <tr> -->
<!-- 	        <td></td> -->
<%-- 	        <td>${userinfo.profiledto.pmdate}</td> --%>
<!-- 	      </tr> -->
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.mentorcnt}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.mentoaccstar}</td>
	      </tr>
	      <tr>
	        <td></td>
	        <td>${userinfo.profiledto.filechk}</td>
	      </tr>
	    </tbody>
  	</table>

</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>