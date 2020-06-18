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
<script type="text/javascript" src="./js/NotiBoardPaging.js"></script>
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
				</tr>
		 		<c:forEach var="dto" items="${lists}" varStatus="vs">
		 			<tr>
		 			<c:if test="${userinfo.auth eq 'ROLE_A'}">	
					<td><input type="checkbox" name="chks" value="${dto.adminseq}"></td>
					</c:if>
						<td>${dto.adminseq}</td>
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
					</tr>
		 		</c:forEach>
			</table>
		</div>
		<input type="hidden" name="index" id="index" value="${row.index}">
		<input type="hidden" name="pageNum" id="pageNum" value="${row.pageNum}"> 
		<input type="hidden" name="listNum" id="listNum" value="${row.listNum}">
	<script type="text/javascript">
         var listNum = document.getElementById("listNum").value;
         var list = document.getElementById("list");
      </script>

	<div class="center" style="text-align: center;">
				<ul class="pagination">
					<li><a href="#" onclick="pageFirst()">&laquo;</a></li>
					<li><a href="#"
						onclick="pagePre(${row.pageNum}, ${row.pageList})">&lsaquo;</a></li>
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