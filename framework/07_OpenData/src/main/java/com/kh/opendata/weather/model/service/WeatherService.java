package com.kh.opendata.weather.model.service;

import java.util.List;

import com.kh.opendata.weather.model.vo.City;
import com.kh.opendata.weather.model.vo.Course;

public interface WeatherService {

	List<Course> getCourses();

	List<City> getCities();

}
