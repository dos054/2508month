<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="box"
		style="width:200px; height:200px; background-color:lightgray;"
		onmouseover="hoverBox()"
		onmouseout="resetBox()">
	</div>
	
	<script>
	function hoverBox() {
		document.getElementById("box").style.backgroundColor="orange";
	}
	function resetBox() {
		document.getElementById("box").style.backgroundColor="lightgrey";
	}
	</script>
</body>
</html>