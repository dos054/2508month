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
String title = request.getParameter("title");
String writer = request.getParameter("writer");
int hits = Integer.parseInt(request.getParameter("hits"));
String content = request.getParameter("content");

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
    int ret = stmt.executeUpdate("update board set title = '"+ title +"',writer = '"+ writer +"',regtime = '"+ regtime +"',hits = '"+ hits +"', content = '"+ content +"' where num=" + num);
	if (ret == 1) {
		out.println("수정 성공!");
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
response.sendRedirect("list.jsp");
%>
</body>
</html>
