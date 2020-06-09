function del(val){
	alert(val);
	location.href="./del.do?adminseq="+val;
}

function checkAll(bool){
//	alert(bool);
	var chkVals = document.getElementsByName("chkVal");
	for (var i = 0; i < chkVals.length; i++) {
		chkVals[i].checked = bool;
	}
}

function chkbox(){
	var n = 0;
	
	var chkVals = document.getElementsByName("chkVal");
	for (var i = 0; i < chkVals.length; i++) {
		if(chkVals[i].checked){
			n++;
		}
	}
	if(n>0){
		document.getElementById("frm").action="./multiDel.do";
	}else{
		alert("게시글 오류", "선택된 값이 없습니다.");
		return false;
	}
}