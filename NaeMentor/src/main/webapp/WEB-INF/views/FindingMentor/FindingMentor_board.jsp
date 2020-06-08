<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<table class="table table-hover">
    <thead>
      <tr>
      	<th><input type="checkbox" id="chkall"></th>
        <th>boardseq</th>
        <th>title</th>
        <th>memberseq</th>
        <th>delflag</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${board_lists}" var="lists">
      <tr>
      	<td><input type="checkbox" value="${lists.boardseq}"></td>
        <td>${lists.boardseq}</td>
        <td><a href='./detailContent.do?boardseq=${lists.boardseq}&memberseq=${lists.memberseq}'>${lists.title}</a></td>
        <td>${lists.memberseq}</td>
        <td>${lists.delflag}</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>