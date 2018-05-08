<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<table align="center" width="550">
			<tr>
				<td colspan="6" align="center">
					<h3>제품 정보</h3>
					<div style="color: red;">${message}</div>
				</td>
			</tr>
			<tr>
				<th align="center">제품번호</th>
				<th align="center">제품명</th>
				<th align="center">가격</th>
				<th align="center">재고량</th>
			</tr>
			<c:forEach var="pro" items="${proList}">
				<tr>
					<td>${pro.pro_no}</td>
					<td><a
						href="OrderServlet?command=pro_view&pro_no=${pro.pro_no}">
							${pro.pro_name}</a></td>
					<td>${pro.pro_price}</td>
					<td>${pro.pro_stock}</td>
				</tr>
			</c:forEach>

			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr align="center">
				<td colspan="6">
				<input type="button" value="메인 페이지로 이동" onclick="location.href='main.jsp'">
			</td>
			</tr>

		</table>
	</div>
</body>
</html>