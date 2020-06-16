
	function yakGwangChk(){
		 if (document.getElementById("yakgwan").checked == true) {
             return true;
         }else{
        	 alert("약관에 반드시 동의해주세요");
        	 return false;
         }
	}