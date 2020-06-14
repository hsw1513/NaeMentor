
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
			html += "<td>"+msg.photo+"</td>"+"<td>"+msg.major+"</td>";
			html += "<td>"+msg.career+"</td>"+"<td>"+msg.certificate+"</td>";
			html += "<td>"+msg.specialfield+"</td>"+"<td>"+msg.pmdate+"</td>";
			html += "<td>"+msg.mentorcnt+"</td>"+"<td>"+msg.mentoraccstar+"</td>";
//			alert(cnt);
			$(".profile").eq(cnt-1).prepend(html);
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}

function changeSingoChk(val){
	if(confirm('회원의 신고카운트를 증가시키시겠습니까?')){
		$.ajax({
			url: "./changeSingoChk.do",
			data: "singoedmember="+val,
			type: "get",
			success: function(msg){
				if(msg == "true"){
					console.log(msg);
					alert("경고카운트를 증가시켰습니다.");
				}else{
					alert("오류");
				}
			},
			error: function(){
				alert("오류");
			}
			
		});
	}
}

function changeBye(val, userstatus){
	if(confirm('회원 탈퇴를 수락하시겠습니까?')){
		$.ajax({
			url: "./changeBye.do",
			data: "email="+val,
			type: "get",
			success: function(msg){
				alert("회원 탈퇴가 승인되었습니다.");
			},
			error: function(){
				alert("오류");
			}
		});
	}
}

function mentorPromotion(val){
	if(confirm("멘토승급을 승인하시겠습니까?")){
		$.ajax({
			url: "./mentorPromotion.do",
			data: "memberseq="+val,
			type: "get",
			success: function(msg){
				alert("멘토 승급이 승인되었습니다.");
			},
			error: function(){
				alert("오류");
			}
		});
	}
}

function deleteReport(val){
	if(confirm("게시글을 삭제하시겠습니까?")){
		$.ajax({
			url: "./deleteReport.do",
			data: "boardseq="+val,
			type: "get",
			success: function(msg){
				alert("게시글이 삭제되었습니다.");
			},
			error: function(){
				alert("오류");
			}
		});
	}
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
			if(key === "reportC"){
			$.each(value, function(k, v){
			html  = "<tr>";
			html += "<td>"+(k+1)+"</td>"
			html += "<td>"+v.boardseq+"</td>"+"<td>"+v.title+"</td>";
			html += "<td>"+v.content+"</td>"+"<td>"+v.writesdate+"</td>";
			html += "<td>"+v.specialfield+"</td>"+"<td>"+v.target+"</td>";
			html += "<td>"+v.menteelevel+"</td>"+"<td>"+v.howto+"</td>";
			html += "<td>"+v.location+"</td>"+"<td>"+v.delflag+"</td>";
			html += "<td>"+v.mentorlist+"</td>"+"<td>"+v.findreporter+"</td>";
			html += "<td><input class='btn btn-primary' type='button' value='삭제' onclick='deleteReport(\""+v.boardseq+"\")'></td>";
			html += "</tr>";
			$(".table").prepend(html);
				});
			} // 신고게시글 조회 끝
			else if(key === "bye"){
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+(k+1)+"</td>"
					html += "<td>"+v.memberseq+"</td>"+"<td>"+v.email+"</td>";
					html += "<td>"+v.nickname+"</td>"+"<td>"+v.phone+"</td>";
					html += "<td>"+v.birthday+"</td>"+"<td>"+v.gender+"</td>";
					html += "<td>"+v.auth+"</td>"+"<td>"+v.userstatus+"</td>";
					html += "<td>"+v.mentortier+"</td>"+"<td>"+v.reportcnt+"</td>";
					html += "<td>"+v.joindate+"</td>"+"<td>"+v.menteecnt+"</td>";
					html += "<td>"+v.menteeaccstar+"</td>"+"<td>"+v.lastaccess+"</td>";
					html += "<td>"+v.byebye+"</td>";
					html += "<td><input class='btn btn-primary' type='button' value='탈퇴 수락' onclick='changeBye(\""+v.email+"\")'></td>";
					html += "</tr>";
					$(".table").prepend(html);
				});
			}//탈퇴신청 회원 조회 끝
			else if(key === "mentor"){
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+(k+1)+"</td>"
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
					html += "<td><input class='btn btn-primary' type='button' value='멘토 승급' onclick='mentorPromotion(\""+v.memberseq+"\")'></td>";
					$(".table").prepend(html);
				});
			}//멘토신청 회원 조회 끝
			else if(key === "reportM"){
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+(k+1)+"</td>"
					html += "<td>"+v.singomember+"</td>"+"<td>"+v.singoedmember+"</td>";
					html += "<td>"+v.singoreason+"</td>"+"<td>"+v.singochk+"</td>";
					html += "<td>"+v.reviewseq+"</td>"+"<td>"+v.boardseq+"</td>";
					html += "<td>"+v.content+"</td>"+"<td>"+v.writedate+"</td>";
					html += "<td>"+v.delflag+"</td>"+"<td>"+v.mentoringplace+"</td>";
					html += "<td>"+v.mentoringtime+"</td>";
					html += "<td><input class='btn btn-primary' type='button' value='경고증가' onclick='changeSingoChk(\""+v.singoedmember+"\")'></td>";
					html += "</tr>";
					$(".table").prepend(html);
				});
			}// 신고당한 회원 조회 끝
			else{
				$.each(value, function(k,v){
					html  = "<tr>";
					html += "<td>"+(k+1)+"</td>"
					html += "<td>"+v.email+"</td>"+"<td>"+v.nickname+"</td>";
					html += "<td>"+v.phone+"</td>"+"<td>"+v.birthday+"</td>";
					html += "<td>"+v.gender+"</td>"+"<td>"+v.auth+"</td>";
					html += "<td>"+v.userstatus+"</td>"+"<td>"+v.mentortier+"</td>";
					html += "<td>"+v.reportcnt+"</td>"+"<td>"+v.joindate+"</td>";
					html += "<td>"+v.lastaccess+"</td>"+"<td>"+v.byebye+"</td>";
					html += "<td><input class='btn btn-primary' type='button' value='보기' onclick='ajaxUserDetail(\""+v.memberseq+"\",\""+(k+1)+"\")'></td>";
					html += "</tr>";
					$(".table").prepend(html);
				});
			}
			});
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}


