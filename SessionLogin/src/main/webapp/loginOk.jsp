<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logout" method="post">  
            <%=(String)session.getAttribute("userName")%>님 로그인
            <input type="submit" value="로그아웃">
        </form>
</body>
</html>