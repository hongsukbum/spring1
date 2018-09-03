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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/statisticsCommon.js"></script>

	<h2 align = "center">통계</h2>
	
	<!-- <a href = "#" onClick = "goStatistics('1')">1</a>
	<a href = "#" onClick = "goStatistics('2')">2</a>
	<a href = "#" onClick = "goStatistics('3')">3</a> -->
	
	<c:forEach items = "${statistics}" var = "state">
		<a href = "#" onClick = "goStatistics('${state.getStateNum()}')">${state.getStateName()}</a>
	</c:forEach>
	
	</br> ${curState} :: 현재 통계 :: ${today} :: ${todayValue}	/ ${todayTotal}</br>
	
	<c:if test = "${curState == 0}">
		일간 방문자</br>
		<c:forEach items = "${backDay}" var = "day">
			${day.getCutDateTime()} :: ${day.guestView}	/ ${day.totalView}</br> 
		</c:forEach>
	</c:if>
	
	<c:if test = "${curState eq 1}">
		일간 로그인</br>
		<c:forEach items = "${backDay}" var = "day">
			${day.getCutDateTime()} :: ${day.loginView}	/ ${day.totalView} </br>
		</c:forEach>
	</c:if>
	
</body>
</html>