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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/joinCommon.js"></script>
<script type = "text/javascript" charset = "UTF-8">window.name = "addAdmin";</script>
	<h2 align = "center">관리자 계정 추가</h2>
	
	<form name = "joinForm" id = "joinForm">
		
		<table align = "center" border = "1" cellspacing = "0">
			
			<tr>
				<c:set var = "checkIdPopupReturn" value = "${param.checkIdPopupReturn}"/>
				<c:set var = "checkId" value = "${param.uid}"/>
				<input type = "hidden" id = "tmpCheckId" value = "${checkId}"/>
				
				<td>아이디</td>
				<td>
					<!-- <input type = "text" name  = "uid" id = "uid"> -->
					
					<c:if test = "${empty checkIdPopupReturn || checkIdPopupReturn == false}">
						<input type = "text" name = "uid" id = "uid" placeholder = "아이디를 입력하세요."  value = "${checkId}">
						<input type = "button" value = "중복체크" onclick = "checkId('/adminAddAccount')">
					</c:if>
					<c:if test = "${checkIdPopupReturn == true}">
						<input type = "text" name = "uid" id = "uid" placeholder = "아이디를 입력하세요."  value = "${checkId}" readonly >
						<input type = "button" value = "중복체크" onclick = "checkId('/adminAddAccount')" disabled>
					</c:if>
					
				</td> 
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type = "password" name  = "upw" id = "upw" placeholder = "비밀번호를 입력하세요.">
				</td> 
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type = "password" name  = "upw_check" id = "upw_check" placeholder = "비밀번호를 확인하세요.">
				</td> 
			</tr>
			
			<tr>
				<td>닉네임</td>
				<td>
					<input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요.">
				</td>
			</tr>
			
			<tr>
				<td align = "center" colspan = "2">
					<input type = "button" value = "회원가입" onclick = "adminConfirm()">&nbsp&nbsp
					<input type = "button" value = "취소" onclick = "pageMain()">
				</td>
			</tr>
			
		</table>
		
	</form>
	
</body>
</html>