<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String email = "";
String checked="";

Cookie[] cookies = request.getCookies();        //쿠키를 가져와라   
if (cookies != null) {							//쿠키가 있다면
    for(Cookie cookie : cookies) {           	//쿠키의 값때까지
        if (cookie.getName().equals("email")) { // 쿠키의 값이 ("")와 같으면
        	email = cookie.getValue();          // 변수의 값에 쿠키의 값을 넣어라
            break;
        }
    }
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="main">
이메일<input type = "text" name="email" value="<%=email%>"/>
기억하기<input type="checkbox" name="remember" checked="<%=checked%>"/>
<input type = "submit"  value ="제출"/>
</form>
</body>
</html>