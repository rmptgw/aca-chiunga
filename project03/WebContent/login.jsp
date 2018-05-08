<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<form action="login.do" method="post">
			<table align="center">
				<tr>
					<td colspan="2" align="center">로그인</td>
				</tr>
				<tr>
					<td align="center">아이디</td>
					<td><input type="text" name="emp_id" value=""></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="emp_pass" value=""></td>
				</tr>

				<tr align="center">
					<td colspan="2"><input type="submit" value="로그인"> <input
						type="reset" value="취소"></td>
				</tr>
			</table>
			<div style="color: red; text-align: center;">${message}</div>
		</form>
	</div>
</body>
</html>