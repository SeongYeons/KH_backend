package com.kh.practice.professor.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.practice.professor.model.vo.Professor;

@Mapper
public interface ProfessorMapper {
	Professor selectProfessorByNo(@Param("no") String professorNo);
	
	List<Professor> selectAllByDeptNo(@Param("deptNo") String deptNo);
	
	int insertProfessor(Professor professor);
}
