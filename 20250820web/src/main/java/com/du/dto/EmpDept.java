package com.du.dto;

public class EmpDept {
	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	private String dname;
	private String loc;
	public EmpDept(int empno, String ename, int sal, int deptno, String dname, String loc) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	@Override
	public String toString() {
		return "EmpDept [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + ", dname="
				+ dname + ", loc=" + loc + "]";
	}
	
	
	
	
	
	
	
}
