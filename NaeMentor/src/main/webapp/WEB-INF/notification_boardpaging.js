var pageAjax = function(){
	$.ajax({
		url: "./page.do",
		type: "post",
		async: true,
		data: $("#frm").serialize(), // 키=값&, input tag 안의 name 값을 키 값으로 가져옴
		dataType: "json",
		success: function(msg){
			alert(msg);
//			$.each(msg, function(key, value){ // lists, {"",[]} // row, {}
//				var varHtml = "";
//				var n = $(".table tr:eq(0) th").length;
//				var userAuth = $("userinfo.auth");
//				
//				if(key=="lists"){
//				varHtml += "<tr>";
//				varHtml += "<th><input type='checkbox' onclick='checkAll(this.checked)'></th>";
//				varHtml += "<th>글 번호</th>";
//				varHtml += "<th>제목</th>";
//				varHtml += "<th>작성자</th>";
//				varHtml += "<th>작성일</th>";
//				if(n == 6){
//				varHtml += "<th>삭제 여부</th>";
//				}
//				varHtml += "</tr>";
//				
//				$.each(value, function(k,v){
//					if(v.delflag == "N"){
//						varHtml +="<tr>";
//				 		if(uesrAuth == "ROLE_A"){
//						varHtml +="<td><input type='checkbox' name='chks' value='"+v.adminseq+"'></td>";
//						}
//						varHtml +="	<td>${fn:length(lists) - vs.index}</td>";
//						varHtml +="	<td>";
//						varHtml +="		<a title='"+v.title+"' href='./Notification_boardDetail.do?adminseq="+dto.adminseq+"' style='color: black;'>";
//						varHtml +="				</a>";
//						varHtml +="	</td>";
//						varHtml +="	<td>관리자</td>";
//						varHtml +="	<td>"+v.writedate+"</td>";
//						varHtml +="	<td>"+v.delflag+"</td>";
//						varHtml +="</tr>";
//					}
//						});
//					}else{
//					varHtml +="<li><a href='#' onclick='pageFirst()'>&laquo;</a></li>";
//					varHtml +="<li><a href='#' onclick='pagePre("+value.pageNum+","+value.pageList+")'>&lsaquo;</a></li>";
//					for (var i = value.pageNum; i <= value.count; i++) {
//						varHtml +="<li><a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>";
//					}
//					varHtml +="<li><a href='#' onclick='pageNext("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'>&rsaquo;</a></li>";
//					varHtml +="<li><a href='#' onclick='pageLast("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'>&raquo;</a></li>";
//				}                       
//				if(key == "lists"){
//					$(".table > tbody").html(varHtml);
//				}else{
//					$(".pagination").html(varHtml);
//				}
//			});

		},
		error: function(){
			alert("데이터 처리를 하지 못했습니다.");
		}
		
	})
}

var collapse = function(seq){
	$(".panel-collapse").not("#collapse"+seq).each(function(){
		$(this).attr('class','panel-collapse collapse');
	});
}