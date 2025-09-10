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

<h2>Add Item</h2>
<input type="text" id="itemName"/>
<button id = "createItem">Add</button>

<h2>아이템 목록</h2>
<ul id="itemList"></ul>

<script>
$(document).ready(function () {
	loadItems2();
});
$('#createItem').on('click', function () {
	let item =$('#itemName').val();
	$.ajax({
		url:'http://localhost:3000/todos',	//여기다가
		type:'post',		//post방식으로 보낸다는것
		data:JSON.stringify({	//stringfy는 json형식으로 한다는것
			title : item
		}),
		contentType:'application/json',		//고정
		success:function(){
			loadItems2();
		}
	});	
});

function loadItems2(){	//함수선언이기 때문에 아직 리스트가 나오지 않음
	$.ajax({
		url: 'http://localhost:3000/todos',
		type: 'GET',
		success: function (data){	//data는 정해진 변수 이름이 아니다
			$('#itemList').empty();	//목록을 한번 지운다
			for(let i=0; i<data.length; i++){	//data에서 반복해서 자료를 꺼내온다.
				let item = data[i];
				
				let listItem = '<li data-id="' + item.id+ '">' +
								item.title +
								'<button class="editBtn">Edit</button>' +
								'<button class="deleteBtn">Delete</button>' +
								'</li>';
								
				$('#itemList').append(listItem);	//리스트에 븥인다.
			}
		}
	});
}
</script>

</body>
</html>