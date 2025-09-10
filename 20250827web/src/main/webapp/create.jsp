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
<script>
$.ajax({
    url: 'http://localhost:3000/todos', // json-server의 API 주소
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify({ // 전송할 데이터를 JSON 문자열로 변환
        name: '새로운 아이템',
        value: 123
    }),
    success: function(response) {
        console.log('데이터가 성공적으로 추가되었습니다:', response);
    },
    error: function(error) {
        console.error('데이터 추가 중 오류가 발생했습니다:', error);
    }
});
</script>
</body>
</html>