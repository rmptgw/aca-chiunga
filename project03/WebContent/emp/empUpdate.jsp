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
		<h1>사원 정보 수정</h1>
		'*' 표시 항목은 필수 입력 항목입니다.
		<form action="memberUpdate.do" method="post" name="frm">

			<table>


				<tr>
					<th scope="row">사원명(이름)</th>
					<td><input type="text" name="emp_name" size="40" value="${mVo.emp_name}" readonly>*</td>
				</tr>

				<tr>
					<th scope="row">아이디</th>
					<td>
					<input type="text" name="emp_id" size="40" value="${mVo.emp_id}" readonly>* 
					<input type="hidden" name="reid" size="40">
					<input type="button" value="중복 체크"	onclick="idCheck()"></td>
				</tr>

				<tr>
					<th scope="row">비밀번호</th>
					<td><input type="password" name="emp_pass" size="40">*</td>
				</tr>

				<tr>
					<th scope="row">비밀번호 확인</th>
					<td><input type="password" name="pwd_check" size="40">*
						같은 암호를 입력하세요</td>
				</tr>

				<tr>
					<th scope="row">부서명</th>
					<td><input type="text" name="emp_dept" size="40"
						value="${mVo.emp_dept}" readonly>ex)영업부</td>
				</tr>

				<tr>
					<th scope="row">전화번호</th>
					<td><input type="text" name="emp_phone" size="40"
						value="${mVo.emp_phone}">*번호만입력(-제외)</td>
				</tr>

				<tr>
					<th scope="row">이메일</th>
					<td><input type="text" name="emp_email" size="20"
						value="${mVo.emp_email}"></td>
				</tr>

			</table>
			<input type="submit" value="수정완료" onclick="return joinCheck()">
			<input type="reset" value="다시입력" />
		</form>
	</div>
</body>
</html>
