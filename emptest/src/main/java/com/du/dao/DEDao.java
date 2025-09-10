package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.DE;
import com.du.dto.Emp;


public class DEDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	

	public List<DE> selectList() {
		List<DE> list = new ArrayList<DE>();
		DE de = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt 
			= conn.prepareStatement("select empno,ename ,job,mgr,hiredate,sal,comm, deptno from emp");
			rs=stmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate").substring(0,10);
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname").substring(0,10);
				String loc = rs.getString("loc").substring(0,10);
				de = new DE(empno,ename ,job,mgr,hiredate,sal,comm,deptno,dname,loc);
				list.add(de);
			}
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			//자원반납
			try {
				if(rs !=null) rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				System.out.println("리소스를 닫는 도중 오류 발생 : " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}
	
	
	
	
	
}
