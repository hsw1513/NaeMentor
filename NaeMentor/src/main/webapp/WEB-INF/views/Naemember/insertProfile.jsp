<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 입력</title>
<link type="text/css" rel="stylesheet" href="./css/naeMember/signUp.css">
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function cancel(){
		if(confirm("프로필 작성을 취소하시면 회원가입이 취소됩니다. 정말 진행하시겠습니까?")){
		var emailname = document.getElementById("email").value;
		location.href = "./cancel.do?email="+emailname;
		}
	}
</script>
<script type="text/javascript">
	function a(input){ // 사진 미리보기
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
			var img = document.getElementById("image");
				img.src = e.target.result; // 파일명 나옴
				img.style.width = '100%'; // 크기 사이즈 맞춘거
				img.style.height="auto"; // 크기 사이즈 맞춘거
			}
				reader.readAsDataURL(input.files[0]);
				$("#image").show();
		}
	}//흐름 : reader.readAsDataURL로 files[0] 읽어오면 이벤트 onload발생(e) -> 들어가서 파일 읽기 실행
</script>
<body>
<%@include file="/WEB-INF/views/noneTopMenu.jsp"%>
	<div id="container">
		<input type="hidden" id="chkval" value="0">
	
	<form action="./proFile.do" method="post" id="frm" name="frm" enctype="multipart/form-data" onsubmit="return check()">
		<div id="info">
			<div id="centerInfo">
				<input type="hidden" name="email" id="email" value="${email}">
				<h3 class="join_title1">
					<label>프로필 사진</label>
				</h3>
				<div id="rightInfo">
					<input multiple="multiple" type="file" name="filename" id="filename" onchange="a(this)">
					<img id="image" src="#" style="display: none">
				</div>
				<h3 class="join_title1">
					<label>학력</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="school" id="school" placeholder="최종 졸업 학교명"><br>
				</span>
				<h3 class="join_title1">
					<label>전공명</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="major" id="major" placeholder="전공명"><br>
				</span>
				<h3 class="join_title1">
					<label>경력</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="career" id="career" placeholder="경력"><br>
				</span>
				<h3 class="join_title1">
					<label>자격증</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="certificate" id="certificate" placeholder="자격증"><br>
				</span>
				<h3 class="join_title1">
					<label>전문분야</label>
				</h3>
				<span class="ps_box int_id">
				<input class="int" type="text" name="specialfield" id="specialfield" placeholder="전문분야"><br>
				</span>
			</div>
				
				<div id="button">
						<input type="submit" class="myButton" value="회원가입 완료">
						<input type="button" class="myButton" value="취소" onclick="cancel()">
				</div>
		</div>
	</form>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>