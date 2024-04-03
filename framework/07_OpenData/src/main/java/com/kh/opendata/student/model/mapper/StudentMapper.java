package com.kh.opendata.student.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.opendata.student.model.vo.Student;

@Mapper
public interface StudentMapper {

	List<Student> selectAllByDeptNoAndAbsenceYn(@Param("deptNo") String deptNo, @Param("absenceYn") String absenceYn);
	
	int deleteStudent(@Param("studentNo") String studentNo);
}