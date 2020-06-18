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
<script type="text/javascript" src="./js/QuestionBoardPaging.js"></script>
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
						<td>${dto.adminseq}</td>
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
			<input type="hidden" name="index" id="index" value="${row.index}">
		<input type="hidden" name="pageNum" id="pageNum" value="${row.pageNum}"> 
		<input type="hidden" name="listNum" id="listNum" value="${row.listNum}">
		<input type="hidden" name="listNum" id="listNum" value="${row.total}">
	<script type="text/javascript">
         var listNum = document.getElementById("listNum").value;
         var list = document.getElementById("list");
      </script>
		<div class="center" style="text-align: center;">
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
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>