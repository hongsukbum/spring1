<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>

	<h2 align = "center">ȸ�� ����</h2>
			
	<table align = "center" border = "1" cellspacing = "0">
		<tr align = "center">
			<td>���̵�</td><td>${detailInfo.uid}</td>
		</tr>
		
		<tr align = "center">
			<td>�г���</td><td>${detailInfo.unick}</td>
		</tr>
			
		<tr align = "center">
			<td>�ڵ�����ȣ</td><td>${detailInfo.uphone}</td>
		</tr>
			
		<tr align = "center">
			<td>�ּ�</td><td>${detailInfo.uaddr}</td>
		</tr>
			
		<tr align = "center">
			<td>�������</td><td>${detailInfo.ubirth}</td>
		</tr>
			
		<tr align = "center">
			<td>����</td>
			<td>
				<c:if test = "${detailInfo.ugender == 'm'}">
					����
				</c:if>
				<c:if test = "${detailInfo.ugender == 'w'}">
					����
				</c:if>
			</td>
		</tr>
			
		<tr align = "center">
			<td>���� �ð�</td><td>${detailInfo.ujoinDate}</td>
		</tr>
			
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "�����" onclick="userban('${detailInfo.uidx}')">
				<input type = "button" value = "�ڷΰ���" onclick="userlist()">
			</td>
		</tr>		
	</table>
</body>
</html>