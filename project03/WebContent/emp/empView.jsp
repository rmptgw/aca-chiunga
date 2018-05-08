<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>정보 보기</h1>
		<table>
			<tr>
				<th>이름</th>
				<td colspan="5">${emp.emp_name}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td colspan="5">${emp.emp_id}</td>
			</tr>
			<tr>
				<th>부서</th>
				<td colspan="5">${emp.emp_dept}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="5">${emp.emp_email}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td colspan="5">${emp.emp_phone}</td>
			</tr>
		</table>
		<br> <br> <input type="button" value="수정"
			onclick="location.href='EmpServlet?command=emp_update_form&emp_no=${emp.emp_no}'">
		<input type="button" value="삭제"
			onclick="location.href='EmpServlet?command=emp_delete&emp_no=${emp.emp_no}'">
		<input type="button" value="사원 목록 보기"
			onclick="location.href='EmpServlet?command=emp_list'"> 
		<input type="button" value="사원 등록하기"
			onclick="location.href='EmpServlet?command=emp_write_form'">
	</div>
</body>
</html>