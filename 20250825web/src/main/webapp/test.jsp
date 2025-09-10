<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p id="demo">원래 테스트입니다.</p>
	<button onclick="changeTest()">텍스트변경</button>
	
	<script>
	function changeTest() {
        document.getElementById("demo").innerText= "변경된 텍스트입니다.</h1>";
        document.getElementById("demo").innerHTML= "<h1>변경된 텍스트입니다.</h1>";
      }
	</script>
</body>
</html>