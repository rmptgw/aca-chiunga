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
</head>
<body>
	<div id="wrap" align="center">
		
			<h1>주문 목록</h1>
			<table class="list" style="text-align: center;">
				<tr>
					<th align="center">주문번호</th>
					<th align="center">고객명</th>
					<th align="center">전화번호</th>
					<th align="center">메일</th>
					<th align="center">작성사원</th>
					<th align="center">주문일자</th>
					<th align="center">주문 상세</th>
				</tr>
				<c:forEach var="ord" items="${ordList}">
					<tr>
						<td>${ord.ord_no}</td>
						<td><a
							href="OrderServlet?command=ord_view&ord_no=${ord.ord_no}">
								${ord.cus_name}</a></td>
						<td>${ord.cus_phone}</td>
						<td>${ord.cus_email}</td>
						<td>${ord.emp_name}</td>
						<td><fmt:formatDate value="${ord.ord_date}" type="date" /></td>
						<td></td>
					</tr>
				</c:forEach>

				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr align="center">
					<td colspan="7"><input type="button" value="메인 페이지로 이동"
						onclick="location.href='main.jsp'"></td>
				</tr>

			</table>
	
	</div>


</body>
</html>