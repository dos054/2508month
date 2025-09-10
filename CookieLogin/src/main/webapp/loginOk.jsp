<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logout" method="post"> <!--8-3.jsp:로그아웃 처리--> 
<c:choose>
<c:when test="${userId == null}">
${param.id}님 로그인1
</c:when>
<c:when test="${userId != null}">
${userId}님 로그인2
</c:when>
</c:choose>
            <br/>
            
            <input type="submit" value="로그아웃"> 
        </form>
</body>
</html>