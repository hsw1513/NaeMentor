function sendSms() { // 인증번호 전송 ajax 처리
	
	var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/; // 휴대전화 번호 정규화 표현식
	var phone = $("#phone").val();
	if(phone == null){
		alert("휴대폰 번호를 입력해주세요");
		return false;
	}else if(phone == ""){
			swal("회원가입 오류", "휴대전화 번호를 입력해주세요");
			return false;
	}else if(!regExpPhone.test(phone)){
		swal("회원가입 오류", "휴대전화 번호를 정확히 입력해주세요(-포함)");
		return false;
	}else{
    	$.ajax({
    		url: "./searchLoginCnt.do",
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
  
    function numberCheck(){ // 인증번호 체크 ajax 처리
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