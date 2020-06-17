<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function writeBoard(){
		location.href="./writeForm.do";
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	
	<h1>매칭이 되지 않은 게시글들이 있는 영역</h1>
	<!-- 멘티의 영역 -->
	
	<c:if test="${userinfo.auth eq 'ROLE_E'}">
	<button onclick="writeBoard()">글 작성하기</button>
	</c:if>
	
	<table class="table table-hover">
    <thead>
      <tr>
      	<th><input type="checkbox" id="chkall"></th>
        <th>boardseq</th>
        <th>title</th>
        <th>memberseq</th>
        <th>delflag</th>
        <th>reportcnt</th>
        <th>findreporter</th>
        <th>mentorlist</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${board_lists}" var="lists">
	<c:if test="${userinfo.memberseq eq lists.memberseq}">
      <tr>
      	<td><input type="checkbox" value="${lists.boardseq}"></td>
        <td>${lists.boardseq}</td>
        <td><a href='./detailContent.do?boardseq=${lists.boardseq}&memberseq=${lists.memberseq}'>${lists.title}</a></td>
        <td>${lists.memberseq}</td>
        <td>${lists.delflag}</td>
        <td>${lists.reportcnt}</td>
        <td>${lists.findreporter}</td>
        <td>${lists.mentorlist}</td>
      </tr>
       </c:if>
       
       
	<!-- 멘토의 영역 -->
       
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<c:if test="${userinfo.target eq lists.target}">
	
      <tr>
      	<td><input type="checkbox" value="${lists.boardseq}"></td>
        <td>${lists.boardseq}</td>
        <td><a href='./detailContent.do?boardseq=${lists.boardseq}&memberseq=${lists.memberseq}'>${lists.title}</a></td>
        <td>${lists.memberseq}</td>
        <td>${lists.delflag}</td>
        <td>${lists.reportcnt}</td>
        <td>${lists.findreporter}</td>
        <td>${lists.mentorlist}</td>
      </tr>
       </c:if>
       </c:if>
	</c:forEach>
    </tbody>
  </table>
 
 
 <hr>
 <h1>매칭이 된 글들이 위치하는 영역</h1>
 
 
 <!-- 멘티의 영역 -->
	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>boardseq</th>
        <th>title</th>
        <th>memberseq</th>
        <th>delflag</th>
        <th>reportcnt</th>
        <th>findreporter</th>
        <th>mentorlist</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${matching_lists}" var="mlists">
	<c:if test="${userinfo.memberseq eq mlists.memberseq}">
      <tr>
        <td>${mlists.boardseq}</td>
        <td><a href='./detailContent.do?boardseq=${mlists.boardseq}&memberseq=${mlists.memberseq}'>${mlists.title}</a></td>
        <td>${mlists.memberseq}</td>
        <td>${mlists.delflag}</td>
        <td>${mlists.reportcnt}</td>
        <td>${mlists.findreporter}</td>
        <td>${mlists.mentorlist}</td>
      </tr>
       </c:if>
       
       
	<!-- 멘토의 영역 -->
       
	<c:if test="${userinfo.auth eq 'ROLE_R'}">
	
      <tr>
        <td>${mlists.boardseq}</td>
        <td><a href='./detailContent.do?boardseq=${mlists.boardseq}&memberseq=${mlists.memberseq}'>${mlists.title}</a></td>
        <td>${mlists.memberseq}</td>
        <td>${mlists.delflag}</td>
        <td>${mlists.reportcnt}</td>
        <td>${mlists.findreporter}</td>
        <td>${mlists.mentorlist}</td>
      </tr>
       </c:if>
	</c:forEach>
    </tbody>
  </table>
 
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>