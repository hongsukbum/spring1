<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/errorCommon.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
	
	<c:if test = "${not empty joinUid}">
		<script>
			noneBack();
		</script>
	</c:if>
	
	<h2 align = "center">로그인 페이지</h2>
	
	<c:url value = "j_spring_security_check" var = "loginUrl"/>
	
	<form action = "${loginUrl}" method = "post">
		
		<c:if test = "${param.ng != null}">
			<c:if test ="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
				<script>popupError("${SPRING_SECURITY_LAST_EXCEPTION.message}");</script>
			</c:if>
		</c:if>
	
		<table align = "center" border = "1" cellspacing = "0">
			<tr>
				<td>아이디</td>
				<td>
					<input type = "text" name = "j_username" id = "j_username" placeholder = "아이디를 입력하세요." value ="${joinUid}" required>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type = "password" name = "j_password" id = "j_password" placeholder = "비밀번호를 입력하세요." required>
				</td>
			</tr>
			<tr>
				<td colspan = "3" align = "center">
					<input type = "submit" value = "로그인">
					<input type = "button" value = "취소" onclick="pageMain()">
					<input type = "button" value = "회원가입 " onclick ="goJoinPage()">
				</td>
			</tr>	
			
		</table>
		
	</form>

</body>
</html>