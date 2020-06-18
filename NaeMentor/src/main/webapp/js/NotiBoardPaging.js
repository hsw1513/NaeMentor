	function notiBoardWrite(){
				location.href="./Notification_boardWrite.do";
			}
			function checkAll(bool) {
				var chks = document.getElementsByName('chks');
				for (var i = 0; i < chks.length; i++) {
					chks[i].checked=bool;
				}
			}
			function multiDelChk(){
				   var chks = document.getElementsByName('chks');
				   var cntChecked = 0;
				   var delChk = new Array();
				   for (var i = 0; i < chks.length; i++) {
				      if (chks[i].checked) {
				         cntChecked++;
				         delChk.push(chks[i].value);
				      }
				   }
				   if (cntChecked>0) {
					  var mchk = document.getElementById("delmChk").action;
					  mchk = mchk + "?chks="+delChk;
				      return confirm("정말로 삭제하시겠습니까?");
				   }else{
				      alert("선택된 글이 없습니다.");
				      return false;
				   }
			}
			
			// 첫번째 페이지로 작동 <<
			function pageFirst(){
// 				alert("작동");
				var index = document.getElementById("index");
				var pageNum = document.getElementById("pageNum");
				index.value = 0;
				pageNum.value = 1;
				pageAjax();
			}
			
		
			// < 버튼
			function pagePre(num, pageList){
// 				alert(num+"-"+pageList+"="+(num-pageList));
				if(0 < num-pageList){
					num -= pageList;
//					alert(num);
				var index = document.getElementById('index');
				var pageNum = document.getElementById('pageNum');
//				alert(index);
				pageNum.value=num;
				index.value=num-1;
				}
				pageAjax();
			}
					
			// 인덱스를 통한 해당 페이지 이동 index는 0부터 시작
			function pageIndex(idx){
// 				alert(idx);
				var index = document.getElementById('index');
				index.value = idx-1;
				pageAjax();
			}
			
			// >> 버튼
			function pageLast(num, total, listNum, pageList){
// 				alert("작동");
				var idx = Math.ceil(total/listNum);
				var max = Math.ceil(idx/pageList);
				
				while(max*pageList > num+pageList){
					num += pageList;
				}
				var index = document.getElementById("index");
				var pageNum = document.getElementById("pageNum");
				pageNum.value = num;
				index.value = idx-1;
//				alert(index.value);
				pageAjax();
				}
			// > 버튼
			function pageNext(num, total, listNum, pageList){ // 페이지 번호, 전체 글 개수, 뿌려지는 글의 row 개수, 페이지 1,2,3,4,5
// 				alert(num);
// 				alert(total);
// 				alert(listNum);
// 				alert(pageList);
				var index = Math.ceil(total/listNum); // 30/5, 6개의 페이지가 있음
				var max = Math.ceil(index/pageList);  // 6/5, 2개의 그룹으로 나누어짐
//				alert(max*pageList);
//				alert(num+pageList);
				if(max*pageList > num+pageList){
					num += pageList;
					var index = document.getElementById("index");
					var pageNum = document.getElementById("pageNum");
					pageNum.value = num;
					index.value = num - 1;
//					alert(index.value);
				}
				pageAjax();
			}
//---------------------------------- 공통 페이징 AJAX ----------------------------------
function pageAjax(){
// 	alert("아작아작");
$.ajax({
		url: "./page.do",
		type: "post",
		async: true,
		data: $("#delmChk").serialize(), // 키=값&, input tag 안의 name 값을 키 값으로 가져옴
		dataType: "json",
		success: function(msg){
//			alert(msg);
			
			$.each(msg, function(key, value){ // lists, {"",[]} // row, {}
			var varHtml = "";
			var n = $(".table tr:eq(0) th").length;
			
			if(key=="lists"){
			varHtml += "<tr>";
			if(n == 5){
			varHtml += "<th><input type='checkbox' onclick='checkAll(this.checked)'></th>";
			}
			varHtml += "<th>글 번호</th>";
			varHtml += "<th>제목</th>";
			varHtml += "<th>작성자</th>";
			varHtml += "<th>작성일</th>";
			varHtml += "</tr>";
			
			$.each(value, function(k,v){
					varHtml +="<tr>";
			 		if(n == 5){
					varHtml +="<td><input type='checkbox' name='chks' value='"+v.adminseq+"'></td>";
					}
					varHtml +="	<td>"+v.adminseq+"</td>";
					varHtml +="	<td>";
					varHtml +="		<a title='"+v.title+"' href='./Notification_boardDetail.do?adminseq="+v.adminseq+"' style='color: black;'>"+v.title+"</a>";
					varHtml +="	</td>";
					varHtml +="	<td>관리자</td>";
					varHtml +="	<td>"+v.writedate+"</td>";
					varHtml +="</tr>";
					});
				}else{
				varHtml +="<li><a href='#' onclick='pageFirst()'>&laquo;</a></li>";
				varHtml +="<li><a href='#' onclick='pagePre("+value.pageNum+","+value.pageList+")'>&lsaquo;</a></li>";
				for (var i = value.pageNum; i <= value.count; i++) {
					varHtml +="<li><a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>";
				}
				varHtml +="<li><a href='#' onclick='pageNext("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'>&rsaquo;</a></li>";
				varHtml +="<li><a href='#' onclick='pageLast("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'>&raquo;</a></li>";
			}                       
			if(key == "lists"){
				$(".table > tbody").html(varHtml);
			}else{
				$(".pagination").html(varHtml);
			}
		});
		},
		error: function(){
			alert("데이터 처리를 하지 못했습니다.");
		}
	})
}