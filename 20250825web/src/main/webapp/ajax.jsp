<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <style type="text/css">
table,th,td{
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
  <body>
  <div id="content"></div>
    <div>
      <table id="title"></table>
    </div>
    <button type="button" onclick="loadXMLDocs()">버튼</button>
    <script type="text/javascript">
      // 1. 버튼 클릭시 호출
      function loadXMLDocs() {
        // 2. XMLHttpRequest 객체 생성
        const xmlHttp = new XMLHttpRequest();
        const url = "test.json";
        // 3. 요청 초기화
        xmlHttp.open("GET", url, true);
        // 4. 요청 전송
        xmlHttp.send();
        //---------요청끝---------
        // 5. readyState가 change될 때 이벤트 핸들러 등록
        xmlHttp.onreadystatechange = function () {
          // 6. readyState가 4일때
          if (xmlHttp.readyState == 4) {
            // 7.status가 200일때
            if (xmlHttp.status == 200) {
              // 8. 데이터 가져오기 (responseText)
              const ja = JSON.parse(xmlHttp.responseText);
              
              //document.getElementById("content").innerHTML=xmlHttp.responseText;
              //console.log(xmlHttp.responseText);
              
              //document.getElementById("title").innerHTML = response[0].title;
              //for문으로 읽기 -> table로 만들기
              let tb = ""; //tb = tbody에 들어갈 tr & td
              for (var i = 0; i < ja.length; i++) {
                tb += "<tr>";
                tb += "<td>" + (i + 1) + "</td>";
                tb += "<td>" + ja[i].id + "</td>";
                tb += "<td>" + ja[i].title + "</td>";
                tb += "</tr>";
              }

              //table에 value(innerHTML) 할당
              document.getElementById("title").innerHTML = tb;
            }
          }
        };
      }
    </script>
  </body>
</html>
