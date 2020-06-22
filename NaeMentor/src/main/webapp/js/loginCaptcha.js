function enterKey() { //엔터치면 작동하는 기능
		if(window.event.keyCode==13){
			searchLoginCnt();
		}
	}


function searchLoginCnt(){
	var email = document.getElementById("email").value; //$("inputId")
	var password = document.getElementById("password").value; 
	
	if(email == null || email.trim()==""){
		document.getElementById("email").focus();
		alert("아이디를 입력해주세요");
	}else if(password == null || password.trim() == ""){
		document.getElementById("password").focus();
		alert("비밀번호를 입력해주세요");
	}else{
		$.ajax({
			url: "./searchLoginCnt.do",
			data: "email="+$("#email").val(), 
			type: "post",
			success: function(msg) { 
				if (msg >= 5) { 
					alert("로그인 시도 5회 초과입니다. 캡차 인증을 진행해주세요");
					$("#captcha").css("display", "block");
				} else { 
					$("form").eq(0).submit();
				} 
			},
			error: function(){
				alert("로그인을 다시 시도해주세요");
			}
			}); 
		}
}

function passCaptcha(){
	$.ajax({
		url: "./valchk.do",
		data: "key="+$("#key").val()+"&chk="+$("#chk").val(),
		type: "get", 
		success: function(msg) {
			if (msg == true) { 
				$("#forlogin").submit();
			} else { 
				alert("값을 다시 입력해주세요");
				return false;
			} 
		},
		error: function(){
			swal("오류","잘못된 요청입니다.");
		}
	}); 
}