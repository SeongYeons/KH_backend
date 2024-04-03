package com.kh.practice.professor.model.service;

import java.util.List;

import com.kh.practice.professor.model.vo.Professor;

public interface ProfessorService {

	Professor getProfessorByNo(String professorNo);

	int save(Professor professor);

	List<Professor> getProfessorsByDepartmentNo(String departmentNo);

}
