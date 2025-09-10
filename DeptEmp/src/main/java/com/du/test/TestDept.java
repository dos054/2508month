package com.du.test;

import java.util.List;

import com.du.dao.DeptDao;
import com.du.dto.Dept;

public class TestDept {

	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		Dept dept = dao.selectOne(10);
		System.out.println(dept);
		
		List<Dept> list = dao.selectList();
		for(Dept dto : list) {
			System.out.println(dto);
		}
	}

}
