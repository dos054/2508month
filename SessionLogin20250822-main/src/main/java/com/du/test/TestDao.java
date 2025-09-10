package com.du.test;

import com.du.dao.MemberDao;
import com.du.dto.Member;

public class TestDao {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = dao.isLogin("admin", "1234");
		System.out.println(member);

	}

}
