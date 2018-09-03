<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>
	<table align = "center" border="1" cellspacing = "0">
		
		<c:set var = "dto" value="${viewQnaDetail}"></c:set>
		<!--<c:set var = "reply" value="${viewReply}"></c:set> -->
		
		<tr>
			<td>카테고리</td>
			<c:if test="${dto.qna_qnac_idx == 1 }">
				<td>상품</td>
			</c:if>
			<c:if test="${dto.qna_qnac_idx == 2 }">
				<td>배송</td>
			</c:if>
			<c:if test="${dto.qna_qnac_idx == 3 }">
				<td>기타</td>
			</c:if>			
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${dto.qna_title}</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>${dto.qna_content}</td>
		</tr>
				
		
		<c:forEach items="${viewReply}" var="reply">
			<c:if test="${!empty reply}">
				<tr>
					<td>답변</td>
					<td>${reply}</td>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<td>
				<input type = "button" value="목록" onclick="move_qna_list()">
				
				<s:authorize ifAnyGranted="ROLE_USER">
					<input type = "button" value="수정" onclick="qna_modify('${dto.qna_title}','${dto.qna_content}','${dto.qna_idx}','${dto.qna_qnac_idx}')">
				</s:authorize>
				<input type = "button" value="삭제" onclick="qna_remove('${dto.qna_idx}')">
				 
				<s:authorize ifAnyGranted="ROLE_ADMIN">
					<input type = "button" value = "답변하기" onclick="admin_replyWrite('${dto.qna_idx}')">
				</s:authorize>	
			</td>
		</tr>		
	</table>
</body>
</html>