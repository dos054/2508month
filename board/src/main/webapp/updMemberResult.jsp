<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String mid = request.getParameter("mid");
String kname = request.getParameter("kname");
String addr = request.getParameter("addr");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
Connection conn = null;
Statement stmt = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    int ret = stmt.executeUpdate("update tiny set kname = '"+ kname +"',addr = '"+ addr +"',email = '"+ email +"',phone = '"+ phone +"' where mid=" + mid);
	if (ret == 1) {
		out.println("수정 성공!");
	}
} catch (SQLException e) {
    out.println("데이터베이스 오류: " + e.getMessage());
} catch (ClassNotFoundException e) {
    out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
} finally {
    try {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
    }
}
response.sendRedirect("showMem.jsp");
%>
</body>
</html>