<%@page import="dto.TinyDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.TinyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>
<table>
<c:forEach var="dto" items="${list}">
	<tr>
	<td><a href="updateForm?num=${dto.num}">${dto.num}</a></td><td>${dto.content}</td><td><button type="button" onclick="location.href='delete?num=${dto.num}' ">삭제</button></td>
	</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='insertForm' ">글쓰기</button>
</body>
</html>


