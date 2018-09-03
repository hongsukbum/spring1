<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>

	<h1 align = "center">회원 목록</h1>
	
	<table align = "center" border="1" cellspacing="0">
		<s:authorize ifAnyGranted="ROLE_ADMIN">
		</s:authorize>
		
		<tr align="center">
			<td>아이디</td>
			<td>닉네임</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>생일</td>
			<td>성별</td>
			<td>가입일</td>
			<td>밴여부</td>
		</tr>
		
		<c:forEach items="${userlist}" var="view">
		
		<tr align="center" onclick="user_detail('${view.uidx}')">
			<td>${view.uid}</td>
			<td>${view.unick}</td>
			<td>${view.uphone}</td>
			<td>${view.uaddr}</td>
			<td>${view.ubirth}</td>
			<td>${view.ugender}</td>
			<td>${view.ujoinDate}</td>
			<td>${view.enabled}</td>
		</tr>
		</c:forEach>
		<tr align = "right">
			<td colspan = "5">
				<input type="button" value="홈으로" onclick="pageMain()">
			</td>
		</tr>
	</table>
</body>
</html>