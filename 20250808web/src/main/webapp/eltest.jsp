<%@page import="study.Student"%>
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

Student stu=new Student("홍길동","성남시","010-1234-2345");
request.setAttribute("hong", stu);


%>
<h1>${hong}</h1>
<h1>${hong.name}</h1>
<h1>${hong.addr}</h1>
<h1>${hong.phone}</h1>

</body>
</html>