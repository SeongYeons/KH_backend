package com.kh.opendata.department.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.opendata.department.model.vo.Department;

@Mapper
public interface DepartmentMapper {
	List<Department> selectAll();
}
