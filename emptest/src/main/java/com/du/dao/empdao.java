package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.Emp;


public class empdao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public void delete(String empno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();

			stmt 
			= conn.prepareStatement("delete from emp where empno=?");
			stmt.setString(1, empno);
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
	
	public void insert(Emp emp) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt 
			= conn.prepareStatement("insert into emp(empno,ename ,job,mgr,hiredate,sal,comm,deptno) values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, emp.getEmpno());
			stmt.setString(2, emp.getEname());
			stmt.setString(3, emp.getJob());
			stmt.setInt(4, emp.getMgr());
			stmt.setString(5, emp.getHiredate());
			stmt.setInt(6, emp.getSal());
			stmt.setInt(7, emp.getComm());
			stmt.setInt(8, emp.getDeptno());
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
	
	public void update(Emp emp) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt 
			= conn.prepareStatement("update emp set ename=? ,job=?,mgr=?,hiredate=to_date(?,'yyyy-mm-dd'),sal=?,comm=?,deptno=?  where empno= ?");
			stmt.setString(1, emp.getEname());
			stmt.setString(2, emp.getJob());
			stmt.setInt(3, emp.getMgr());
			stmt.setString(4, emp.getHiredate());
			stmt.setInt(5, emp.getSal());
			stmt.setInt(6, emp.getComm());
			stmt.setInt(7, emp.getDeptno());
			stmt.setInt(8, emp.getEmpno());
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
	
	public Emp selectOne(int empno1) {
		Emp emp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			stmt 
			= conn.prepareStatement("select empno,ename ,job,mgr,hiredate,sal,comm, deptno from emp where empno = ?");
			stmt.setInt(1, empno1);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate").substring(0,10);
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emp = new Emp(empno,ename ,job,mgr,hiredate,sal,comm,deptno);
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
		return emp;
	}
	
	
	
	public List<Emp> selectList() {
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
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
				emp = new Emp(empno,ename ,job,mgr,hiredate,sal,comm,deptno);
				list.add(emp);
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
