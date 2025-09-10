<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="input"/>
<div id="content">내용</div>
<button id="btn">클릭</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#btn').click(function() {
		//alert("나온다!");
		$('#content').text($('#input').val());
	});
});
</script>
</body>
</html>