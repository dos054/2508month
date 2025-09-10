<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<label for="subject" class="hidden">주제</label>
		<input type="text" id="subject" autofocus>
		<button>추가</button>
	</form>
	<hr>
	<ul id="itemList"></ul>
	
<script type="text/javascript">
function newRegister(){	
	const newItem = document.createElement("li");		//요소 노드 추가
	const subject = document.querySelector("#subject");	//텍스트 필드 가져옴
	const newText = document.createTextNode(subject.value);	//텍스트 필드의 값을 텍스트 노드로 추가
	
	newItem.appendChild(newText);		//텍스트 노드를 요소 노드에 추가
	
	const itemList = document.querySelector("#itemList");	//부모 노드에 가져오기
	itemList.appendChild(newItem);	//새로 만든 요소 노드를 부모 노드에 추가
	
	subject.value="";	//다음 입력을 위해 텍스트 필드 비윰
	subject.focus();	//추가버튼을 눌러도 텍스트필드에 autofocus한 효과
}

document.addEventListener("DOMContentLoaded",function (){	//웹페이지가 로딩되면 실행
	const button = document.querySelector("button");	//버튼 요소 가져오기
	button.addEventListener("click", function(e){	//버튼을 클릭시 실행
		e.preventDefault();	//기본 동작을 막음
		newRegister();		//입력한 내용을 화면에 출력하는 함수 호출
	});
	
	const itemList = document.querySelector("#itemList");	//리스토 요소 가져옴
	itemList.addEventListener("click",(e) => {	//클릭시
		if(e.target.tagName === "LI"){	//클릭한 요소가 li요소이면
			if(confirm("삭제하시겠습니까?")){	//확인 대화상자 표시
				e.target.remove();		//클릭한 요소 삭제
			}
		}
	});
});
	
</script>	
</body>
</html>