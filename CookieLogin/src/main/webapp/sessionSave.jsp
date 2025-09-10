<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("userId","hong");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${sessionScope.userId }</p>
<%
String str = (String) session.getAttribute("userId"); 

%>

<%=str %>
세션 저장
</body>
</html>