<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/ord.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>주문 등록</h1>
		<form name="frm" method="post" action="OrderServlet">
			<input type="hidden" name="command" value="ord_write">
			<table>
				<tr>
					<th><input id="allCheck" type="checkbox"
						onclick="allChk(this);" /></th>
					<th>상품명</th>
					<th>수량</th>
					<th>가격</th>
				</tr>
				<c:forEach var="ord" items="${ordList}">
					<tr>
						<td><input ﻿ name="RowCheck" type="checkbox"	value="" /></td>
						<td>${ord.ord_no}</td>
						<td>${ord.cus_no}</td>
						<td>${ord.ord_date}</td>
					</tr>
				</c:forEach>
			</table>
			<br> <br> <input type="submit" value="등록"
				onclick="return cusCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='CusServlet?command=cus_list'">
		</form>
	</div>
</body>
</html>