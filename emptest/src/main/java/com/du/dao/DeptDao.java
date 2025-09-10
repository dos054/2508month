package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.Dept;

public class DeptDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public void delete(String deptno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
//			String sql = String.format("delete from dept where deptno=",dept.getDeptno());
			conn = getConnection();
//			stmt =conn.createStatement();
//			stmt.executeUpdate(sql);
			stmt 
			= conn.prepareStatement("delete from dept where deptno=?");
			stmt.setString(1, deptno);
			stmt.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			//자원반납
			try {
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				System.out.println("리소스를 닫는 도중 오류 발생 : " + e.getMessage());
			}
		}
	}
	
	public void insert(Dept dept) {
//		String sql = String.format("insert into dept(deptno, dname, loc) values (%d, '%s', '%s')",dept.getDeptno(),dept.getDname(),dept.getLoc());
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
//			stmt =conn.createStatement();
//			stmt.executeUpdate(sql);
			stmt 
			= conn.prepareStatement("insert into dept(deptno, dname, loc) values (?, ?, ?)");
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			stmt.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			//자원반납
			try {
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				System.out.println("리소스를 닫는 도중 오류 발생 : " + e.getMessage());
			}
			
		}
	}
	
	public void update(Dept dept) {
//		String sql = String.format("update dept set dname='%s', loc='%s'  where deptno= %d",dept.getDname(),dept.getLoc(),dept.getDeptno());
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
//			stmt =conn.createStatement();
//			stmt.executeUpdate(sql);
			stmt 
			= conn.prepareStatement("update dept set dname=?, loc=?  where deptno= ?");
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc());
			stmt.setInt(3, dept.getDeptno());
			stmt.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			//자원반납
			try {
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				System.out.println("리소스를 닫는 도중 오류 발생 : " + e.getMessage());
			}
			
		}
	}
	
	public Dept selectOne(int deptno1) {
		Dept dept = null;
//		String sql = "select deptno, dname,loc from dept where deptno = " + deptno1;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
//			stmt =conn.createStatement();
//			rs= stmt.executeQuery(sql);
			stmt 
			= conn.prepareStatement("select deptno, dname,loc from dept where deptno = ?");
			stmt.setInt(1, dept.getDeptno());
			stmt.executeUpdate();
			
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dept = new Dept(deptno, dname, loc);
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
		return dept;
	}
	
	
	
	public List<Dept> selectList() {
		List<Dept> list = new ArrayList<Dept>();
		Dept dept = null;
		String sql = "select deptno, dname,loc from dept";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
//			stmt =conn.createStatement();
//			rs= stmt.executeQuery(sql);
			stmt 
			= conn.prepareStatement("select deptno, dname,loc from dept");
			rs=stmt.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dept = new Dept(deptno, dname, loc);
				list.add(dept);
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
