  function sendSms() { // 인증번호 전송 ajax 처리
    	$.ajax({ 
    		url: "./sendSms.do",
    		data: "phone="+$("#phone").val(), 
    		type: "post", 
    		success: function(msg) { 
    			if (msg == "true") { 
    				console.log(msg);
    				swal("SMS인증","인증번호 전송 성공"); 
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
  
    function numberCheck(){ // 인증번호 체크 ajax 처리
    	$.ajax({ 
    		url: "./smsCheck.do", 
    		type: "post", 
    		data: "sms="+$("#sms").val(),
    		success: function(msg) { 
    			if (msg == "ok") { 
    				swal("SMS인증","번호 인증 성공");
    			} else { 
    				swal("SMS인증 오류","번호 인증 실패","warning"); 
    			} 
    		},
    		error: function(){
    			swal("잘못된 요청입니다.");
    		}
    	}); 
    }