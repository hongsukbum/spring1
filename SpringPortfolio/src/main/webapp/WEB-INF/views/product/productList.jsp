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

<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>
	
	<h2 align = "center">상품 목록 
		<select name = "pd_pdc_idx" id = "pd_pdc_idx" onchange = "productSelect('pd_pdc_idx','${pageName}')">
			<c:forEach items = "${product_cate}" var = "cate">
				
				<c:if test = "${ selectCate == cate.pdc_idx }">
					<option value = "${cate.pdc_idx}" selected="selected">${cate.pdc_name}</option>
				</c:if>
				<c:if test = "${ selectCate != cate.pdc_idx }">
					<option value = "${cate.pdc_idx}">${cate.pdc_name}</option>
				</c:if>
				
			</c:forEach>
		</select>
	</h2>
	
	<table align = "center" border = "1" cellspacing = "0">
		<tr bgcolor = orange>
			<td>상품이름</td><td>상품설명</td>
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<td>상품수정</td>
				<td>상품삭제</td>
			</s:authorize>
		</tr>
		
		<c:forEach items = "${productList}" var = "dto">
			<tr onclick = "productDetail('${dto.pd_idx}', false, '')">
				<td>${dto.pd_name}</td><td>${dto.pd_title}</td>
				<s:authorize ifAnyGranted = "ROLE_ADMIN">
					<td>
						<input type = "button" value = "상품수정" onclick = "productModify('${dto.pd_idx}')">
					</td>
					<td>
						<input type = "button" value = "상품삭제" onclick ="productDelete('${dto.pd_idx}')">
					</td>
				</s:authorize>
			</tr>
		</c:forEach>
		
	</table>

<jsp:include page= "../common/pagingBottom.jsp" flush="false">
	<jsp:param name="paging" value="${paging}"/>
	<jsp:param name= "pageName" value = "${pageName}"/>
	<jsp:param name="selectCate" value ="${selectCate}"/>
</jsp:include>	
	
</body>
</html>