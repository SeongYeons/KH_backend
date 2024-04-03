package com.kh.practice.department.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private String no;

	private String name;

	private String category;

	private String openYn;

	private String capacity;
}