package com.kh.practice.subject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.practice.department.model.service.DepartmentService;
import com.kh.practice.department.model.vo.Department;
import com.kh.practice.subject.model.service.SubjectService;
import com.kh.practice.subject.model.vo.SubjectProfessor;
import com.kh.practice.subject.model.vo.Subject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SubjectController {
	private final SubjectService subjectService;
	private final DepartmentService departmentService;
	
	@GetMapping("/subject/enroll")
	public ModelAndView enroll(ModelAndView modelAndView) {
		List<Department> departments = 
				departmentService.getDepartments();
		
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("subject/enroll");
		
		return modelAndView;
	}
	
	@GetMapping("/subjects")
	public ResponseEntity<Map<String, List<Subject>>> subjects(@RequestParam String departmentNo) {
		Map<String, List<Subject>> map = new HashMap<>();
		
		log.info("Department No : {}", departmentNo);

		map.put("subjects", subjectService.getSubjectsByDepartmentNo(departmentNo));
		
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/subject/enroll")
	public ModelAndView enroll(ModelAndView modelAndView,
			Subject subject) {
		int result = 0;
		
		result = subjectService.save(subject);
		
		if (result > 0) {
			modelAndView.addObject("msg", "과목이 등록되었습니다.");
		} else {
			modelAndView.addObject("msg", "과목 등록을 실패하였습니다.");			
		}
		
		modelAndView.addObject("location", "/subject/enroll");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/subject/join")
	public ModelAndView join(ModelAndView modelAndView) {
		List<Department> departments = 
				departmentService.getDepartments();
		
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("subject/join");
		
		return modelAndView;
	}
	
	@PostMapping("/subject/join")
	public ModelAndView join(ModelAndView modelAndView,
			@RequestParam String classNo,
			@RequestParam String professorNo) {
		
		int result = 0;
		SubjectProfessor subjectProfessor = null;
		
		log.info("Class No : {}, Professor No : {}", classNo, professorNo);
		
		subjectProfessor = subjectService.getClassProfessor(classNo, professorNo);
		
		if (subjectProfessor == null) {			
			result = subjectService.joinProfessor(classNo, professorNo);
			
			if (result > 0) {			
				modelAndView.addObject("msg", "담당 교수가 지정되었습니다.");
			} else {
				modelAndView.addObject("msg", "담당 교수 지정을 실패했습니다.");			
			}		
		} else {
			modelAndView.addObject("msg", "이미 담당 교수로 지정되었습니다.");						
		}
				
		modelAndView.addObject("location", "/subject/join");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
}