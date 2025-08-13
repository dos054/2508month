<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="study.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Student> list = new ArrayList<>();
list.add(new Student("홍","서울","1234"));
list.add(new Student("감","인천","2323"));
list.add(new Student("별","대구","3434"));
list.add(new Student("전","부산","4545"));

//for(Student stu : list){
//	out.println(stu+"<br/>");
//}
request.setAttribute("list", list);
%>

<c:forEach var="stu" items="${list }" >
${stu.name },${stu.addr }.${stu.phone }<br/>
</c:forEach>
</body>
</html>