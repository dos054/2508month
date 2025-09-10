<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<textarea id="textInput" oninput="countChars()" placeholder="글을 입력하세요..."></textarea>
	<p>글자 수: <span id="charCount">0</span></p>
	
	<script>
		function countChars(){
			const text = document.getElementById("textInput").value;
			document.getElementById("charCount").innerText = text.length;
		}
	</script>
</body>
</html>