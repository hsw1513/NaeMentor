<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토 신청</title>
<style type="text/css">
input {
	height: 30px;
	width: 200px;
	margin: 5px;
	border: 1.5px solid lightgrey;
	border-radius: 5px;
	}

th{
	width: 130px;
	height: 40px;
}	
table{
	margin-top: 30px;
	margin-bottom: 30px;
}
</style>
</head>
<script type="text/javascript">

	function chkVal(){
		let inputs = document.getElementsByTagName("input");
		let flag = true;
		for(var i = 0; i<inputs.length-1; i++){
			if(inputs[i].value==''){
				flag = false;
			}
		}
		if(!flag){
			alert("모든 값들을 입력해주세요.");
		}
		return flag;
	}
	
	function uploadPhoto(){
		let form_1 = document.getElementsByTagName("form")[0];
		let formData = new FormData(form_1);
		uploadImg(formData); 
	}
	function uploadImg(formData){
		let xhrImg = new XMLHttpRequest();
		xhrImg.onreadystatechange = function(){
			if(xhrImg.readyState==4){
				if(xhrImg.status ==200){
					let val = JSON.parse(xhrImg.responseText);				
					alert(val.fileName);
					document.getElementById("tt").src = val.url;
					document.getElementsByName("photo")[0].value = val.fileName;
			}
			}
		}
		xhrImg.open("post","./imgUpload.do");
		xhrImg.send(formData);
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container" style="margin: auto; width: 350px; text-align: center;">
	<div id="leftdiv">
		<div id="imgdiv">
		<c:choose>
		<c:when test="${profile.profiledto.photo eq '0'}">
			<img id="tt" alt="프로필이미지" src="./resource/profileImg/default.png">
		</c:when>
		<c:otherwise>
			<img id="tt" alt="프로필이미지" src="./resource/profileImg/${profile.profiledto.photo}">
		</c:otherwise>
		</c:choose>
		</div>
		<form enctype="multipart/form-data">
		<input type="file" name="photofile" style="text-align: center;">
		</form>
		<button class="myButton" onclick="uploadPhoto()">사진올리기</button>
	</div>
	<form action="./applymentor.do" method="post" enctype="multipart/form-data" onsubmit="return chkVal()">
	<input type="hidden" name="memberseq" value="${profile.memberseq}">
	<input type="hidden" name="photo" value="">
	
	<table>
		<tr>
			<th>학교</th>
			<td>
				<input type="text" name="school" value="${profile.profiledto.school}">
			</td>
		</tr>
		<tr>
			<th>전공</th>
			<td>
				<input type="text" name="major" value="${profile.profiledto.major}">
			</td>
		</tr>
		<tr>
			<th>경력</th>
			<td>
				<input type="text" name="career" value="${profile.profiledto.career}">
			</td>
		</tr>
		<tr>
			<th>자격증</th>
			<td>
				<input type="text" name="certificate" value="${profile.profiledto.certificate}">
			</td>
		</tr>
		<tr>
			<th>전문 분야</th>
			<td>
				<input type="text" name="specialfield" value="${profile.profiledto.specialfield}">
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<input type="file" name="files">
			</td>
		</tr>
	</table>
			<input type="submit" class="myButton" value="멘토신청" style="text-align: center;">
	</form>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>