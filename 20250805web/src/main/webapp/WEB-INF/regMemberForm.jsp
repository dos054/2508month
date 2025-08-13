<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 화면</title>
</head>
<body>
<h2>회원 가입</h2>
<table>
<form action = "regMember.jsp" method="get">	
<tr><td>이름 : </td><td><input type ="text" name="kname" autofocus/></td></tr>
<tr><td>주소 : </td><td><input type ="text" name="addr" autofocus/></td></tr>
<tr><td>이메일 : </td><td><input type ="text" name="email" autofocus/></td></tr>
<tr><td>전화번호 : </td><td><input type ="text" name="phone" autofocus/></td></tr>
<tr><td><input type = "submit" value ="목록 추가"/></td><td><input type = "reset" value = "공백"/></td></tr>
</form>

<form action = "regMember.jsp" method="get">
<input type = "submit" value = "목록 보기"/>
</form>
</body>
</table>
</html>