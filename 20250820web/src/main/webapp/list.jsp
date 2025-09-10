<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table,th,td{
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="dto" items="${list}">
	<tr>
	<td>${dto.empno}</td><td>${dto.ename}</td>
	<td>${dto.sal}</td><td>${dto.deptno}</td>
	<td>${dto.dname}</td><td>${dto.loc}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>