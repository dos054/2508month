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
request.setAttribute("sum", 0);
%>
${sum =sum+i}<br/>

<c:forEach var="i" begin="1" end="10">
${sum=sum+i;'' }
</c:forEach>
합계 : ${sum }><br/>

<c:if test="true">
<h1>나온다.</h1>
</c:if>

<c:if test="${param.name == 'bk' and param.name == 20}">
${param.name }입니다. <br/>
${param.age }입니다.
</c:if>

</body>
</html>