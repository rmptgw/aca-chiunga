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
		<form action="ProServlet" method="post">
			<input type="hidden" name="command" value="pro_write">
			<table align="center" width="550">
				<tr>
					<td colspan="2" align="center">제품등록</td>
				</tr>
				<tr>
					<td align="center">제품명</td>
					<td><input type="text" name="pro_name"></td>
				</tr>
				<tr>
					<td align="center">제품가격</td>
					<td><input type="text" name="pro_price"></td>
				</tr>
				<tr>
					<td align="center">제품수량</td>
					<td><input type="text" name="pro_stock"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소"> 
						<input type="button" value="목록으로 이동"
							onclick="location.href='ProServlet?command=product_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>