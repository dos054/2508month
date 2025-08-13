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
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String kname = "";
String addr = "";
String email = "";
String phone = "";
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM tiny where mid = " + mid);
    if (rs.next()) {
    	kname = rs.getString("kname");
    	addr = rs.getString("addr");
    	email = rs.getString("email");
    	phone = rs.getString("phone");
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
<form action="updMemberResult.jsp">
<input type="hidden" name="mid" value="<%=mid %>" />
<input type="text" name="kname" value="<%=kname %>" />
<input type="text" name="addr" value="<%=addr %>" />
<input type="text" name="email" value="<%=email %>" />
<input type="text" name="phone" value="<%=phone %>" />
<input type="submit" />
<input type="reset" />
</form>
</body>
</html>