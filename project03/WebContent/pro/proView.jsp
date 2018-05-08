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
</head>
<body>
	<div id="wrap" align="center">
		<h1>정보 보기</h1>
		<table>
			<tr>
				<th>제품명</th>
				<td colspan="5">${pro.pro_name}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td colspan="5">${pro.pro_price}</td>
			</tr>
			<tr>
				<th>재고량</th>
				<td colspan="5">${pro.pro_stock}</td>
			</tr>
		</table>
		<br> <br> <input type="button" value="수정"
			onclick="location.href='ProServlet?command=pro_update_form&pro_no=${pro.pro_no}'">
		<input type="button" value="삭제"
			onclick="location.href='ProServlet?command=pro_delete&pro_no=${pro.pro_no}'">
		<input type="button" value="제품 목록 보기"
			onclick="location.href='ProServlet?command=pro_list'"> 
		<input type="button" value="제품 등록하기"
			onclick="location.href='ProServlet?command=pro_write_form'">
	</div>
</body>
</html>