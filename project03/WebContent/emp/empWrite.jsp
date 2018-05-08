<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
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
		<h1>사원 정보 등록</h1>
		'*' 표시 항목은 필수 입력 항목입니다.
		<form action="EmpServlet" method="post" name="frm">
			<input type="hidden" name="command" value="emp_write">
			<table>
				<tr>
					<th>사원명(이름)</th>
					<td colspan="6"><input type="text" name="emp_name" size="20">*</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td colspan="6">
						<input type="text" name="emp_id" size="20" id="emp_id">*
						<input type="hidden" name="reid" size="20">
						<input type="button" value="중복 체크" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="6"><input type="password" name="emp_pass" size="20">*</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td colspan="6"><input type="password" name="emp_pass_check" size="20">*
						같은 암호를 입력하세요</td>
				</tr>


				<tr>
					<th>부서명</th>
					<td colspan="6"><input type="text" name="emp_dept" size="20">ex)영업부</td>
				</tr>

				<tr>
					<th>전화번호</th>
					<td colspan="6"><input type="text" name="emp_phone" size="13">*번호만입력(-제외)</td>
				</tr>

				<tr>
					<th>이메일</th>
					<td colspan="1"><input type="text" name="emp_email" size="20"></td>
				</tr>
			</table>
			<input type="submit" value="등록완료" onclick="return joinCheck()">
			<input type="reset" value="다시입력">
		</form>
	</div>
</body>
</html>
