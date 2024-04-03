package com.kh.practice.professor.model.vo;

import com.kh.practice.department.model.vo.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
	private String no;

	private String name;

	private String ssn;

	private String address;
	
	private String departmentNo;

	private Department department;
}