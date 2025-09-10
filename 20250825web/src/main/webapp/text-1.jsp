<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <style>
* {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
.container {
width: 500px;
height: 300px;
border: 1px solid #222;
}
  </style>
  
  <body>
  <div class="container1">
  
  </div>
  
    <div class="container">
    <img alt="" src ="images/cat.jpg" id="cat">
    	<h1 onclick="method()" id="test">안녕</h1>
    	<h1 id="heading">에디오피아 게뎁</h1>
    	<img src="images/coffee-pink.jpg" alt="커피잔" id="cup" width="200" height="200">
    </div>


    <script type="text/javascript">
    let container =document.querySelector(".container");
    container.onclick = (event)=> {
    	alert(`이벤트 발생 위치: ${event.pageX}, ${event.pageY}`);
    }
      const cat = document.querySelector('#cat');
      //cat.onclick = () =>alert("클릭!");
      cat.onclick = changePic;
      function changePic() {
    	  cat.src = "images/kitty-2.png";
      }
      
      let heading = document.querySelector('#heading');
      console.log(heading);
      
      let cup = document.querySelector('#cup');
      console.log(heading);
      
      heading.onclick =() =>heading.innerText='추천! 오늘의 커피';
      cup.onclick=() =>cup.src = "images/coffee-blue.jpg";
      
      let test = document.querySelector('#test');
      function method() {
    	  test.innerText = '나온다!'
      }
    </script>
  </body>
</html>
