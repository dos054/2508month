<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${"10" + "100"}<br/>

${lst =[1,2,3,4,5 ];''}
${lst.stream().sum() }<br/>

${lst.stream().filter(x->x%2==0.).map(x->x*x).toList() }

</body>
</html>