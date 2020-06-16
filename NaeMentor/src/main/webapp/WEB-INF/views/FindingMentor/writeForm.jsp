<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	<form action="./insertContent.do" method="post" enctype="multipart/form-data">
		관심분야
		<select name="target">
			<option value="실무">실무</option>
			<option value="취업">취업</option>
			<option value="자격증">자격증</option>
			<option value="취미">취미</option>
			<option value="교육">교육</option>
		</select><br>
		글 제목<input type="text" name="title"><br>
		전문분야
		<select name="specialfield">
			<option value="엑셀">엑셀</option>
			<option value="파워포인트">파워포인트</option>
			<option value="워드,란글(문서)">워드,란글(문서)</option>
			<option value="웹개발">웹개발</option>
			<option value="앱개발">앱개발</option>
			<option value="워드프레스">워드프레스</option>
			<option value="C++">C++</option>
			<option value="C언어">C언어</option>
			<option value="Java">Java</option>
			<option value="C#">C#</option>
			<option value="ASP">ASP</option>
			<option value="Delphi">Delphi</option>
			<option value="ASP.NET">ASP.NET</option>
			<option value="Javascript">Javascript</option>
			<option value="HTML.CSS">HTML.CSS</option>
			<option value="XML">XML</option>
			<option value="Python">Python</option>
			<option value="기타프로그래밍">기타프로그래밍</option>
		</select><br>
		내수준
		<select name="menteelevel">
			<option value="H">상</option>
			<option value="M">중</option>
			<option value="L">하</option>
		</select><br>
		방식
		<select name="howto">
			<option value="Y">대면</option>
			<option value="N">비대면</option>
		</select><br>
		장소<input type="text" name="location"><br>
		일시<input type="date" name="mentoringdate"><br>
		내용<textarea id="editor" rows="20" cols="40" name="content"></textarea><br>	
		<input type="submit" value="작성완료">
	</form>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script type="text/javascript">
window.onload = function(){	
	// ck에디터 설정
	CKEDITOR.replace("editor",
			{filebrowserUploadUrl: "./upload.do",
			 width: "800px"
			});
	}

</script>
</body>
</html>