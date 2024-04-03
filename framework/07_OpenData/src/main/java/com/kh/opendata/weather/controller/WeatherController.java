package com.kh.opendata.weather.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.kh.opendata.weather.api.WeatherApiClient;
import com.kh.opendata.weather.api.WeatherResponse;
import com.kh.opendata.weather.model.service.WeatherService;
import com.kh.opendata.weather.model.vo.City;
import com.kh.opendata.weather.model.vo.Course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WeatherController {
	private final WeatherApiClient weatherApiClient;
	private final WeatherService weatherService;
	
	@GetMapping("/weather/vilage")
	public ModelAndView vilage(ModelAndView modelAndView) {
		List<Course> courses = weatherService.getCourses();
		
		modelAndView.addObject("courses", courses);
		modelAndView.setViewName("weather/vilage");
		
		return modelAndView;
	}
	
	@GetMapping("/weather/vilages")
	public ResponseEntity<String> vilages(
			@RequestParam(defaultValue = "1") String pageNo,
			@RequestParam(defaultValue = "1") String courseId) throws RestClientException, URISyntaxException {
		String responseText = null;
		
		log.info("Page No : {}, Course ID : {}", pageNo, courseId);
	
		responseText = 
//				weatherApiClient.apiTourStnVilageV1(pageNo, courseId);
				weatherApiClient.apiTourStnVilageV2(pageNo, courseId);
		
		return ResponseEntity.ok(responseText);
	}
	
	@GetMapping("/weather/city")
	public ModelAndView city(ModelAndView modelAndView,
			@RequestParam(defaultValue = "1") String pageNo,
			@RequestParam(defaultValue = "1168000000") String cityAreaId) throws RestClientException, URISyntaxException {
		List<City> cities = weatherService.getCities();
		WeatherResponse response = 
				weatherApiClient.apiCityTour(pageNo, cityAreaId);
		
//		response.setWeatherItems(null);
//		response.getWeatherItems().clear();
		
		modelAndView.addObject("cities", cities);
		modelAndView.addObject("response", response);
		modelAndView.setViewName("weather/city");
	
		return modelAndView;
	}
}