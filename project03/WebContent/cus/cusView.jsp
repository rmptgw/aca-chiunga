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
				<td colspan="5">${cus.cname}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td colspan="5">${cus.cphone}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="5">${cus.cemail}</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td colspan="5">${cus.cpost}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="5">${cus.caddr}</td>
			</tr>
		</table>
		<br> <br> <input type="button" value="수정"
			onclick="location.href='CusServlet?command=cus_update_form&cno=${cus.cno}'">
		<input type="button" value="삭제"
			onclick="location.href='CusServlet?command=cus_delete&cno=${cus.cno}'">
		<input type="button" value="고객 목록 보기"
			onclick="location.href='CusServlet?command=cus_list'"> 
		<input type="button" value="고객 등록하기"
			onclick="location.href='CusServlet?command=cus_write_form'">
	</div>
</body>
</html>