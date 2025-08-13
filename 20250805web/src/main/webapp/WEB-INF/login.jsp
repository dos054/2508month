<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 화면</h2>
<table>
<form action ='list.jsp' method = 'get'>

<tr><td>아이디 : </td><td><input type ="text" name="id" autofocus/></td></tr>
<tr><td>비밀번호 : </td><td><input type ="text" name="password" autofocus/></td></tr>
<tr><td><input type = "submit" value ="확인"><td><input type = "reset" value ="공백"/></td></td></tr>
</form>
</table>
<table>
<form action ='regMemberForm.jsp' method = 'get'>
<tr><td><input type = "submit" value ="회원가입 등록"></td></tr>

</form>
</body>
</table>
</html>