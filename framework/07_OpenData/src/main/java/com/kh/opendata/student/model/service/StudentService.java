package com.kh.opendata.student.model.service;

import java.util.List;

import com.kh.opendata.student.model.vo.Student;

public interface StudentService {

	List<Student> getStudentsByNoAndAbsenceYn(String deptNo, String absenceYn);

	int delete(String studentNo);

}