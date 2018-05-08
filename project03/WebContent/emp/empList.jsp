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
					<a href="EmpServlet?command=emp_write_form">사원 등록</a>
				</td>
			</tr>
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>부서명</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr class="record">
					<td>${emp.emp_no}</td>
					<td><a href="EmpServlet?command=emp_view&emp_no=${emp.emp_no}">
							${emp.emp_name} </a></td>
					<td>${emp.emp_dept}</td>
					<td>${emp.emp_email}</td>
					<td>${emp.emp_phone}</td>
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