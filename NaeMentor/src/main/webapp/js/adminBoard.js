
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


function memberList(){
	var memList = document.getElementById("memberList").value;
//	alert(memList);
	location.href = "./memberList.do?memList="+memList;
}