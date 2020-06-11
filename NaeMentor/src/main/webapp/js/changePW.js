
	function pwCheck() {
		var password = document.getElementById("password").value;
		var passOk = document.getElementById("passOk").value;
		
		if(password != passOk){
			swal("회원가입 오류", "비밀번호가 일치하지 않습니다");
			return false;
		}else{
			return true;
		}
	}