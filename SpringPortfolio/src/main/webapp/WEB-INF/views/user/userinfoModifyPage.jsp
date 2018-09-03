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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8">window.name = "modifyPage";</script>
	<h2 align = "center">회원 정보 수정</h2>
	
	<form id = "joinForm" name = "joinForm">
		
		<table align = "center" border ="1" cellspacing="0">
			
			<tr>
				<td>아이디</td>
				<td>${userInfo.uid}</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type = "password" name = "upw" id = "upw" placeholder = "비밀번호를 입력하세요.">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type = "password" name = "upw_check" id = "upw_check" placeholder = "비밀번호를 확인하세요.">
				</td>
			</tr>
			
			<tr>
				
				<c:set var = "checkNickPopupReturn" value = "${param.checkNickPopupReturn}"/>
			
				<td>닉네임</td>
				<td>
					<%-- <input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요." value = "${userInfo.unick}">
					<input type = "button" value = "중복체크" onclick = "checkNick()"> --%>
					
					<c:if test = "${empty checkNickPopupReturn || checkNickPopupReturn == false}">
						<input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요."  value = "${userInfo.unick}" >
						<input type = "button" value = "중복체크" onclick = "checkNick('/userinfoModifyPage')">
					</c:if>
					<c:if test = "${checkNickPopupReturn == true}">
						<input type = "text" name = "unick" id = "unick" placeholder = "닉네임을 입력하세요."  value = "${param.unick}" readonly >
						<input type = "button" value = "중복체크" onclick = "checkNick('/userinfoModifyPage')" disabled>
					</c:if>
					
				</td>
			</tr>
			
			<tr>
				<c:set var = "tmpPH1" value = "${param.phone1}"/>
				<c:set var = "tmpPH2" value = "${param.phone2}"/>
				<c:set var = "tmpPH3" value = "${param.phone3}"/>
				
				<td>핸드폰번호</td>
				<td>
					<c:if test = "${not empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone1" id = "phone1" max = "999" maxlength = "3" oninput="maxLengthCheck(this)" value = "${tmpPH1}">
					</c:if>
					<c:if test = "${empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone1" id = "phone1" max = "999" maxlength = "3" oninput="maxLengthCheck(this)" value = "${userInfo.getPhoneCut(0)}">
					</c:if>
					- 
					<c:if test = "${not empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone2" id = "phone2" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${tmpPH2}">
					</c:if>
					<c:if test = "${empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone2" id = "phone2" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${userInfo.getPhoneCut(1)}">
					</c:if> 
					- 
					<c:if test = "${not empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone3" id = "phone3" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${tmpPH3}">
					</c:if>
					<c:if test = "${empty tmpPH1}">
						<input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone3" id = "phone3" max = "9999" maxlength = "4" oninput="maxLengthCheck(this)" value = "${userInfo.getPhoneCut(2)}">
					</c:if>
				</td>
			</tr>
			<tr>
				<c:set var = "tmpAddr" value = "${param.uaddr}"/>
				<td>주소</td>
				<td>
					<c:if test = "${not empty tmpAddr}">
						<input type = "text" name = "uaddr" id ="uaddr" placeholder = "주소를 입력하세요." value = "${tmpAddr}">
					</c:if>
					<c:if test = "${empty tmpAddr}">
						<input type = "text" name = "uaddr" id ="uaddr" placeholder = "주소를 입력하세요." value = "${userInfo.uaddr}">
					</c:if>
				</td>
			</tr>
			<tr>
				<c:set var = "tmpBirth" value = "${param.ubirth}"/>
				<td>생년월일</td>
				<td>
					<c:if test = "${not empty tmpBirth}">
						<input type = "number" max = "999999" maxlength = "6" oninput="maxLengthCheck(this)" name = "ubirth" id = "ubirth" onkeydown="javascript: return event.keyCode == 69 ? false : true" placeholder = "생년월일6자를 입력하세요.(ex>900805)" value = "${tmpBirth}">
					</c:if>
					<c:if test = "${empty tmpBirth}">
						<input type = "number" max = "999999" maxlength = "6" oninput="maxLengthCheck(this)" name = "ubirth" id = "ubirth" onkeydown="javascript: return event.keyCode == 69 ? false : true" placeholder = "생년월일6자를 입력하세요.(ex>900805)" value = "${userInfo.ubirth}">
					</c:if>
				</td>
			</tr>
			
			<tr>
				<c:set var = "tmpParamGender" value = "${param.ugender}"/>
				
				<c:if test = "${not empty tmpParamGender}">
					<c:set var ="tmpGender" value = "${tmpParamGender}"/>
				</c:if>
				<c:if test = "${empty tmpParamGender}">
					<c:set var ="tmpGender" value = "${userInfo.ugender}"/>
				</c:if>
				
				<td>성별</td>
				<td>
					<c:if test = "${tmpGender == 'm'}">
						<input type = "radio" name = "ugender" value = "m" id = "ugender" checked>남
						<input type = "radio" name = "ugender" value = "w" id = "ugender">여
					</c:if>
					<c:if test = "${tmpGender == 'w'}">
						<input type = "radio" name = "ugender" value = "m" id = "ugender">남
						<input type = "radio" name = "ugender" value = "w" id = "ugender"checked>여
					</c:if>
				</td>
			</tr>
			
			<tr>
				<td align = "center" colspan = "2">
					<input type = "button" value = "정보 수정" onclick = "modifyConfirm('${userInfo.unick}', '${checkNickPopupReturn}')">
					<input type = "button" value = "취소" onclick = "pageModify()">
				</td>
			</tr>
			
		</table>
		
	</form>
	
</body>
</html>