<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>do
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <button onclick="addItem()">항목추가</button>
    <ul id="list"></ul>

    <script>
      function addItem() {
        const ul = document.getElementById("list");
        const li = document.createElement("li");
        li.textContent = "새 항목";
        ul.appendChild(li);
      }
    </script>
  </body>
</html>
