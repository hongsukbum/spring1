<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>
	<h2 align="center">답변하기</h2>
	<form action="" method="post" id = "admin_replyWrite" name="admin_replyWrite">
		<table align="center" border="1" cellspacing="0">
			<c:set var = "qna_idx" value="${qna_idx}"></c:set>
		
			<tr>
				<td>답변</td>
				<td>
					<textarea rows="10" cols="5" name="ab_content" id="ab_content"></textarea>
				</td>			
			</tr>
			<tr>
				<td>
					<input type="button" value="완료" onclick="admin_replyWriteConfirm('${qna_idx}')">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>