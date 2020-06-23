var emailchk= false;
var smschk = false;
function check(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var passOk = document.getElementById("passOk").value;
	var nickname = document.getElementById("nickname").value;
	var introduce = document.getElementById("introduce").value;
	var phone = document.getElementById("phone").value;
	var birthday = document.getElementById("birthday").value;
	var gender = document.getElementsByName("gender")[0];
	var inputPhone = document.getElementById("phone").value;
	var idx = gender.selectedIndex;
	var genderValue = gender.options[idx].value;
	var chkId = document.getElementById("chkval").value;
	var smsCheck = document.getElementById("smsCheck").value;
	var regexNick = /^[가-힣a-z0-9A-Z]{4,12}$/; //한글,영문,숫자포함 4-12자리 가능
	var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; 
	// 비밀번호 정규화 표현식, 숫자, 특수문자 각 1회 이상, 영문은 2개 이상 사용하여 8자리 이상 입력
	var regExpBirthday = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/; // 생년월일 정규식(19930113)
	var regExpPhone1 = /^\d{3}-\d{3,4}-\d{4}$/;
	
	if(email == ""){
		swal("회원가입 오류", "아이디를 입력해주세요");
		return false;
	}else if(emailchk == false){
		swal("회원가입 오류", "이메일 인증을 완료해주세요");
		return false;
	}else if(password.trim() == ""){
		swal("회원가입 오류", "비밀번호를 입력해주세요");
		return false;
	}else if(passOk.trim() == ""){
		swal("회원가입 오류", "비밀번호를 확인해주세요");
		return false;
	}else if(!regExpPw.test(password)){
		swal("회원가입 오류", "비밀번호는 숫자, 특수문자 1회 이상, 영문은 2개 이상 사용하여 8자리 이상 입력하여야합니다.")
		return false;
	}else if(password != passOk){
		swal("회원가입 오류", "비밀번호가 일치하지 않습니다");
		return false;
	}else if(nickname == ""){
		swal("회원가입 오류", "닉네임을 입력해주세요");
		return false;
	}else if(!regexNick.test(nickname)){
		alert("닉네임을 정확히 입력해주세요(한글,영문,숫자포함 4-12자리 가능)");
		return false;
	}else if(introduce.trim() == ""){
		swal("회원가입 오류", "자기소개를 필히 작성해주세요");
		return false;
	}else if(inputPhone.trim() == ""){
		swal("회원가입 오류", "휴대폰 번호를 입력해주세요");
		return false;
	}else if(!regExpPhone1.test(inputPhone)){
		swal("회원가입 오류", "휴대폰 번호를 정확히 입력해주세요(- 포함)");
		return false;
	}else if(smsCheck == ""){
		swal("회원가입 오류", "휴대전화 본인 인증을 진행해주세요");
		return false;
	}else if(smschk == false){
		swal("회원가입 오류","sms 인증을 완료해주세요");
		return false;
	}else if(birthday == ""){
		swal("회원가입 오류","생년월일을 입력해주세요");
		return false;
	}else if(!regExpBirthday.test(birthday)){
		swal("회원가입 오류","생년월일을 정확하게 입력해주세요");
		return false;
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

function emailConfirm1() {
	var regEx = /[0-9a-zA-Z][_0-9a-zA-Z]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	var email = $("#email").val();
	if(email == null){
		alert("이메일을 입력해주세요");
		return false;
	}else if(email == ""){
			swal("회원가입 오류", "이메일을 입력해주세요");
			return false;
	}else{
		$.ajax({
			type: "post", 
    		url: "./emailConfirm.do",
    		data: "email="+$("#email").val(), 
    		success: function(msg) { 
    			if (msg == "true") { 
    				console.log(msg);
    				swal("이메일 인증","인증번호 전송 성공"); 	
    				$("#emailConfirm").val("재전송");
    			} else { 
    				swal("이메일 인증 오류","이미 존재하는 회원입니다","error"); 
    			} 
    		},
    		error: function(){
    			swal("오류","잘못된 요청입니다.","warning");
    		}
	}); 
  }
}

function emailChk1(){
	$.ajax({
		type: "post",
		url: "./emailChk.do",
		data: "emailNum="+$("#emailNum").val(),
		success: function(msg){
			if(msg == "ok"){
				swal("이메일 인증", "이메일 인증 성공");
				emailchk= true;
			} else{
				swal("이메일 인증 오류", "정확한 인증번호를 입력해주세요");
			}
		},
		error: function(){
			alert("잘못된 요청입니다.");
		}
	});
}





$(function(){
	$("#nickname").keyup(function(){
		var inputLength = $(this).val().length;
		var nickname = $(this).val();
		var regexNick2 = /^[가-힣a-z0-9A-Z]{4,12}$/; //한글,영문,숫자포함 4-12자리 가능S
		
		if(nickname.indexOf(" ") != -1){
			$("#result_nickname").css("color", "red");
			$("#result_nickname").html("공백이 포함된 아이디는 입력하실 수 없습니다<br>");
		}else if(!regexNick2.test(nickname)){
			$("#result_nickname").css("color", "red");
			$("#result_nickname").html("닉네임을 정확히 입력해주세요(한글,영문,숫자포함 4-12자리 가능)<br>");
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


$(function(){
	$("#phone").keyup(function(){
		var inputLength = $(this).val().length;
		var phone = $(this).val();
		var regExpPhone1 = /^\d{3}-\d{3,4}-\d{4}$/;
		
		if(!regExpPhone1.test(phone)){
			$("#result_phone").css("color", "red");
			$("#result_phone").html("휴대전화 번호를 정확히 입력해주세요(- 포함)<br>");
		}else {
			jQuery.ajax({
				type:"post",
				url:"./phoneCheck.do",
				data:"phone="+$(this).val(),
				async:true,
				success: function(msg){
					if(msg.isc == "false"){
						$("#result_phone").css("color", "blue");
						$("#result_phone").html("사용가능한 휴대전화 번호입니다<br>");
						$("#chkval").val("1");
					}else if(msg.isc == "true"){
						$("#result_phone").css("color", "red");
						$("#result_phone").html("이미 존재하는 휴대전화 번호입니다.<br>");
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