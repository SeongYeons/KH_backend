package com.kh.practice.professor.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.practice.professor.model.mapper.ProfessorMapper;
import com.kh.practice.professor.model.vo.Professor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
	private final ProfessorMapper professorMapper;
	
	@Override
	public Professor getProfessorByNo(String professorNo) {		
		
		return professorMapper.selectProfessorByNo(professorNo);
	}
	
	@Override
	public List<Professor> getProfessorsByDepartmentNo(String departmentNo) {

		return professorMapper.selectAllByDeptNo(departmentNo);
	}
	
	@Override
	@Transactional
	public int save(Professor professor) {
		int result = 0;
		
		if (professor.getNo() != null) {
			// update
		} else {
			// insert
			result = professorMapper.insertProfessor(professor);
		}
		
		return result;
	}
}