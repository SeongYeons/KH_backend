package com.kh.opendata.weather.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.opendata.weather.model.vo.City;
import com.kh.opendata.weather.model.vo.Course;

@Mapper
public interface WeatherMapper {
	List<Course> selectCourses();
	
	List<City> selectCities();
}
