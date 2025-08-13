<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
<%
request.setCharacterEncoding("utf-8");
String kname = request.getParameter("kname");
String addr = request.getParameter("addr");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String sql =String.format("insert into member(kname,addr,email,phone) values ('%s','%s','%s','%s')",
		kname,addr, email,phone);
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    stmt.executeUpdate(sql);
    
    String sSql = "SELECT * FROM member";
    rs = stmt.executeQuery(sSql);
%>
새로운 회원을 등록했습니다.
<table border =1>
<tr><th>이름</th><th>주소</th><th>이메일</th><th>전화번호</th></tr>
<%while (rs.next()) { %>
<tr><td><%=rs.getString("kname")%></td><td><%=rs.getString("addr")%></td><td><%=rs.getString("email")%></td><td><%=rs.getString("phone")%></td></tr>

<%} %>
</table>
<%

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
response.sendRedirect("login.jsp");		//회원가입 완료하면 로그인 페이지로 넘어간다
%>
</body>
</html>