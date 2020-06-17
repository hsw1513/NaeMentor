<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<script type="text/javascript">

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
			
			var listNum = document.getElementById("listNum").value;
			var list = document.getElementById("list");

			// 첫번째 페이지로 작동 <<
			function pageFirst(){
// 				alert("작동");
				var index = document.getElementById("index");
				var pageNum = document.getElementById("pageNum");
				index.value = 0;
				pageNum.value = 1;
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
				
				pageAjax();
				}
		
			// < 버튼
			function pagePre(num, pageList){
// 				alert(num+":"+pageList);
				if(0 < num-pageList){
					num -= pageList;
				var index = document.getElementById("index");
				var pageNum = document.getElementById("pageNum");
				pageNum.value = num;
				index.value = num-1;
				}
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
				
				if(max*pageList > num+pageList){
					num += pageList;
					
					var index = document.getElementById("index");
					var pageNum = document.getElementById("pageNum");
					
					pageNum.value = num;
					index.value = num - 1;
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
		data: $("#frm").serialize(), // 키=값&, input tag 안의 name 값을 키 값으로 가져옴
		dataType: "json",
		success: function(msg){
			alert(msg);
		}
	})
}
			
</script>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		 <h2>공지사항</h2>
  			<p>내멘토의 공지사항이 올라오는 곳입니다. 자주 확인해 주세요.</p>  
		<form action="./Notification_boardMultiDel.do" id="delmChk" method="post" onsubmit="return multiDelChk()">
		<div>
			<table class="table table-hover">
				<tr>
					<c:if test="${userinfo.auth eq 'ROLE_A'}">	
					<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
					</c:if>
						<th>글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					<c:if test="${userinfo.auth eq 'ROLE_A'}">	
						<th>삭제여부</th>
					</c:if>
				</tr>
		 		<c:forEach var="dto" items="${lists}" varStatus="vs">
		 		<c:if test="${dto.delflag eq 'N'}">
		 			<tr>
		 			<c:if test="${userinfo.auth eq 'ROLE_A'}">	
					<td><input type="checkbox" name="chks" value="${dto.adminseq}"></td>
					</c:if>
						<td>${fn:length(lists) - vs.index}</td>
						<td>
							<a title="${dto.title}" href="./Notification_boardDetail.do?adminseq=${dto.adminseq}" style="color: black;">
									<c:choose>
										<c:when test="${fn:length(dto.title)>10 }">
											${fn:substring(dto.title,0,10)}...
										</c:when>
										<c:otherwise>${dto.title}</c:otherwise>
									</c:choose> 
							</a>
						</td>
						<td>관리자</td>
						<td>${dto.writedate}</td>
						<c:if test="${userinfo.auth eq 'ROLE_A'}">
							<td>${dto.delflag}</td>
						</c:if>
					</tr>
					</c:if>
		 		</c:forEach>
			</table>
		</div>
		<input type="text" name="index" id="index" value="${row.index}">
		<input type="text" name="pageNum" id="pageNum" value="${row.pageNum}"> 
		<input type="text" name="listNum" id="listNum" value="${row.listNum}">

	<div class="center">
				<ul class="pagination">
					<li><a href="#" onclick="pageFirst()">&laquo;</a></li>
					<li><a href="#"
						onclick="pagePre(${row.pageNum},${row.pageList})">&lsaquo;</a></li>
					<c:forEach var='i' begin="${row.pageNum}" end="${row.count}"
						step="1">
						<li><a href="#" onclick="pageIndex(${i})">${i}</a></li>
					</c:forEach>
					<li><a href="#"
						onclick="pageNext(${row.pageNum},${row.total},${row.listNum}, ${row.pageList})">&rsaquo;</a></li>
					<li><a href="#"
						onclick="pageLast(${row.pageNum},${row.total},${row.listNum}, ${row.pageList})">&raquo;</a></li>
				</ul>
			</div>

<!-- 글쓰기 버튼-->
		<div style="text-align: center; margin-top: 20px;">
			<c:if test="${userinfo.auth eq 'ROLE_A'}">
				<input type="submit" class="myButton" value="삭제" >
				<input type="button" class="myButton" value="글쓰기" onclick ="notiBoardWrite()">
			</c:if>
		</div>
		</form>
		
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>

</html>