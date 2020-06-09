
function check(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var passOk = document.getElementById("passOk").value;
	var nickname = document.getElementById("nickname").value;
	var introduce = document.getElementById("introduce").value;
	var phone = document.getElementById("phone").value;
	var birthday = document.getElementById("birthday").value;
	var gender = document.getElementsByName("gender")[0];
	var idx = gender.selectedIndex;
	var genderValue = gender.options[idx].value;
	var chkId = document.getElementById("chkval").value;
	
	if(email == "") {
		swal("회원가입 오류", "이메일을 확인해주세요");
		return false;
	}else if(password != passOk){
		swal("회원가입 오류", "비밀번호가 일치하지 않습니다");
		return false;
	}else if(nickname == ""){
		swal("회원가입 오류", "사용할 수 없는 닉네임입니다.");
		return false;
	}else if(introduce == ""){
		swal("회원가입 오류", "자기소개를 필히 작성해주세요");
		return false;
	}else if(phone == ""){
		swal("회원가입 오류", "전화번호를 입력해주세요");
		return false;
	}else if(birthday == ""){
		swal("회원가입 오류","생년월일을 입력해주세요");
		return false;
	}else if(genderValue == ""){
		swal("회원가입 오류", "성별을 선택해주세요");
		return false;
	}else{
		return true;
	}
}