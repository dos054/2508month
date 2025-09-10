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

	<form action="">
		<label for="subject" class="hidden">주제</label>
		<input type="text" id="subject" autofocus>
		<button id='btn'>추가</button>
	</form>
	<hr>
	<ul id="itemList"></ul>

<script type="text/javascript">
$(document).ready(function() {
	$('#btn').click(function(e) {	//버튼요소 가져오기 및 클릭시 실행
		e.preventDefault();	//기본 동작을 막음
		$('#itemList').append('<li>'+$('#subject').val()+'</li>');
		$('#subject').val('');
	});
	$('#itemList').click(function(e) {
		if(confirm("삭제하시겠습니까?")){	//확인 대화상자 표시
			e.target.remove();		//클릭한 요소 삭제
		}
	});
});
</script>	
</body>
</html>