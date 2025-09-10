<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${aaa }
<br/>
<!-- <a href="b">명령어 연습</a>	 서블릿에서 "/b"를 가진것으로 넘어가기 위함 -->

<a href="b?val=홍길동">명령어임</a>

<form action="c">
<input type="text" name="nn" />
<input type="text" name="n2" value="${res }"/>	<!-- ${}를 사용해서 서블릿에서 준 값을 받을수있다. -->
<input type="submit"/>
</form>
</body>
</html>