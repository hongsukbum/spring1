<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>

	<h2 align = "center">회원 정보</h2>
			
	<table align = "center" border = "1" cellspacing = "0">
		<tr align = "center">
			<td>아이디</td><td>${detailInfo.uid}</td>
		</tr>
		
		<tr align = "center">
			<td>닉네임</td><td>${detailInfo.unick}</td>
		</tr>
			
		<tr align = "center">
			<td>핸드폰번호</td><td>${detailInfo.uphone}</td>
		</tr>
			
		<tr align = "center">
			<td>주소</td><td>${detailInfo.uaddr}</td>
		</tr>
			
		<tr align = "center">
			<td>생년월일</td><td>${detailInfo.ubirth}</td>
		</tr>
			
		<tr align = "center">
			<td>성별</td>
			<td>
				<c:if test = "${detailInfo.ugender == 'm'}">
					남자
				</c:if>
				<c:if test = "${detailInfo.ugender == 'w'}">
					여자
				</c:if>
			</td>
		</tr>
			
		<tr align = "center">
			<td>가입 시간</td><td>${detailInfo.ujoinDate}</td>
		</tr>
			
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "밴수정" onclick="userban('${detailInfo.uidx}')">
				<input type = "button" value = "뒤로가기" onclick="userlist()">
			</td>
		</tr>		
	</table>
</body>
</html>