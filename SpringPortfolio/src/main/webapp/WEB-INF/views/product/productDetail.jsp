<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %> <%-- 석범추가 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>

	<c:set var = "dto" value = "${productDetail}"/>
	
	<h1 align = "center">상품 정보</h1>
	
	<h3 align = "center">${dto.pd_name}</h3>
	
	<table border = "1" cellspacing = "0" align = "center">
		
		<tr align = "center">
			<td>가격</td>
			<td><script>document.write(addComma('${dto.pd_charge}'));</script>원</td>
		</tr>
		
		<tr align = "center">
			<td>보유수량</td>
			<td>${dto.pd_count}</td>
		</tr>
		
		<tr align = "center">
			<td>구매수량</td>
			<td>
				<input type = "number" min = 0 max = "${dto.pd_count}" name = "pd_purchase_count" id = "pd_purchase_count" value = "1">
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<상세설명></br>
				${dto.pd_content}
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<img src = "${dto.pd_image_path}/${dto.pd_image}" width = "300"/>
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "구매하기" onclick = "productPurchase('${dto.pd_idx}','${dto.pd_count}',true, '${isCheck}', '${dto.pd_charge}','${index}')">
				
				<c:if test = "${empty isCheck}">
					<input type = "button" value = "장바구니 담기" onclick = "productInputBag('${dto.pd_idx}')">
				</c:if>
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "홈으로" onclick = "pageMain()">
				<input type = "button" value = "뒤로가기" onclick = "pageBack()">
			</td>
		</tr>
		
	</table>
	
	<%-- 석범 추가 --%>
	<%-- 석범 추가 --%>
	<s:authorize ifAnyGranted="ROLE_USER">
	<c:set value="${pd_reply_unick}" var="unick"></c:set>
		<form action="" method="post" id = "userReply" name="userReply">
			<table border = "1" cellspacing = "0" align = "center">
				<tr>
					<td>작성자</td>
					<td>${unick}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="3" cols="32" id="product_reply" name="product_reply"></textarea>
					</td>
				</tr>
				<tr align="right">
					<td>
						<input type="button" value="등록" onclick="reply_confirm('${dto.pd_idx}')">
					</td>
				</tr>
			</table>
		</form>
	</s:authorize>
	
	
	<table align = "center" border="1" cellspacing="0">		
		
		<c:if test = "${not empty viewReplylist}">
			<tr align="center">
				<td>작성자</td>
				<td>작성일</td>
				<td>내용</td>
			</tr>
		</c:if>	
		
		<c:forEach items="${viewReplylist}" var="view">		
			<tr align="center">
				<td>${view.qna_unick}</td>
				<td>${view.qna_date}</td>
				<td>${view.qna_content}</td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>