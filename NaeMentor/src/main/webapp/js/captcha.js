


function searchLoginCnt(){
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
			alert("아이디와 패스워드를 입력해주세요");
		}
	}); 
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