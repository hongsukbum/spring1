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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>

	<h3 align = "center">구매 내역</h3>
	
	<table border = "1" cellspacing = "0" align = "center">
		<tr align = "center">
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<td>구매자</td>
			</s:authorize>
			<td>상품 이름</td><td>구매 수량</td><td>결제금액</td><td>구매 시간</td><td>상태</td>
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<td>상태변경</td>
			</s:authorize>
		</tr>

		<c:forEach items = "${purchaseBag}" var = "bag" varStatus = "status">
			<s:authorize ifNotGranted = "ROLE_ADMIN">
			<tr align = "center" onclick = "productDetail('${bag.pdb_pdidx}', 'purchaseBag', '${status.index}')">
			</s:authorize>
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
			<tr align = "center">
			</s:authorize>
				<s:authorize ifAnyGranted = "ROLE_ADMIN">
					<td>${bag.pdb_idx} / ${bag.pdb_uid}</td>
				</s:authorize>
				<td>${bag.pd_name}</td><td>${bag.pdb_count}</td>
				<td>
					<script>
						var tmp = parseInt('${bag.pdb_count}') * parseInt('${bag.pd_charge}');
						document.write(addComma(tmp));
					</script>원
				</td>
				<td>${bag.pdb_date}</td>
				<td>${bag.ps_name}</td>
				
				<s:authorize ifAnyGranted = "ROLE_ADMIN">
					<td>
						<select id = "purchaseStatus" name = "purchaseStatus" onchange = "purchaseStatusUpdate('${bag.pdb_idx}')">
							<c:forEach items = "${purchaseStatusList}" var = "status">
								<c:if test = "${status.ps_idx == bag.pdb_state}">
									<option value = "${status.ps_idx}" selected="selected">${status.ps_name}</option>
								</c:if>
								<c:if test = "${status.ps_idx != bag.pdb_state}">
									<option value = "${status.ps_idx}">${status.ps_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</s:authorize>
				
			</tr>
		</c:forEach>
		
	</table>
	
<jsp:include page= "../common/pagingBottom.jsp" flush="false">
	<jsp:param name="paging" value="${paging}"/>
	<jsp:param name= "pageName" value = "${pageName}"/>
</jsp:include>	
	
</body>
</html>