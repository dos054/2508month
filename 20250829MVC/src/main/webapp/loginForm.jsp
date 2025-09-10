<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>로그인</title></head>
<body>
<form action ="<%=request.getContextPath() %>/login.jsp">
아이디 <input type="text" name="memberId">
비밀번호 <input type="password" name="password">
로그인 <input type="submit" name="로그인">
</form>
</body>
</html>