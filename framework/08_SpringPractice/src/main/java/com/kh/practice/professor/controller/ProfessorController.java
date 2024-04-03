package com.kh.practice.professor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.practice.department.model.service.DepartmentService;
import com.kh.practice.department.model.vo.Department;
import com.kh.practice.professor.model.service.ProfessorService;
import com.kh.practice.professor.model.vo.Professor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProfessorController {
	private final ProfessorService professorService;
	private final DepartmentService departmentService;
	
	@GetMapping("/professor/search")
	public String search() {
		
		log.info("교수 조회 페이지 요청");
		
		return "professor/search";
	}
	
	@GetMapping("/professors/{professorNo}")
	public ResponseEntity<Map<String, Professor>> professor(@PathVariable String professorNo) {
		Map<String, Professor> map = new HashMap<>();
		
		log.info("Professor No : {}", professorNo);	
		
		map.put("professor", professorService.getProfessorByNo(professorNo));
		
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/professors")
	public ResponseEntity<Map<String, List<Professor>>> professors(@RequestParam String departmentNo) {
		Map<String, List<Professor>> map = new HashMap<>();
		
		map.put("professors", professorService.getProfessorsByDepartmentNo(departmentNo));

		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/professor/enroll")
	public ModelAndView enroll(ModelAndView modelAndView) {
		List<Department> departments = 
				departmentService.getDepartments();
				
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("professor/enroll");
		
		return modelAndView;
	}
	
	@PostMapping("/professors/enroll")
	public ResponseEntity<Map<String, Object>> enroll(@RequestBody Professor professor) {
		int result = 0;
		Map<String, Object> map = new HashMap<>();
				
		result = professorService.save(professor);
		
		map.put("resultCode", result);
		map.put("professor", professor);
		
		return ResponseEntity.ok(map);
	}
}