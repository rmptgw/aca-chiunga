<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
	<form action="login.do" method="post" name="frm">
		<table>
			<tr>
				<td colspan="6"><h2>로그인</h2></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="emp_id" value="${emp_id}"></td>
			</tr>
			<tr>
				<th>암 호</th>
				<td><input type="password" name="emp_pass"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp; 
		<input type="reset" value="취소"> &nbsp;&nbsp; 
		<input type="button" value="회원 가입" onclick="location.href='join.do'">
	</form>
	</div>
</body>
</html>