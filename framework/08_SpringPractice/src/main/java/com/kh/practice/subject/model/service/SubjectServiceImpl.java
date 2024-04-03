package com.kh.practice.subject.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.practice.subject.model.mapper.SubjectMapper;
import com.kh.practice.subject.model.vo.Subject;
import com.kh.practice.subject.model.vo.SubjectProfessor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	private final SubjectMapper subjectMapper;

	@Override
	public List<Subject> getSubjectsByDepartmentNo(String departmentNo) {

		return subjectMapper.selectAllByDepartmentNo(departmentNo);
	}

	@Override
	@Transactional
	public int save(Subject subject) {
		int result = 0;
		
		if(subject.getNo() != null) {
			// update
		} else {
			// insert
			result = subjectMapper.insertSubject(subject);
		}
		
		return result;
	}

	@Override
	@Transactional
	public int joinProfessor(String classNo, String professorNo) {
		
		return subjectMapper.insertClassAndProfessor(classNo, professorNo);
	}

	@Override
	public SubjectProfessor getClassProfessor(String classNo, String professorNo) {

		return subjectMapper.selectSubjectProfessor(classNo, professorNo);
	}
}