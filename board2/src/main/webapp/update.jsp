<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");
	String kname = request.getParameter("kname");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    background-color: rgb(53,94,169);
	    /* background-color:  #999 ; */
	}
	li {
	    float: left;
	}
	li a, .dropbtn {
	    display: inline-block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	li a:hover, .dropdown:hover .dropbtn {
	    /* background-color: red; */
	    background-color: #6799FF;
	}
	li.dropdown {
	    display: inline-block;
	}
	li a.active, a.active:hover{
	    /* background-color: #4CAF50; */
	    background-color: #6799FF;
	}
	.dropdown-content {
	    display: none;
	    position: absolute;
	    background-color: #f9f9f9;
	    min-width: 160px;
	    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	    z-index: 1;
	}
	.dropdown-content a {
	    color: black;
	    padding: 12px 16px;
	    text-decoration: none;
	    display: block;
	    text-align: left;
	}
	.dropdown-content a:hover {background-color: #f1f1f1}
	.dropdown:hover .dropdown-content {
	    display: block;
	}
</style>
</head>
<body>
<ul>
		  <li><a href="index.jsp">Home</a></li>
		  <li><a href="#mail">메일</a></li>
		  <li><a href="#cafe">카페</a></li>
		  <li><a href="#blog">블로그</a></li>
		  <li><a href="showMem.jsp">회원목록</a></li>
		  <li class="dropdown">
			    <a href="#shopping" class="dropbtn">쇼핑</a>
			    <div class="dropdown-content">
				      <a href="#">가전제품</a>
				      <a href="#">의류/악세사리</a>
				      <a href="#">가방/신발</a>
			    </div>
		  </li>
		  <li class="dropdown">
			    <a href="#new" class="dropbtn">뉴스</a>
			    <div class="dropdown-content">
			      <a href="#">정치</a>
				      <a href="#">경제</a>
				      <a href="#">생활/문화</a>
			    </div>
		  </li>
		  <li style="float:right"><a class="active" href="login.jsp">로그인</a></li>
	</ul>

<%
Connection conn = null;
Statement stmt = null;

ResultSet rs = null;



//
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/du08", "root", "1234");

    stmt = conn.createStatement();
    
    String sql = "SELECT * FROM member";
	String sql2="update member set kname=?,addr=?,email=?,phone=?, where mid=?";
	rs = stmt.executeQuery(sql);
  	
	PreparedStatement ps = conn.prepareStatement(sql);
  	
	ps.setString(1,kname);
	ps.setString(2,addr);
	ps.setString(3,email);
	ps.setString(4,phone);
	ps.setString(5,mid);
	
    while (rs.next()) {
    	mid=rs.getString("mid");
%>

<table>
<tr>
<td><a href="updMemForm.jsp?mid=<%=mid %>"><%=mid %></a></td>
<td><%=rs.getString("kname") %></td>
<td><%=rs.getString("addr") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("phone") %></td>
</tr>
</table>
<%
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
</body>
</html>