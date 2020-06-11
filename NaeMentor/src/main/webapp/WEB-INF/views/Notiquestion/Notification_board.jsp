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
<body>
	<%@include file="/WEB-INF/views/topMenu.jsp"%>
	<div id="container">
		<h1>공지사항 게시판</h1>
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
<!-- 			관리자만 보이게-->
		<div style="text-align: center; margin-top: 20px;">
			<c:if test="${userinfo.auth eq 'ROLE_A'}">
				<input type="submit" value="삭제" >
				<input type="button" value="글쓰기" onclick ="notiBoardWrite()">
			</c:if>
		</div>
		</form>
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