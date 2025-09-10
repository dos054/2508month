<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<input type="text" id="nameInput" placeholder = "이름을 입력하세요">
<button id= "printBtn">출력</button>
<p id = "outpit"></p>

<script>
$(document).ready(function() {
	$('#printBtn').click(function() {
		const name = $('#nameInput').val();
		$('#outpit').text('안녕하세요, '+name+'님!');
	});
});
</script>
</body>
</html>