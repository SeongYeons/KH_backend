package com.kh.jdbc.practice;

import java.util.List;

import com.kh.jdbc.dao.MemberGradeDao;
import com.kh.jdbc.vo.MemberGrade;

public class JdbcTest {
	public void findAll() {
		MemberGradeDao dao = new MemberGradeDao();
		List<MemberGrade> grades = dao.findAll();
		
//		for (int i = 0; i < grades.size(); i++) {
//			MemberGrade grade = grades.get(i);
//			
//			System.out.println(grade);
//		}
		
		for (MemberGrade grade : grades) {
			System.out.println(grade);
		}
	}

	public void findByCode(int code) {
		MemberGradeDao dao = new MemberGradeDao();
		MemberGrade grade = dao.findByCode(code);
		
		System.out.println(grade);
	}

	public void insert(String gradeName) {
		MemberGradeDao dao = new MemberGradeDao();
		
		int result = dao.insert(gradeName);
		
		System.out.println("Result : " + result);
	}

	public void update(int gradeCode, String gradeName, String createDate) {
		MemberGradeDao dao = new MemberGradeDao();
		int result = dao.update(gradeCode, gradeName, createDate);
		
		System.out.println("Result : " + result);
	}

	public void delete(int gradeCode) {
		MemberGradeDao dao = new MemberGradeDao();
		int result = dao.delete(gradeCode);
		
		System.out.println("Result : " + result);
	}	
}