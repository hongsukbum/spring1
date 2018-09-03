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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>
	<h2 align = "center">고객센터 글쓰기</h2>	
	<form action ="" id="qnaWrite" name="qnaWrite" method="post">
		<table align ="center" border="1" cellspacing ="0">
			<tr>
				<td>카테고리</td>
				<td>
					<select id="select_cate" name="select_cate">
						<c:forEach items="${qna_qnac}" var = "qna_qnac">
							<option value="${qna_qnac.qnac_idx}">${qna_qnac.qnac_name}</option>
						</c:forEach>
					</select>
				<td>제목</td>
				<td>
					<input type="text" name="qna_title" id="qna_title" value = "${qna_title}">
				</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="50" name="qna_content" id="qna_content">${qna_content}</textarea>
				</td>
			</tr>	
		</table>
		<div align = "center">
			<c:if test ="${not empty qna_title}">
				<input type ="button" value="수정" onclick="qna_modify_confirm('${qna_idx}')">
			</c:if>
			<c:if test ="${empty qna_title}">
				<input type ="button" value="완료" onclick="qna_write_confirm()">	
			</c:if>
			
			<input type ="button" value="목록" onclick="move_qna_list()">
		</div>
	</form>
</body>
</html>