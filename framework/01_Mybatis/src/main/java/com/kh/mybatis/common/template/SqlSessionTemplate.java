package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSession() {
		SqlSession session = null;
		SqlSessionFactoryBuilder builder = null;
		InputStream is = null;
		SqlSessionFactory factory = null;
		
		try {
			// 1. SqlSessionFactoryBuilder 생성
			builder = new SqlSessionFactoryBuilder();
			
			// 2. SqlSessionFactory 생성
			// 마이바티스에서 자원을 좀 더 쉽게 로드할 수 있는 Resources 클래스를 제공한다.
			is = Resources.getResourceAsStream("mybatis-config.xml");
			
//			factory = builder.build(is);
			factory = builder.build(is, "web");
			
			// 3. SqlSession 생성(true: 오토 커밋 활성, false: 오토 커밋 비활성)
			session = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}