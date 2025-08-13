<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="navbar.jspf"%>
<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th class="hits">조회수</th>
    </tr>
<c:forEach var ="board" items ="${list }">


<tr>
        <td>${board.num}</td>
        <td style="text-align:left;"><a href="view.jsp?num=${board.num}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td>${board.regtime}</td>
        <td>${board.hits}</td>
    </tr>
    </c:forEach>
   </table> 
    
<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">
    
</body>
</html>

