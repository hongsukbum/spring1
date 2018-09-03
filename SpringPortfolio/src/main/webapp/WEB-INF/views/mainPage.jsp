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
	<h2 align = "center">main page</h2>
	
	<div align = "right">
		<s:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
			${sessionScope.unick}님 어서오세요.</br>
			
			<s:authorize ifAnyGranted = "ROLE_USER">
				<a href = "/productPurchaseBag">구매내역</a>&nbsp&nbsp
				<a href = "/productBag">장바구니</a>&nbsp&nbsp
				<a href = "/userinfoPage">회원 정보</a>&nbsp&nbsp
			</s:authorize>
			
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<a href = "/productPurchaseBag_Admin">구매내역 확인</a>&nbsp&nbsp
				<a href = "/adminAddAccount">관리자 추가</a>&nbsp&nbsp
			</s:authorize>
			
			<a href = "${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
		</s:authorize>
		
		<s:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
			<a href = "/login">로그인</a>
		</s:authorize>
	</div>
	
	<a href = "/product">상품보기</a>
	
	<s:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
		
		<s:authorize ifAnyGranted="ROLE_USER">
			
		</s:authorize>
		<s:authorize ifAnyGranted="ROLE_ADMIN">
			&nbsp&nbsp<a href = "/product_enrollment">상품등록</a></br>
			<a href = "/adminUserInfoList">유저정보</a></br>
		</s:authorize>
		<a href = "/qnalist">고객센터</a></br>
		
		<s:authorize ifAnyGranted="ROLE_ADMIN">
			<a href = "/statistics">통계</a></br>
		</s:authorize>
		
	</s:authorize>
	
	
</body>
</html>