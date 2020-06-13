
function userDetail(val, cnt){
	ajaxUserDetail(val, cnt);
}


var ajaxUserDetail = function(val, cnt){
	$.ajax({
		url:"./userDetail.do",
		type:"get",
		dataType:"json",
		data:{"memberseq":val},
		success:function(msg){
			html = "<td>"+"</td>"+"<td>"+msg.school+"</td>";
			html += "<td>"+msg.photo+"</td>"+"<td>"+msg.school+"</td>";
			html += "<td>"+msg.major+"</td>"+"<td>"+msg.career+"</td>";
			html += "<td>"+msg.certificate+"</td>"+"<td>"+msg.specialfield+"</td>";
			html += "<td>"+msg.pmdate+"</td>"+"<td>"+msg.mentorcnt+"</td>";
			html += "<td>"+msg.mentoraccstar+"</td>";
//			alert(cnt);
			$(".profile").eq(cnt-1).prepend(html);
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}



var ajaxReportMember = function(){
	$.ajax({
		url:"./reportContent.do",
		type:"get",
		dataType:"json",
		data: {"memberList":$("#memberList option:selected").val()}, //$("#memberList option:selected").val(), //$(this).val
		success:function(msg){
			$.each(msg, function(key,value){
				//msg는 배열, k는 배열의 키(인덱스), v는 값
				// $.each(jsono, function(report, jLists)
			if(key === "report"){
			$.each(value, function(k, v){
			html  = "<tr>";
			html += "<td>"+v.boardseq+"</td>"+"<td>"+v.title+"</td>";
			html += "<td>"+v.content+"</td>"+"<td>"+v.writesdate+"</td>";
			html += "<td>"+v.specialfield+"</td>"+"<td>"+v.target+"</td>";
			html += "<td>"+v.menteelevel+"</td>"+"<td>"+v.howto+"</td>";
			html += "<td>"+v.location+"</td>"+"<td>"+v.delflag+"</td>";
			html += "<td>"+v.mentorlist+"</td>"+"<td>"+v.findreporter+"</td>";
			html += "</tr>";
			$(".table").prepend(html);
				});
			} // reportMember
			else if(key === "bye"){
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+v.memberseq+"</td>"+"<td>"+v.email+"</td>";
					html += "<td>"+v.nickname+"</td>"+"<td>"+v.phone+"</td>";
					html += "<td>"+v.birthday+"</td>"+"<td>"+v.gender+"</td>";
					html += "<td>"+v.auth+"</td>"+"<td>"+v.userstatus+"</td>";
					html += "<td>"+v.mentortier+"</td>"+"<td>"+v.reportcnt+"</td>";
					html += "<td>"+v.joindate+"</td>"+"<td>"+v.menteecnt+"</td>";
					html += "<td>"+v.menteeaccstar+"</td>"+"<td>"+v.lastaccess+"</td>";
					html += "<td>"+v.byebye+"</td>";
					html += "</tr>";
					$(".table").prepend(html);
				});
			}//탈퇴신청 회원 조회
			else if(key === "mentor"){
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+v.memberseq+"</td>"+"<td>"+v.email+"</td>";
					html += "<td>"+v.nickname+"</td>"+"<td>"+v.introduce+"</td>";
					html += "<td>"+v.phone+"</td>"+"<td>"+v.birthday+"</td>";
					html += "<td>"+v.gender+"</td>"+"<td>"+v.reportcnt+"</td>";
					html += "<td>"+v.joindate+"</td>"+"<td>"+v.photo+"</td>";
					html += "<td>"+v.school+"</td>"+"<td>"+v.major+"</td>";
					html += "<td>"+v.career+"</td>"+"<td>"+v.certificate+"</td>";
					html += "<td>"+v.specialfield+"</td>"+"<td>"+v.mentoaccstar+"</td>";
					html += "<td>"+v.filechk+"</td>"+"<td>"+v.userfile+"</td>";
					html += "<td>"+v.uploaddate+"</td>";
					html += "</tr>";
					$(".table").prepend(html);
				});
			}//멘토신청 회원 조회
			});
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}


