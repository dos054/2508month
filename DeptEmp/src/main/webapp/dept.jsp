<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<form action="insert" method="post">
<input type="hidden" name="isUpdate" value="${isUpdate }"/>
<tr><td>deptno</td><td><input type="text" name="deptno" value = "${dto.deptno }"/></td></tr>
<tr><td>dname</td><td><input type="text" name="dname" value = "${dto.dname }"/></td></tr>
<tr><td>loc</td><td><input type="text" name="loc" value = "${dto.loc }"/></td></tr>
<tr><td>입력/수정</td><td><input type="submit" value="제출"/></td></tr>
</form>
</table>

<table>
<c:forEach var ="dto" items="${list }">
<tr>
<td><a href="updateForm?deptno=${dto.deptno}">${dto.deptno}</a></td><td>${dto.dname}</td><td>${dto.loc}</td>
<td><button type ="button" onclick="location.href='delete?deptno=${dto.deptno }'">삭제</button></td><br/>
</tr>
</c:forEach>
</table>
</body>
</html>