<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
if (cookies!=null){
	for(Cookie cookie : cookies){
	out.println(cookie.getName() + "=");
	out.println(cookie.getValue() + "<br/>");
	}
}

%>
</body>
</html>