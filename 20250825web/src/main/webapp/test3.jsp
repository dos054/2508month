<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <p id="demo">원래 테스트입니다.</p>
	<button onclick="changeText()">텍스트변경</button>
	
    <p id="text">이 문장의 색상을 바꿔보세요.</p>
    <button onclick="changeColor()">색상변경</button>

    <script>
      function changeText() {
        document.getElementById("text").innerText= "변경된 텍스트입니다.</h1>";
      }
      
      function changeColor() {
          document.querySeletor("#text").style.color="red";
        }
    </script>
  </body>
</html>