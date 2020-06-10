<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function cancel(){
		var emailname = document.getElementById("email").value;
		location.href = "./cancel.do?email="+emailname;
	}
</script>
<body>
	<div id="container">
		<input type="hidden" id="chkval" value="0">
	
	<form action="./proFile.do" method="post" id="frm" name="frm" onsubmit="return check()">
		<div id="info">
			<div id="leftInfo">회원가입</div>
			<div id="centerInfo">
				<input type="hidden" name="email" id="email" value="${email}">
				<input type="text" name="photo" id="photo" placeholder="사진"><br>
				<input type="text" name="school" id="school" placeholder="최종 졸업 학교명"><br>
				<input type="text" name="major" id="major" placeholder="전공명"><br>
				<input type="text" name="career" id="career" placeholder="경력"><br>
				<input type="text" name="certificate" id="certificate" placeholder="자격증"><br>
				<input type="text" name="specialfield" id="specialfield" placeholder="전문분야"><br>
			</div>
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
					}				//흐름 : reader.readAsDataURL로 files[0] 읽어오면 이벤트 onload발생(e) -> 들어가서 파일 읽기 실행
				</script>
				<div id="button">
						<input type="submit" class="btn btn-success" value="회원가입 완료">
						<input type="button" class="btn btn-primary" value="취소" onclick="cancel()">
				</div>
		</div>
	</form>
	
	
	</div>
</body>
</html>