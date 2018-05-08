<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<table class="mainmenu" align="center">
			<c:if test="${empty loginUser}">	비로그인일때 -->
				<tr>
					<td align="center">
						<h1>일석 삼조</h1><br>
						<h2>주문 관리 시스템</h2>
					</td>
				</tr>
			</c:if>

			<c:if test="${!empty loginUser}"> 로그인 했을때 -->
				<tr>
					<td class="login"><a href="main.jsp">메인</a></td>
					<td class="login">
						<h3>사원관리</h3> <a href="EmpServlet?command=emp_list">사원목록</a> <br>
						<a href="EmpServlet?command=emp_write_form">사원등록</a>
					</td>
					<td class="login">
						<h3>제품관리</h3> <a href="ProServlet?command=pro_list"
						style="text-decoration: none;">제품목록</a><br> <a
						href="ProServlet?command=pro_write_form">제품등록</a>
					</td>

					<td class="login">
						<h3>고객관리</h3> <a href="CusServlet?command=cus_list">고객목록</a><br>
						<a href="CusServlet?command=cus_write_form">고객등록</a>
					</td>
					<td class="login">
						<h3>주문관리</h3> <a href="OrderServlet?command=ord_list">주문목록</a><br>
						<a href="OrderServlet?command=cus_write_form">주문등록</a>
					</td>

				</tr>

			</c:if>
		</table>
	</div>
</body>
</html>