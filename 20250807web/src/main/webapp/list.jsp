<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM board");
    
    

%>


<table>
<tr>
		<th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시 </th>
        <th class="hits">조회수</th>
</tr>

<%
while (rs.next()) { 
    	int num = rs.getInt("num");
    	String title = rs.getString("title");
    	String writer = rs.getString("writer");
    	String regtime = rs.getString("regtime");
    	int hits = rs.getInt("hits");
    	
%>




<tr>
        <td><%=num %></td>
        <td style="text-align:left;">
            <a href="update.jsp?num=<%=num %>"><%=title %></a>
        </td>
        <td><%=writer %></td>
        <td><%=regtime %></td>
        <td><%=hits %></td>
</tr>


<%

}

%>
</table>
<%
} catch (SQLException e) {
    out.println("데이터베이스 오류: " + e.getMessage());
} catch (ClassNotFoundException e) {
    out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
    	if (stmt != null) stmt.close();
        if (conn != null) conn.close();
        
    } catch (SQLException e) {
        out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
    }
}
%>


<br>
<input type="button" value="글쓰기" onclick="location.href='writeForm.jsp'">
</body>
</html>