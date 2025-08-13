<%@page import="java.time.LocalTime"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="board.Board"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String regtime = LocalDate.now() + " " + LocalTime.now().toString().substring(0,8);
int hits = 0;

Board board= new Board(writer,title,content);

Connection conn = null;
Statement stmt = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");
    stmt = conn.createStatement();
    String sql=String.format("insert into board(writer,title,content,regtime,hits) values('%s','%s','%s','%s','%d')",writer,title,content,regtime,hits);
    stmt.executeUpdate(sql);
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



%>

<jsp:forward page ="insertForm.jsp"/>

</body>
</html>