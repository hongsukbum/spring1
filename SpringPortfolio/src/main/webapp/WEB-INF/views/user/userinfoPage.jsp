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

<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>

	<h2 align = "center">회원 정보</h2>
	
	<form action = "/userinfoModifyPage" method = "post">
		
		<table align = "center" border = "1" cellspacing = "0">
			
			<tr align = "center">
				<td>아이디</td><td>${userInfo.uid}</td>
			</tr>
			
			<tr align = "center">
				<td>닉네임</td><td>${userInfo.unick}</td>
			</tr>
			
			<tr align = "center">
				<td>핸드폰번호</td><td>${userInfo.uphone}</td>
			</tr>
			
			<tr align = "center">
				<td>주소</td><td>${userInfo.uaddr}</td>
			</tr>
			
			<tr align = "center">
				<td>생년월일</td><td>${userInfo.ubirth}</td>
			</tr>
			
			<tr align = "center">
				<td>성별</td>
				<td>
					<c:if test = "${userInfo.ugender == 'm'}">
						남자
					</c:if>
					<c:if test = "${userInfo.ugender == 'w'}">
						여자
					</c:if>
				</td>
			</tr>
			
			<tr align = "center">
				<td>가입 시간</td><td>${userInfo.ujoinDate}</td>
			</tr>
			
			<tr align = "center">
				<td colspan = "2">
					<input type = "submit" value = "정보 수정">&nbsp&nbsp
					<input type = "button" value = "뒤로가기" onclick="pageMain()">
				</td>
			</tr>
			<%-- 
			<input type = "hidden" name = "userInfo" id = "userInfo" value = "${userInfo}">
			<input type = "hidden" name = "uid" id = "uid" value = "${userInfo.uid}">
			 --%>
		</table>
		
	</form>
	
</body>
</html>