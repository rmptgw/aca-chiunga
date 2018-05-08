<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<style>
table.type02 {
	border-collapse: separate;
	border-spacing: 0;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type02 th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #fff;
	border-left: 1px solid #fff;
	background: #eee;
}

table.type02 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}
</style>

</head>
<body>
	<center>
		<h1>사원 정보 등록</h1>
		'*' 표시 항목은 필수 입력 항목입니다.
		<form action="join.do" method="post" name="frm">

			<table class="type02">


				<tr>
					<th scope="row">사원명(이름)</th>
					<td><input type="text" name="emp_name" size="20">*</td>
				</tr>


				<tr>
					<th scope="row">아이디</th>
					<td><input type="text" name="emp_id" size="20" id="emp_id">*
						<input type="hidden" name="reid" size="20"> 
						<input type="button" value="중복 체크" onclick="idCheck()">
					</td>
				</tr>

				<tr>
					<th scope="row">비밀번호</th>
					<td><input type="password" name="emp_pass" size="20">*</td>
				</tr>

				<tr>
					<th scope="row">비밀번호 확인</th>
					<td><input type="password" name="pwd_check" size="20">*
						같은 암호를 입력하세요</td>
				</tr>


				<tr>
					<th scope="row">부서명</th>
					<td><input type="text" name="emp_dept" size="20">ex)영업부</td>
				</tr>

				<tr>
					<th scope="row">전화번호</th>
					<td><input type="text" name="emp_phone" size="13">*번호만입력(-제외)</td>
				</tr>

				<tr>
					<th scope="row">이메일</th>
					<td><input type="text" name="emp_email" size="20"></td>
				</tr>

			</table>
			<input type="submit" value="가입완료" onclick="return joinCheck()">
			<input type="reset" value="다시입력" />


		</form>

	</center>
</body>
</html>
