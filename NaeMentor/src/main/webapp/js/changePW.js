function pwCheck(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var passOk= document.getElementById("passOk").value;
	var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; 
	var regExEmail = /[0-9a-zA-Z][_0-9a-zA-Z]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	
	if(email == ""){
		swal("비밀번호 변경 오류", "아이디를 입력해주세요");
		return false;
	}else if(!regExEmail.test(email)){
		swal("비밀번호 변경 오류", "이메일을 정확히 입력해주세요");
		return false;
	}else if(password == ""){
		swal("비밀번호 변경 오류", "비밀번호를 입력해주세요");
		return false;
	}else if(!regExpPw.test(password)){
		swal("비밀번호 변경 오류", "비밀번호를 정확히 입력해주세요(숫자, 특수문자, 영문 포함 8자리 이상 입력)");
		return false;
	}else if(password != passOk){
		swal("비밀번호 변경 오류", "비밀번호가 일치하지 않습니다");
		return false;
	}else{
		return true;
	}
	
}


function emailChk(){
	var toEmail = document.getElementById("toEmail").value;
	var email = document.getElementById("email").value;
	var newPWForm = document.getElementById("newPWForm");
	if(toEmail == email){
		if(pwCheck()){
		newPWForm.submit();
		}
	}else{
		swal("비밀번호 변경 오류", "자신의 비밀번호만 변경할 수 있습니다.")
		return false;
	}
}

function myEmailChk(){
	var myEmail = document.getElementById("myEmail").value;
	var email = document.getElementById("email").value;
	var newPWForm = document.getElementById("newPWForm");
	if(myEmail == email){
		if(pwCheck()){
			newPWForm.submit();
		}
	}else{
		swal("비밀번호 변경 오류", "자신의 비밀번호만 변경할 수 있습니다.");
		return false;
	}
}


function myREmailChk(){
	var myREmail = document.getElementById("myREmail").value;
	var email = document.getElementById("email").value;
	var newPWForm = document.getElementById("newPWForm");
	if(myREmail == email){
		if(pwCheck()){
			newPWForm.submit();
		}
	}else{
		swal("비밀번호 변경 오류", "자신의 비밀번호만 변경할 수 있습니다.");
		return false;
	}
}