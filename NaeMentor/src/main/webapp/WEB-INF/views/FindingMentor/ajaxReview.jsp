<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="reviews2">
	<table class='table table-bordered'>
		<thead>
			<tr>
			<th>작성일</th><th>후기내용</th><th>별점</th></tr>
		</thead>
		<tbody>
			<c:forEach items="${reviewsa}" var="rev">
				<tr>
					<td>${rev.writedate}</td>
					<td>${rev.content}</td>
					<c:if test="${userinfo.auth eq 'ROLE_R'}">
					<td>${rev.menteestar}</td>
					</c:if>
					<c:if test="${userinfo.auth eq 'ROLE_E'}">
					<td>${rev.mentorstar}</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
