function idChk(){
	var phone = document.getElementById("phone").value;
	var birthday = document.getElementById("birthday").value;
	var regExpBirthday = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/; // 생년월일 정규식(19930113)
	var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/; // 휴대전화 번호 정규화 표현식
	
	if(phone == "" & birthday == ""){
		swal("아이디 찾기 오류", "회원정보를 입력해주세요");
		return false;
	}else if(!regExpPhone.test(phone)){
		swal("아이디 찾기 오류", "휴대전화 번호를 정확히 입력해주세요(-포함)");
		return false;
	}else if(!regExpBirthday.test(birthday)){
		swal("아이디 찾기 오류", "생년월일을 정확히 입력해주세요(ex:19930113)");
		return false;
	}else{
		searchMyID();
	}
	
}

function pwChk(){
	var pwemail = document.getElementById("pwemail").value;
	var pwbirthday = document.getElementById("pwbirthday").value;
	var regEx = /[0-9a-zA-Z][_0-9a-zA-Z]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	var regExpBirthday = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/; // 생년월일 정규식(19930113)
	
	if(!regEx.test(pwemail)){
		swal("비밀번호 찾기 오류", "이메일을 정확히 입력해주세요");
		return false;
	}else if(!regExpBirthday.test(pwbirthday)){
		swal("비밀번호 찾기 오류", "생년월일을 정확히 입력해주세요");
		return false;
	}else{
		searchMyPW();
	}
	
}

function searchMyID(){
	$.ajax({ 
		url: "./idSend.do", 
		type: "post", 
		data: $('#idSend1').serialize(),
		success: function(msg) { 
			if (msg != "no") { 
				swal("아이디 찾기 성공",msg);
			} else { 
				swal("아이디 찾기 실패","다시 한번 시도해주세요");
			} 
		},
		error: function(){
			swal("잘못된 요청입니다.");
		}
	}); 
}

function searchMyPW(){
	$.ajax({ 
		url: "./passwordSend.do", 
		type: "post", 
		data: $('#pwSend1').serialize(),
		success: function(msg) { 
			if (msg == "true") { 
				swal("비밀벊 찾기 성공","입력하신 이메일로 비밀번호 변경 링크를 발송했습니다. 확인해주세요");
			}
		},
		error: function(){
			swal("잘못된 요청입니다.");
		}
	}); 
}

