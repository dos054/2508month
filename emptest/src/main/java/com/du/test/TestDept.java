package com.du.test;

import java.util.List;

import com.du.dao.empdao;
import com.du.dto.Emp;

public class TestDept {

	public static void main(String[] args) {
		empdao dao = new empdao();
		Emp dept = dao.selectOne(10);
		System.out.println(dept);
		
		List<Emp> list = dao.selectList();
		for(Emp dto : list) {
			System.out.println(dto);
		}
	}

}
