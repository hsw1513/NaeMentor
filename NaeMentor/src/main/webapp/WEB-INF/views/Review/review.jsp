	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/findingMentor/findingMentor.css">
</head>
<!-- google charts -->
       <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var xhr = null;	
	window.onload = function(){
		function chkBtn(){
			var btn1 = document.getElementById("reviewChk");
			var btn2 = document.getElementById("reportChk");
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						if(xhr.responseText == "false"){
							btn1.style.display = "none";
							btn2.style.display = "";
						}else{
							btn1.style.display = "";
							btn2.style.display = "none";
						}
					}
				}
			}
			xhr.open("post","./chkReview.do");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("boardseq="+${boardseq});
		}
		chkBtn();
	}
	
	function chkVal(){
		var stara = document.getElementsByClassName("starVal")[0].value;
		var contenta = document.getElementsByName("content")[0].value;
		if(stara == ''){
			alert('별점을 입력해주세요.');
		}else if(stara < 1 || stara > 5){
			alert('별점은 1-5 사이의 값만 가능합니다.');
		}else if(contenta == ''){
			alert('후기를 작성하세요.');
		}else{
			
			document.getElementsByTagName("form")[0].submit();
		}
	}
	
	
	function insertReview(){
		var hidDiv = document.getElementById("hDiv");
		if(hidDiv.style.display == 'none'){
			hidDiv.style.display = '';
		}else{
			hidDiv.style.display = 'none';
		}
	}
	
	function report(obj, myseq){
		if(confirm('신고할 상대의 회원번호'+obj+"\n 나의 회원번호"+myseq)){
			let singoreason = prompt('신고하시는 이유를 입력해주세요.');
			if(singoreason != ''){
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						if(xhr.responseText == "true"){
							alert('신고되었습니다.');
						}else{
							alert('신고에 실패했습니다.');
						}
					}
				}
			}
			xhr.open("post","./insertReport.do");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("singoedmember="+obj+"&singomember="+myseq+"&boardseq="+${boardseq}+"&auth=${userinfo.auth}&singoreason="+singoreason);
			}else{
				alert('신고내용을 입력해주세요.');
			}
		}
	}
</script>
<body>
<%@include file="/WEB-INF/views/topMenu.jsp"%>
<div id="container">
	   
        <div class="leftdiv">
<c:if test="${userinfo.auth eq 'ROLE_E'}">
<%-- 		<h1>누적별점:${reviews.menteestar}</h1> --%>
<%-- 		<h1>멘토링횟수:${reviews.boardseq}</h1> --%>
		<table>
			<thead>
			<tr>
				<th>별점</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
			</thead>
	<c:forEach var="review" items="${reviews}">
			<tr>
				<td>${review.mentorstar}</td>
				<input type="hidden" name="star1" value="${review.mentorstar}">
				<input type="hidden" name="date" value="${review.writedate}">
				<td>${review.content}</td>
				<td>${review.writedate}</td>
			</tr>
	</c:forEach>
		</table>
</c:if>
<c:if test="${userinfo.auth eq 'ROLE_R'}">
	<%-- 		<h1>누적별점:${reviews.menteestar}</h1> --%>
<%-- 		<h1>멘토링횟수:${reviews.boardseq}</h1> --%>
		<table>
			<thead>
			<tr>
				<th>별점</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
			</thead>
	<c:forEach var="review" items="${reviews}">
			<tr>
				<td>${review.menteestar}</td>
				<input type="hidden" name="star1" value="${review.menteestar}">
				<input type="hidden" name="date" value="${review.writedate}">
				<td>${review.content}</td>
				<td>${review.writedate}</td>
			</tr>
	</c:forEach>
		</table>
</c:if>
	<hr>
	<div>
		<button id="reviewChk" onclick="insertReview()">후기남기기</button>
		<button id="reportChk" onclick="report(${oppositeSeq},${userinfo.memberseq})">신고하기</button>
		<div id="hDiv" style="display:none;">
			<form action="./insertReview.do" method="post">
				<input type="hidden" value="${boardseq}" name="boardseq">
				<c:if test="${userinfo.auth eq 'ROLE_R'}">
				멘티의 별점(1-5사이의 값을 입력하세요.)<input type="number" min="1" max="5" name="menteestar" class="starVal">
				</c:if>
				<c:if test="${userinfo.auth eq 'ROLE_E'}">
				멘토의 별점(1-5사이의 값을 입력하세요.)<input type="number" min="1" max="5" name="mentorstar" class="starVal">
				</c:if>
				<br><textarea name="content" cols="50" rows="3" placeholder="내용"></textarea><br>
				
				<input type="button" onclick="chkVal()" value="입력완료">
			</form>
		</div>
	</div>
	</div>
	
	
	<div class="rightDiv">
		<div id="Line_Controls_Chart">
      <!-- 라인 차트 생성할 영역 -->
          <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
      <!-- 컨트롤바를 생성할 영역 -->
          <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
        </div>
    </div> 
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
<script>
function parse(str) {
	str = str.substr(0,10);
	str = str.split("-");
    var y = str[0];
    var m = str[1];
    var d = str[2];
    return new Date(y,m-1,d);
}
  var chartDrowFun = {
 
    chartDrow : function(){
        var chartData = '';
 
        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat     = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 2;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount    = 2;
 
 
        function drawDashboard() {
 
          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '별점');
 
          //그래프에 표시할 데이터
          var dataRow = [];
 		  let sizeOf = ${fn:length(reviews)};
 		  let stars = document.getElementsByName("star1");
 		  let dates = document.getElementsByName("date");
 		  let starNum = 0;
 		  let dateNum = "";
          for(var i = 0; i < sizeOf; i++){ //이상하게 jquery 셀렉터로 검색하지 않고 자바스크립트로 하면 undefined가 뜨므로 주의
			starNum = $("input[name='star1']").eq(i).val();
			dateNum = $("input[name='date']").eq(i).val();
            dataRow = [parse(dateNum), Number(starNum)];
            data.addRow(dataRow);
          }
 
 
            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height          : 300,
                              width              : '100%',
                              legend          : { position: "top", textStyle: {fontSize: 13}},
                              pointSize        : 5,
                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']}}
                                                                },textStyle: {fontSize:12}},
                vAxis              : {minValue: 5,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation        : {startup: true,duration: 1000,easing: 'in' },
                annotations    : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });
 
            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 80},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });
 
            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);
 
            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);
 
        }
          google.charts.setOnLoadCallback(drawDashboard);
 
      }
    }
  
	
  
$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
});
  </script>
</html>