<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 게시판</title>
</head>
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		 <h2>1:1 문의</h2>
  		<p>1:1 문의 관리자 페이지입니다. RE: 표시가 없는 곳을 확인해 답글을 달아주세요.</p>
		<form action="./Question_boardMultiDel.do" id="delmChk" method="post" onsubmit="return multiDelChk()">
		<div>
			<table class="table table-hover">
				<tr>
						<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
						<th>글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					<c:if test="${userinfo.auth eq 'ROLE_A'}">	
						<th>삭제여부</th>
					</c:if>
				</tr>
		 		<c:forEach var="dto" items="${lists}" varStatus="vs">
		 			<tr>
					<td><input type="checkbox" name="chks" value="${dto.adminseq}"></td>
						<td>${fn:length(lists) - vs.index}</td>
						<td>
							<a title="${dto.title}" href="./Question_boardDetail.do?adminseq=${dto.adminseq}" style="color: black;">
									<c:choose>
										<c:when test="${fn:length(dto.title)>10 }">
											${fn:substring(dto.title,0,10)}...
										</c:when>
										<c:otherwise>${dto.title}</c:otherwise>
									</c:choose> 
							</a>
						</td>
						<td>${dto.namemberdto.nickname}</td>
						<td>${dto.writedate}</td>
						<td>${dto.delflag}</td>
					</tr>
		 		</c:forEach>
			</table>
		</div>
		
		<!-- 		페이징 관련 -->
		<input type="hidden" name="notiPageindex" id="notiPageindex" value="${row.index}">
			<input type="hidden" name="pageNum" id="notiPageNum"
				value="${row.pageNum}"> <input type="hidden" name="listNum"
				id="notiListNum" value="${row.listNum}">
			<script type="text/javascript">
         var listNum = document.getElementById("listNum").value;
         var list = document.getElementById("list");
//          alert(list.options[listNum/5-1].selected = 'selected');
      </script>
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
		
		
<!-- 		글삭제 -->
			<div style="text-align: center; margin-top: 20px;">
				<input type="submit" class="myButton" value="삭제" >
			</div>
		</form>
		<script type="text/javascript">
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
					 return true;
				   }else{
				      alert("선택된 글이 없습니다.");
				      return false;
				   }
				}
		</script>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>