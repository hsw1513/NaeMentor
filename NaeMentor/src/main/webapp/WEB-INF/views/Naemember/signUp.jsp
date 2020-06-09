<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/signUp.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<body>

	<div id="container">
		<input type="hidden" id="chkval" value="0">
	
	<form action="./signUp.do" method="post" id="frm" name="frm" enctype="multipart/form-data" onsubmit="return check()">
		<div id="info">
			<div id="leftInfo">회원가입</div>
			<div id="centerInfo">
				<input type="email" name="email" id="email" placeholder="이메일"><br>
				<input type="password" id="password" name="password" placeholder="비밀번호"><br>
				<input type="password" id="passOk" placeholder="비밀번호 확인 "><br>
				<input type="text" id="nickname" name="nickname" placeholder="닉네임"><input type="button" onclick="nickChk()"><br>
				<textarea rows="5" cols="30" id="introduce" name="introduce" placeholder="자기소개"></textarea><br>
				<input type="text" id="phone" name="phone" placeholder="휴대폰 번호"><br>
				<input type="text" id="birthday" name="birthday" placeholder="생년월일"><br>
				<select name="gender">
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select><br>
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
				<div id="rightInfo">
					<input multiple="multiple" type="file" name="filename" id="imgInput" onchange="a(this)">
					<img id="image" src="#" style="display: none">
				</div>
				<div id="button">
						<input type="submit" class="btn btn-success" value="회원가입">
						<input type="button" class="btn btn-primary" value="돌아가기" onclick="javascript:history.back(-1)">
				</div>
		</div>
	</form>
	
	
	</div>



</body>
</html>