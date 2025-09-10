<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p id="demo">원래 텍스트입니다.</p>
<button id="changeBtn">텍스트 변경</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
	$('#changeBtn').click(function() {
		$('#demo').text($('#changeBtn').text());
	});
});
</script>

</body>
</html>