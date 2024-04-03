package com.kh.opendata.weather.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.opendata.weather.model.mapper.WeatherMapper;
import com.kh.opendata.weather.model.vo.City;
import com.kh.opendata.weather.model.vo.Course;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
	private final WeatherMapper weatherMapper;
	
	@Override
	public List<Course> getCourses() {

		return weatherMapper.selectCourses();
	}

	@Override
	public List<City> getCities() {

		return weatherMapper.selectCities();
	}
}