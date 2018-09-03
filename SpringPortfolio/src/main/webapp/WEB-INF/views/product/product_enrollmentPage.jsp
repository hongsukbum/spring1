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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>
	
	<c:set value = "${productDetail}" var = "dto"/>
	
	<h2 align = "center">상품 등록</h2>
	
	<form name = "productForm" id = "productForm" enctype="multipart/form-data">
	
		<table align = "center" border = "1" cellspacing = "0">
			<tr>
				<td>카테고리</td>
				<td>
					<select name = "pd_pdc_idx" id = "pd_pdc_idx">
						<c:forEach items = "${product_cate}" var = "cate">
							<c:if test = "${not empty dto}">
								<c:if test = "${dto.pd_pdc_idx == cate.pdc_idx}">
									<option value = "${cate.pdc_idx}" selected="selected">${cate.pdc_name}
								</c:if>
								<c:if test = "${dto.pd_pdc_idx != cate.pdc_idx}">
									<option value = "${cate.pdc_idx}">${cate.pdc_name}
								</c:if>
							</c:if>
							<c:if test = "${empty dto}">
								<option value = "${cate.pdc_idx}">${cate.pdc_name}
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>상품 이름</td>
				<td>
					<input type = "text" name ="pd_name" id = "pd_name" value = "${dto.pd_name}">
				</td>
			</tr>
			<tr>
				<td>상품 기본 설명</td>
				<td>
					<input type = "text" name ="pd_title" id = "pd_title" value = "${dto.pd_title}">
				</td>
			</tr>
			<tr>
				<td>상품 상세 설명</td>
				<td>
					<textarea rows="20" cols="40" name = "pd_content" id = "pd_content">${dto.pd_content}</textarea>
				</td>
			</tr>
			<tr>
				<td>상품 이미지</td>
				<td>
					<input type = "file" name ="pd_image" id = "pd_image">
				</td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td>
					<input type = "number" name ="pd_charge" id = "pd_charge" value = "${dto.pd_charge}">
				</td>
			</tr>
			<tr>
				<td>상품 수량</td>
				<td>
					<input type = "number" name ="pd_count" id = "pd_count" value = "${dto.pd_count}">
				</td>
			</tr>
			<tr>
				<td align = "center" colspan = "2">
					<c:if test = "${not empty dto}">
						<input type = "hidden" name = "pd_idx" id ="pd_idx" value = "${dto.pd_idx}">
						<input type = "button" value = "수정" onclick = "productModifyConfirm()">&nbsp&nbsp
					</c:if>
					<c:if test = "${empty dto}">
						<input type = "button" value = "등록" onclick = "productEnrollment()">&nbsp&nbsp
					</c:if>
					
					<input type = "button" value = "취소" onclick = "pageMain()">
				</td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>