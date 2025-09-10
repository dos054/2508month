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

<button id="addItemBtn">항목 추가</button>
<ul id="list"></ul>

<script>
$(document).ready(function() {
	$('#addItemBtn').click(function() {
		$('#list').append('<li>새 항목</li>');
	});
});
</script>
</body>
</html>