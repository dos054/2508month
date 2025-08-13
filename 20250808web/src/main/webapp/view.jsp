<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="actiontag/navbar.jspf" %>


<%
String num = request.getParameter("num");
String writer = "";
String title = "";
String content = "";
String regtime = "";
String hits = "";

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM board where num="+num);
    if (rs.next()) {
    	writer= rs.getString("writer");
    	title= rs.getString("title");
    	content= rs.getString("content");
    	regtime= rs.getString("regtime");
    	hits= rs.getString("hits");
    }
    stmt.executeUpdate("update board set hits =hits+1 where num= " +num);
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


    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>


<table>
    <tr>
        <th>제목</th>
        <td><%=title %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=writer %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=regtime %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=hits %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=content %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='updateForm.jsp?num=<%=num %>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num %>'">


