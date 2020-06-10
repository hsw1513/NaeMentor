function multiDelChk(){
	   var chks = document.getElementsByName('chks');
//	   alert(chks[2].checked);
	   var cntChecked = 0;
	   var delChk = new Array();
	   for (var i = 0; i < chks.length; i++) {
	      if (chks[i].checked) {
	         cntChecked++;
	         delChk.push(chks[i].value);
	      }
	   }
//	   alert(delChk);
	   if (cntChecked>0) {
		  var mchk = document.getElementById("delmChk").action;
		  mchk = mchk + "?chks="+delChk;
	      return true;
	   }else{
	      alert("선택된 글이 없습니다.");
	      return false;
	   }
	}