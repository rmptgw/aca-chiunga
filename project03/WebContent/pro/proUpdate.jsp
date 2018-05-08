<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>제품 수정</h1>
		<form name="frm" method="post" action="ProServlet">
			<input type="hidden" name="command" value="pro_update">
			<input type="hidden" name="pro_no" value="${pro.pro_no}">
			<table>
				
				<tr>
				<th>제품명</th>
				<td><input type="text" size="40" maxlength="20" name="pro_name" value="${pro.pro_name}">* 필수</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" size="40" maxlength="20" name="pro_price" value="${pro.pro_price}">* 필수</td>
			</tr>
			<tr>
				<th>재고량</th>
				<td><input type="text" size="40" maxlength="20" name="pro_stock" value="${pro.pro_stock}">* 필수</td>
			</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="수정">
			<input type="reset" value="다시 작성"> 
			<input type="button" value="목록" onclick="location.href='ProServlet?command=pro_list'">
		</form>
	</div>
</body>
</html>