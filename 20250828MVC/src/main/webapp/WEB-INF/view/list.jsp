<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,th,td{
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>

<table>
<c:forEach var = "dto" items="${list }">
	<tr>
	<td><a href=>${dto.num }</a></td><td>${dto.content }</td>
	</tr>
</c:forEach>
</table>
<button type ="button" onclick="location.href='controllerUsingFile?cmd=list2 ' ">글쓰기</button>
</body> 
</html>