<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>정말 삭제하시겠습니까?</h5>
	<form name="delete" action="deletes.jsp">
		<table>
			<tr>
				<td>
				<input type="submit" value="삭제"> 
				<input type="button" value="취소" onClick="self.close()"></td>
			</tr>
		</table>
	</form>

</body>
</html>