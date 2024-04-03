package com.kh.practice.subject.model.service;

import java.util.List;

import com.kh.practice.subject.model.vo.Subject;
import com.kh.practice.subject.model.vo.SubjectProfessor;

public interface SubjectService {

	List<Subject> getSubjectsByDepartmentNo(String departmentNo);

	int save(Subject subject);

	int joinProfessor(String classNo, String professorNo);

	SubjectProfessor getClassProfessor(String classNo, String professorNo);
}