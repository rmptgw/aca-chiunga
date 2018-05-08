<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	
	<div id="wrap" align="center">
		
		<h1>고객 목록</h1>
		<table class="list" style="text-align: center;">
			<tr>
				<td colspan="5" style="border: white; text-align: right">
					<a href="CusServlet?command=cus_write_form">정보 등록</a>
				</td>
			</tr>
			<tr>
				<th>고객번호</th>
				<th>이름</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
			<c:forEach var="cus" items="${cusList}">
				<tr class="record">
					<td>${cus.cno}</td>
					<td><a href="CusServlet?command=cus_view&cno=${cus.cno}">
							${cus.cname} </a></td>
					<td>${cus.cpost}</td>
					<td>${cus.caddr}</td>
					<td>${cus.cphone}</td>
					<td>${cus.cemail}</td>
				</tr>
			</c:forEach>
			<tr align="center">
			<td colspan="6">
				<input type="button" value="메인 페이지로 이동" onclick="location.href='main.jsp'">
			</td>
		</tr>
		</table>
	</div>
</body>
</html>