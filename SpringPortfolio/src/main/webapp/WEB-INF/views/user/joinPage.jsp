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
<script type = "text/javascript" charset = "UTF-8">window.name = "joinPage";</script>

	<h2 align = "center">회원가입</h2>

	<form action = "" method = "post" id = "joinForm" name = "joinForm">
		<table align = "center" border = "1" cellspacing ="0">
			
			<tr>
				<c:set var = "checkId" value = "${param.uid}"/>
				<input type = "hidden" id = "tmpCheckId" value = "${checkId}"/>
				
				<c:set var = "checkIdPopupReturn" value = "${param.checkIdPopupReturn}"/>
				<input type = "hidden" id = "checkIdPopupReturn" name = "checkIdPopupReturn" value = "${checkIdPopupReturn}">
				
				<td>아이디</td>
				<td>
					<c:if test = "${empty checkIdPopupReturn || checkIdPopupReturn == false}">
						<input type = "text" name = "uid" id = "uid" placeholder = "아이디를 입력하세요."  value = "${checkId}">
						<input type = "button" value = "중복체크" onclick = "checkId('/join')">
					</c:if>
					<c:if test = "${checkIdPopupReturn == true}">
						<input type = "text" name = "uid" id = "uid" placeholder = "아이디를 입력하세요."  value = "${checkId}" readonly >
						<input type = "button" value = "중복체크" onclick = "checkId('/join')" disabled>
					</c:if>
				</td>
			</tr>
			<tr>	
				<td>비밀번호</td>
				<td>
					<input type = "password" name = "upw" id = "upw" placeholder = "비밀번호를 입력하세요." value = "${param.upw}">
				</td>
			</tr>	
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type = "password" name = "upw_check" id = "upw_check" placeholder = "비밀번호를 확인하세요.">
				</td>
			</tr>
			<tr>
				<c:set var = "checkNick" value = "${param.unick}"/>
				<input type = "hidden" id = "tmpCheckNick" value = "${checkNick}"/>
				
				<c:set var = "checkNickPopupReturn" value = "${param.checkNickPopupReturn}"/> 
				<input type = "hidden" id = "checkNickPopupReturn" name = "checkNickPopupReturn" value = "${checkNickPopupReturn}">
				
				<td>닉네임</td>
				<td>
					<c:if test = "${empty checkNickPopupReturn || checkNickPopupReturn == false}">
						<input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요."  value = "${checkNick}" >
						<input type = "button" value = "중복체크" onclick = "checkNick('/join')">
					</c:if>
					<c:if test = "${checkNickPopupReturn == true}">
						<input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요."  value = "${checkNick}" readonly >
						<input type = "button" value = "중복체크" onclick = "checkNick('/join')" disabled>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td>
					<select name = "phone1" id = "phone1">
						<option value = "010">010
						<option value = "011">011
						<option value = "016">016
						<option value = "017">017
						<option value = "019">019
					</select>
					- <input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone2" id = "phone2" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${param.phone2}"> - <input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone3" id = "phone3" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${param.phone3}">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type = "text" name = "uaddr" id ="uaddr" placeholder = "주소를 입력하세요." value = "${param.uaddr}">
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type = "number" max = "999999" maxlength = "6" oninput="maxLengthCheck(this)" name = "ubirth" id = "ubirth" onkeydown="javascript: return event.keyCode == 69 ? false : true" placeholder = "생년월일6자를 입력하세요.(ex>900805)" value = "${param.ubirth}">
				</td>
			</tr>
			<tr>
				<c:set var ="tmpGender" value = "${param.ugender}"/>
				<td>성별</td>
				<td>
					<c:if test = "${empty tmpGender}">
						<input type = "radio" name = "ugender" value = "m" id = "ugender">남
						<input type = "radio" name = "ugender" value = "w" id = "ugender">여
					</c:if>
					
					<c:if test = "${not empty tmpGender}">
						<c:if test = "${tmpGender == 'm'}">
							<input type = "radio" name = "ugender" value = "m" id = "ugender" checked>남
							<input type = "radio" name = "ugender" value = "w" id = "ugender">여
						</c:if>
						<c:if test = "${tmpGender == 'w'}">
							<input type = "radio" name = "ugender" value = "m" id = "ugender">남
							<input type = "radio" name = "ugender" value = "w" id = "ugender" checked>여
						</c:if>
					</c:if>
					
					
				</td>
			</tr>
			<tr>
				<td align = "center" colspan = "2">
					<input type = "button" value = "회원가입" onclick = "joinConfirm()">
					<input type = "button" value = "취소" onclick = "pageBack()">
				</td>
			</tr>
			
		</table>
	</form>	
	
</body>
</html>