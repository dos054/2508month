<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>
<%
int num = Integer.parseInt(request.getParameter("num"));
System.out.println(num);
Date now = new Date();
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String regtime = sdf.format(now);

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM board where num="+num);
 
    if(rs.next()){
    	out.println(rs.getString("title"));
    }
    
    
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
<form action="updateResult.jsp">
<input type="hidden" name="num" >
<table>
    <tr>
        <th>제목</th>
        <td><input type="text" name="title"></td>
    </tr>
    
    
    <tr>
        <th>작성자</th>
        <td><input type="text" name="writer"></td>
    </tr>
    
    
    <tr>
        <th>작성일시</th>
        <td><input type="hidden" name="regtime"></td>
    </tr>
    
    
    <tr>
        <th>조회수</th>
        <td><input type="text" name="hits"></td>
    </tr>
    
    
    <tr>
        <th>내용</th>
        <td><input type="text" name="content"></td>
    </tr>
</table>
</form>
<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='updateResult.jsp?num=<%=num%>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num%>'">

</body>
</html>
