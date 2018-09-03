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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/joinCommon.js"></script>
	<c:set var = "checkIdResult" value = "<%=request.getAttribute(\"checkIdResult\")%>"/>
	<c:set var = "checkNickResult" value = "<%=request.getAttribute(\"checkNickResult\")%>"/>

	<h2>중복 체크</h2>
	
	<form name = "joinForm" id = "joinForm">
	
		<c:if test = "${not empty checkIdResult}">
			
			<input type = "hidden" name = "unick" id = "unick" value ="${param.unick}">
			
			
			<c:if test = "${checkIdResult == 0}">
				${param.uid} 사용 가능한 아이디입니다.</br>
				<input type = "hidden" name = "uid" id = "uid" value ="${param.uid}">
				<input type = "button" value ="사용하기" onclick = "usedId(window.name)">
			</c:if>
			
			<c:if test = "${checkIdResult != 0}">
				<input type = "text" name = "uid" placeholder = "아이디를 입력해주세요." required>
				<input type = "button" value = "중복체크" onclick = "checkId(window.name)"></br>
				${param.uid} 사용 불가능한 아이디입니다.
			</c:if>
		</c:if>	
	
		<c:if test = "${not empty checkNickResult}">
			
			<input type = "hidden" name = "uid" id = "uid" value ="${param.uid}">
			
			
			<c:if test = "${checkNickResult == 0}">
				${param.unick} 사용 가능한 닉네임입니다.</br>
				<input type = "hidden" name = "unick" id = "unick" value ="${param.unick}">
				<input type = "button" value ="사용하기" onclick = "usedNick(window.name)">
			</c:if>
			
			<c:if test = "${checkNickResult != 0}">
				<input type = "text" name = "unick" placeholder = "닉네임을 입력해주세요." required>
				<input type = "button" value = "중복체크" onclick = "checkNick(window.name)"></br>
				${param.unick} 사용 불가능한 닉네임입니다.
			</c:if>
		</c:if>	
	
		<!-- 회원가입 폼 기본 데이터 -->
		
		<input type = "hidden" name = "checkNickPopupReturn" id = "checkNickPopupReturn" value = "${param.checkNickPopupReturn}">
		<input type = "hidden" name = "checkIdPopupReturn" id = "checkIdPopupReturn" value = "${param.checkIdPopupReturn}">
		
		<input type = "hidden" name = "upw" id = "upw" value ="${param.upw}">
		<input type = "hidden" name = "phone1" id = "phone1" value ="${param.phone1}">
		<input type = "hidden" name = "phone2" id = "phone2" value ="${param.phone2}">
		<input type = "hidden" name = "phone3" id = "phone3" value ="${param.phone3}">
		<input type = "hidden" name = "uaddr" id = "uaddr" value ="${param.uaddr}">
		<input type = "hidden" name = "ubirth" id = "ubirth" value ="${param.ubirth}">
		<input type = "hidden" name = "ugender" id = "ugender" value ="${param.ugender}">
	
	</form>	
	
</body>
</html>