package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.du.dto.Member;

public class MemberDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3305/du0821", "root", "1234");
		return conn;
	}
	
	public Member isLogin(String mid, String mpw) {
		Member member = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(String.format("select * from member where id='%s' and pw='%s'",mid, mpw));
		    if (rs.next()) {
		        String id = rs.getString("id");
		        String pw = rs.getString("pw");
		        String name = rs.getString("name");
		        member = new Member(id, pw, name);
		    }
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
		return member;

	}
	
	public void addMember(String id, String pw, String name) {
		Connection conn = null;
		Statement stmt = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("insert into member(id, pw, name) values ('%s', '%s', '%s')",id, pw, name));
	
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {

		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}

	}
}
