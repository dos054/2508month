package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.EmpDept;

public class EmpDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring5fs", "root", "1234");
		return conn;
	}
	
	public List<EmpDept> selectEmpDept() {
		List<EmpDept> list = new ArrayList<EmpDept>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select * from emp e, dept d where e.deptno = d.deptno;");
		    while (rs.next()) { 
		    	EmpDept empDept = new EmpDept(rs.getInt("empno"),rs.getString("ename"),rs.getInt("sal"),rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
		    	list.add(empDept);
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
		System.out.println(list);
		
		return list;
	}
}
