package com.kh.jdbc;

import com.kh.jdbc.practice.JdbcTest;

public class Application {

	public static void main(String[] args) {
//		new JdbcTest().findAll();
//		new JdbcTest().findByCode(30);
//		new JdbcTest().insert("착한회원");
//		new JdbcTest().update(120, "그냥회원", "2023/11/15");
		new JdbcTest().delete(110);
	}
}
