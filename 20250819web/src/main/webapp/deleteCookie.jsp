<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("userId",null);	//쿠키를 생성하는코드에서 null로 값으로 바꾼다
cookie.setMaxAge(0);	//웹브라우저를 종료할 때 쿠키삭제
response.addCookie(cookie);	//쿠키를 바꾼 값으로 저장한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 삭제
</body>
</html>