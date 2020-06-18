
// 닉네임 변경
function modifyNickname(){
	// display: none;을 통해 감춰진 팝업창을 보이게하자
	document.getElementById('newNick').style.display='block';
	//버튼을 누르자마자 생겨날 것
	document.body.style.background='gray'; //화면 몸통 안쓰는것처럼보이게 회색으로함
	var btns = document.getElementsByName('btn');
	for (var i in btns) { //향상된 for문 ==> index의 길이만 가져옴
		btns[i].disabled = 'disabled'; //회원가입을 누르면 버튼 못쓰게
	}	
}

function closeWin1(){
	var nickname = document.getElementById("newNickname").value;
	var regexNick = /^[가-힣a-z0-9A-Z]{4,12}$/; //한글,영문,숫자포함 4-12자리 가능
	var newNickForm = document.getElementById("changeNick");
	if(nickname == ""){
		alert("닉네임을 입력해주세요");
		return false;
	}else if(!regexNick.test(nickname)){
		alert("닉네임을 정확히 입력해주세요(한글,영문,숫자포함 4-12자리 가능)");
		return false;
	}else{
	document.getElementById('changeNick').style.display='none';
	document.body.style.background='white'; 
	newNickForm.submit();
	}
}

function goback1(){
	location.href = "./Profile.do";
}

// 자기소개 변경
function modifyIntro(){
	document.getElementById('newIntro').style.display='block';
	document.body.style.background='gray'; //화면 몸통 안쓰는것처럼보이게 회색으로함
	var btns = document.getElementsByName('btn');
	for ( var i in btns) { //향상된 for문 ==> index의 길이만 가져옴
		btns[i].disabled = 'disabled'; //회원가입을 누르면 버튼 못쓰게
	}	
}

function closeWin2(){
	var introduce = document.getElementById("introduce").value;
	var newIntroForm = document.getElementById("changeIntro");
	if(introduce.trim() == ""){
		swal("회원가입 오류", "자기소개를 필히 작성해주세요");
		return false;
	}else{
	newIntroForm.submit();
	}
}

function goback2(){
	location.href = "./Profile.do";
}

// 휴대전화번호 변경
function modifyPhone(){
	document.getElementById('newPhoneNum').style.display='block';
	document.body.style.background='gray';
	var btns = document.getElementsByName('btn');
	for ( var i in btns) {
		btns[i].disabled = 'disabled';
	}	
}

// 변경값들 유효성 처리
var smschk = false;
function closeWin3(){
	var phoneNum = document.getElementById("phone");
	var smsCheck = document.getElementById("smsCheck").value;

	if(phoneNum == ""){
		alert("휴대전화 번호를 입력해주세요");
		return false;
	}else if(smsCheck == ""){
		alert("휴대전화 본인 인증을 진행해주세요");
		return false;
	}else if(smschk == false){
		alert("sms 인증을 완료해주세요");
		return false;
	}else{
	var newPhoneForm = document.getElementById("changePhone");
	newPhoneForm.submit();
	}
}

function goback3(){
	location.href = "./Profile.do";
}

// 닉네임 중복검사 Ajax 처리
$(function(){
	$("#newNickname").keyup(function(){
		var inputLength = $(this).val().length;
		var nickname = $(this).val();
		var regexNick2 = /^[가-힣a-z0-9A-Z]{4,12}$/; //한글,영문,숫자포함 4-12자리 가능
		
		if(nickname.indexOf(" ") != -1){
			$("#result_nickname").css("color", "red");
			$("#result_nickname").html("공백이 포함된 닉네임은 입력하실 수 없습니다<br>");
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

// SMS 인증번호 전송 Ajax 처리
function sendSms() {
	var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/; // 휴대전화 번호 정규화 표현식
	var phone = $("#phone").val();
	if(phone == null){
		alert("휴대폰 번호를 입력해주세요");
		return false;
	}else if(phone == ""){
			swal("정보 변경 오류", "휴대전화 번호를 입력해주세요");
			return false;
	}else if(!regExpPhone.test(phone)){
		swal("정보 변경 오류", "휴대전화 번호를 정확히 입력해주세요(-포함)");
		return false;
	}else{
    	$.ajax({
    		url: "./sendSms.do",
    		data: "phone="+$("#phone").val(), 
    		type: "post", 
    		success: function(msg) { 
    			if (msg == "true") { 
    				console.log(msg);
    				swal("SMS인증","인증번호 전송 성공");
    				smschk= true;
    				$("#send").val("재전송");
    			} else { 
    				swal("SMS인증 오류","인증번호 전송 실패","error"); 
    			} 
    		},
    		error: function(){
    			swal("오류","잘못된 요청입니다.","warning");
    		}
    	}); 
	}
   } 

// SMS인증번호 입력한 값 체크 Ajax 처리
function numberCheck(){ 
 	$.ajax({ 
 		url: "./smsCheck.do", 
 		type: "post", 
 		data: "sms="+$("#sms").val(),
 		success: function(msg) { 
 			if (msg == "ok") { 
 				swal("SMS인증","번호 인증 성공");
 				smschk = true;
 			} else { 
 				swal("SMS인증 오류","번호 인증 실패","warning");
 			} 
 		},
 		error: function(){
 			swal("잘못된 요청입니다.");
 		}
 	}); 
}
    
    
