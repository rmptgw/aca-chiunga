<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/cus.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>정보 등록</h1>
		<form name="frm" method="post" action="OrderServlet">
		<input type="hidden" name="command" value="cus_write">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" size="40" maxlength="5" name="cname" > * 필수</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
					<input type="text" size="40" maxlength="11" name="cphone" onkeydown="onlyNumber(cphone)"> * 필수 </td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="40" maxlength="25" name="cemail" > * 필수 </td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
					<input type="text" size="10" name="cpost" maxlength="5" id="cpost" readonly style="background-color: #D8D8D8;">
					<input type="button" value="우편번호검색" onclick="daumPostcode()" > * 필수 				
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
					<input type="text" size="35" id="caddr1" name="caddr1" maxlength="50" onkeyup="call()" readonly style="background-color: #D8D8D8;">
					<input type="text" size="20" id="caddr2" name="caddr2" maxlength="30" onkeyup="call()">
					<input type="hidden" name="caddr" id="caddr">
					 *	필수 </td>
				</tr>				
			</table>
			<br>
			<br>
			<input type="submit" value="등록" onclick="return cusCheck()">
			<input type="reset"	value="다시 작성">
			<input type="button" value="목록" onclick="location.href='CusServlet?command=cus_list'">
		</form>
	</div>
</body>
</html>