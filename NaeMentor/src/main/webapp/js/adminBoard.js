$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});


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
			html  = "<table class='table'>"; 
			html += "<thead>"; 
			html += "<tr>";
			html +=	"<th></th> <th>학교</th> <th>사진</th> <th>전공</th> <th>경력</th>"; 
			html +=	"<th>자격증</th> <th>전문분야</th> <th>승급일</th> <th>멘토횟수</th> <th>멘토별점</th><th>돌아가기</th>";
			html +=	"</tr>";
			html +=	"</thead>";
			html +=	"<tbody>";
			html += "<tr>";
			html += "<td></td><td>"+msg.school+"</td>";
			html += "<td><img src='./resource/profileImg/"+msg.photo+"'></td>"+"<td>"+msg.major+"</td>";
			html += "<td>"+msg.career+"</td>"+"<td>"+msg.certificate+"</td>";
			html += "<td>"+msg.specialfield+"</td>"+"<td>"+msg.pmdate+"</td>";
			html += "<td>"+msg.mentorcnt+"</td>"+"<td>"+msg.mentoraccstar+"</td>";
			html += "<td><button class='myButton' onclick='comeBack("+val+","+cnt+")'>돌아가기</button></td>";
			html += "</tr>";
			html +=	"</tbody>";
			html += "</table>";
			$("table").eq(cnt-1).html(html);
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}


function comeBack(val, cnt){
	$.ajax({
		url:"./userInfo.do",
		type:"get",
		dataType:"json",
		data:{"memberseq":val},
		success:function(msg){
		html  = "<table class='table table-bordered'>";
		html += " <thead>";
		html += "	<tr>";
		html += "		<th>연번</th><th>이메일</th><th>닉네임</th><th>전화번호</th>";
		html += "		<th>생년월일</th><th>성별</th><th>권한</th>";
		html += "		<th>상태</th><th>멘토등급</th><th>신고당한 횟수</th>";
		html += "		<th>가입일</th><th>최근접속일</th><th>탈퇴신청</th>";
		html += "		<th>상세정보 보기</th>";
		html += "	</tr>";
		html += " </thead>";
		html += "<tbody id='myTable'>";
		html += "	<tr>";
		html += "		<td>"+cnt+"</td>";
		html +=	"		<td>"+msg.email+"</td><td>"+msg.nickname+"</td>";
		html += "		<td>"+msg.phone+"</td><td>"+msg.birthday+"</td><td>"+msg.gender+"</td>";
		html += "		<td>"+msg.auth+"</td><td>"+msg.userstatus+"</td><td>"+msg.mentortier+"</td>";
		html += "		<td>"+msg.reportcnt+"</td><td>"+msg.joindate+"</td>"+"<td>"+msg.lastaccess+"</td>";
		html += "		<td>"+msg.byebye+"</td>";
		html += "		<td><button class='myButton' onclick='userDetail("+msg.memberseq+","+cnt+")'>보기</button></td>";
		html += "	</tr>";
		html += "	</tbody>";
		html += "	</table>";
			$("table").eq(cnt-1).html(html);
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

function delSingoChk(val){
	if(confirm('회원 신고를 취소시키겠습니까?')){
		$.ajax({
			url: "./delSingoChk.do",
			data: "singoedmember="+val,
			type: "get",
			success: function(msg){
				alert("회원 신고가 취소 되었습니다.");
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

function mentorCancel(val){
	if(confirm("멘토승급을 거절하시겠습니까?")){
		$.ajax({
			url: "./mentorCancel.do",
			data: "memberseq="+val,
			type: "get",
			success: function(msg){
				alert("멘토 승급이 거절되었습니다.");
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
		data: {"memberList":$("#memberList option:selected").val()},
		success:function(msg){
			$.each(msg, function(key,value){
				//msg는 배열, k는 배열의 키(인덱스), v는 값
				// $.each(jsono, function(report, jLists)
			if(key === "mentor"){
				$("#defaultTable1").attr("style", "display:none;");
				$("#reportTable").remove(".table");
				$("#mentorTable").attr("style","display:default;");
				html  = "<table id ='mentorTable' class='table'>"
				$.each(value, function(k,v){ // 멘토신청 회원 조회
					html += "<tr><th>연번</th> <th>이메일</th> <th>닉네임</th> <th>자기소개</th>"; 
					html +=	"<th>전화번호</th> <th>생년월일</th> <th>성별</th> <th>신고당한횟수</th> <th>가입일</th>";
					html +=	"<th>사진</th> <th>학교</th> <th>전공</th> <th>경력</th> <th>자격증</th>";
					html +=	"<th>전문분야</th> <th>파일명</th> <th>업로드날짜</th></tr>";
					html += "<tr>";
					html += "<td>"+(k+1)+"</td>"
					html += "<td>"+v.email+"</td>";
					html += "<td>"+v.nickname+"</td>"+"<td>"+v.introduce+"</td>";
					html += "<td>"+v.phone+"</td>"+"<td>"+v.birthday+"</td>";
					html += "<td>"+v.gender+"</td>"+"<td>"+v.reportcnt+"</td>";
					html += "<td>"+v.joindate+"</td>"+"<td>"+v.photo+"</td>";
					html += "<td>"+v.school+"</td>"+"<td>"+v.major+"</td>";
					html += "<td>"+v.career+"</td>"+"<td>"+v.certificate+"</td>";
					html += "<td>"+v.specialfield+"</td>"+"<td>"+v.userfile[0]+"</td>";
					html += "<td>"+v.uploaddate+"</td>";
					html += "</tr>";
					html += "<td><input class='myButton' type='button' value='멘토 승급' onclick='mentorPromotion(\""+v.memberseq+"\")'></td>";
					html += "<td><input class='myButton' type='button' value='멘토 취소' onclick='mentorCancel(\""+v.memberseq+"\")'></td>";
				});
				html += "</table>";
				$("#select").append(html);
			}//멘토신청 회원 조회 끝
			else if(key === "reportM"){
				$("#defaultTable1").attr("style", "display:none;");
				$("#mentorTable").remove(".table");
				$("#reportTable").attr("style","display:default;");
				html  = "<table id='reportTable' class='table'>"
				$.each(value, function(k,v){ // 신고당한 회원 조회
					html += "<tr><th>연번</th> <th>신고한 회원</th> <th>신고당한 회원</th> <th>신고사유</th>"; 
					html +=	"<th>내용</th> <th>작성일</th> <th>삭제여부</th> <th>멘토링장소</th> <th>멘토링시간</th>";
					html +=	"<th>결정</th><th>경고증가</th>";
					html +=	"</tr>";
					html += "<tr>";
					html += "<td>"+(k+1)+"</td>"
					html += "<td>"+v.singomember+"</td>"+"<td>"+v.singoedmember+"</td>";
					html += "<td>"+v.singoreason+"</td>";
					html += "<td>"+v.content+"</td>"+"<td>"+v.writedate+"</td>";
					html += "<td>"+v.delflag+"</td>"+"<td>"+v.mentoringplace+"</td>";
					html += "<td>"+v.mentoringtime+"</td>";
					html += "<td><input class='myButton' type='button' value='증가' onclick='changeSingoChk(\""+v.singoedmember+"\")'></td>";
					html += "<td><input class='myButton' type='button' value='취소' onclick='delSingoChk(\""+v.singoedmember+"\")'></td>";
					html += "</tr>";
				});
				html += "</table>";
				$("#select").append(html);
			}// 신고당한 회원 조회 끝
			else{
				$("#defaultTable1").attr("style","display:default;");
				$("#reportTable").remove(".table");
				$("#mentorTable").remove(".table");
			}
			});
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}