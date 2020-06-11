
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
	var smsCheck = document.getElementById("smsCheck").value;
	
	if(email == "") {
		swal("회원가입 오류", "이메일을 확인해주세요");
		return false;
	}else if(password != passOk){
		swal("회원가입 오류", "비밀번호가 일치하지 않습니다");
		return false;
	}else if(nickname == ""){
		alert("회원가입 오류", "사용할 수 없는 닉네임입니다.");
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
	}else if(smsCheck == ""){
		alert("휴대전화 본인 인증을 진행해주세요");
	}else{
		return true;
	}
}

$(function(){
	$("#email").keyup(function(){
		var inputLength = $(this).val().length;
		var email = $(this).val();
		var regEx = /[0-9a-zA-Z][_0-9a-zA-Z]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		
		if(email.indexOf(" ") != -1){
			$("#result").css("color", "red");
			$("#result").html("공백이 포함된 아이디는 입력하실 수 없습니다<br>");
		}else if(!regEx.test(email)){
			$("#result").css("color", "red");
			$("#result").html("올바른 이메일 형식을 입력해주세요<br>");
		}else if(regEx.test(email)){
			jQuery.ajax({
				type:"post",
				url:"./idCheck.do",
				data:"email="+$(this).val(),
				async:true,
				success: function(msg){
					if(msg.isc == "false"){
						$("#result").css("color", "blue");
						$("#result").html("사용가능한 아이디입니다<br>");
						$("#chkval").val("1");
					}else{
						$("#result").css("color", "red");
						$("#result").html("사용 불가능한 아이디입니다<br>");
						$("#chkval").val("");
						$(this).val("");
					}
				},
				error:function(){
					alert("잘못된 요청값입니다.");
				}
			});
		}
		
	});
});

$(function(){
	$("#nickname").keyup(function(){
		var inputLength = $(this).val().length;
		var nickname = $(this).val();
		
		if(nickname.indexOf(" ") != -1){
			$("#result_nickname").css("color", "red");
			$("#result_nickname").html("공백이 포함된 아이디는 입력하실 수 없습니다<br>");
		}else {
			jQuery.ajax({
				type:"post",
				url:"./nickNameCheck.do",
				data:"nickname="+$(this).val(),
				async:true,
				success: function(msg){
					if(msg.isc == "false"){
						$("#result_nickname").css("color", "blue");
						$("#result_nickname").html("사용가능한 닉네임입니다<br>");
						$("#chkval").val("1");
					}else if(msg.isc == "true"){
						$("#result_nickname").css("color", "red");
						$("#result_nickname").html("사용 불가능한 닉네임입니다<br>");
						$("#chkval").val("");
						$(this).val("");
					}
				},
				error:function(){
					alert("잘못된 요청값입니다.");
				}
			});
		}
		
	});
});
