
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
		data:$(this).val ,
		success:function(msg){
			html = "<td>"+msg.boardseq+"</td>"+"<td>"+msg.title+"</td>";
			html += "<td>"+msg.content+"</td>"+"<td>"+msg.writesdate+"</td>";
			html += "<td>"+msg.specialfield+"</td>"+"<td>"+msg.target+"</td>";
			html += "<td>"+msg.menteelevel+"</td>"+"<td>"+msg.howto+"</td>";
			html += "<td>"+msg.location+"</td>"+"<td>"+msg.delflag+"</td>";
			html += "<td>"+msg.mentorlist+"</td>"+"<td>"+msg.findreporter+"</td>";
			$("#select").prepend(html);
		},
		error:function(){
			alert("잘못된 요청입니다");
		}
	});
}


