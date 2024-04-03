package com.kh.practice.department.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.practice.department.model.vo.Department;

@Mapper
public interface DepartmentMapper {
	List<Department> selectAll();
}
