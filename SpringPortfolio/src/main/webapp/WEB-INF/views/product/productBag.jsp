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

	<h2 align = "center">장바구니</h2>
	
	<table border = "1" cellspacing = "0" align = "center">
		<tr>
			<td>상품 이름</td><td>상품 설명</td><td>상품수량</td><td>금액</td><td>구매</td><td>장바구니 삭제</td>
		</tr>
		
		<c:forEach items = "${bagList}" var = "bag" varStatus = "status">
			<tr>	
				<td onclick = "productDetail('${bag.pd_idx}',true, '${status.index}')">${bag.pd_name}</td>
				<td onclick = "productDetail('${bag.pd_idx}',true, '${status.index}')">${bag.pd_title}</td>
				<td>
					<input type = "number" min = 0 max = '${bag.pd_count}' name = "pd_purchase_count" id = "pd_purchase_count" value = 0>
				</td>
				<td>
					<script>document.write(addComma('${bag.pd_charge}'));</script>원
				</td>
				<td>
					<input type = "button" value = "구매하기" onclick = "productPurchase('${bag.pd_idx}', '${bag.pd_count}', true, '${status.index}', '${bag.pd_charge}','${status.index}')">
				</td>
				<td>
					<input type = "button" value ="장바구니 삭제" onclick = "productUserBagDelete('${status.index}','${bag.pd_idx}')">
				</td>
			</tr>
		</c:forEach>
		
	</table>

<jsp:include page= "../common/pagingBottom.jsp" flush="false">
	<jsp:param name="paging" value="${paging}"/>
	<jsp:param name= "pageName" value = "${pageName}"/>
</jsp:include>	
	
	
</body>
</html>