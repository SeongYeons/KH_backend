package com.kh.opendata.student.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.opendata.student.model.mapper.StudentMapper;
import com.kh.opendata.student.model.vo.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	private final StudentMapper studentMapper;
	
	@Override
	public List<Student> getStudentsByNoAndAbsenceYn(String deptNo, String absenceYn) {
				
		return studentMapper.selectAllByDeptNoAndAbsenceYn(deptNo, absenceYn);
	}

	@Override
	@Transactional
	public int delete(String studentNo) {
		
		return studentMapper.deleteStudent(studentNo);
	}
}
