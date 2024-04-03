package com.kh.opendata.weather.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherApiClient {
	private final RestTemplate restTemplate;
	private String baseURL 
		= "http://apis.data.go.kr/1360000/TourStnInfoService1/";
	private String serviceKey = "10Ic905cDoGcazdFNT3kGjS2QL3VYLZW%2F3j0vg2F3S2XVimZXis61SzzigBTnKVO9U0j2%2Bc54bTcyXkHbpUldg%3D%3D";
	
	public String apiTourStnVilageV1(String pageNo, String courseId) {
		URL url = null;
		BufferedReader reader = null;
		String currentDate = null;
		StringBuilder urlBuilder = null;
		StringBuilder responseTextBuilder = null;
		HttpURLConnection connection = null;
		
		try {
			urlBuilder = new StringBuilder(baseURL + "getTourStnVilageFcst1");
			currentDate = LocalDate.now()
	//				.format(DateTimeFormatter.BASIC_ISO_DATE);
					.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
					
			urlBuilder.append("?ServiceKey=").append(serviceKey);
			urlBuilder.append("&pageNo=").append(pageNo);
			urlBuilder.append("&numOfRows=").append("10");
			urlBuilder.append("&dataType=").append("JSON");
			urlBuilder.append("&CURRENT_DATE=").append(currentDate);
			urlBuilder.append("&HOUR=").append("0");
			urlBuilder.append("&COURSE_ID=").append(courseId);
			
			log.info("Request URL : {}", urlBuilder.toString());		
		
			url = new URL(urlBuilder.toString());
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			responseTextBuilder = new StringBuilder();
			String line;
			
			while ((line = reader.readLine()) != null) {
				responseTextBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return responseTextBuilder.toString();
	}
	
	public String apiTourStnVilageV2(String pageNo, String courseId) throws RestClientException, URISyntaxException {
		String currentDate = null;
		StringBuilder urlBuilder = null;
		
		urlBuilder = new StringBuilder(baseURL + "getTourStnVilageFcst1");
		currentDate = LocalDate.now()
//				.format(DateTimeFormatter.BASIC_ISO_DATE);
				.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				
		urlBuilder.append("?ServiceKey=").append(serviceKey);
		urlBuilder.append("&pageNo=").append(pageNo);
		urlBuilder.append("&numOfRows=").append("10");
		urlBuilder.append("&dataType=").append("JSON");
		urlBuilder.append("&CURRENT_DATE=").append(currentDate);
		urlBuilder.append("&HOUR=").append("0");
		urlBuilder.append("&COURSE_ID=").append(courseId);
		
		log.info("Request URL : {}", urlBuilder.toString());		
		
		
		return restTemplate.getForObject(new URI(urlBuilder.toString()), String.class);
	}
	
	public WeatherResponse apiCityTour(String pageNo, String cityAreaId) throws RestClientException, URISyntaxException {
		String currentDate = null;
		StringBuilder urlBuilder = null;		
		
		urlBuilder = new StringBuilder(baseURL + "getCityTourClmIdx1");
		currentDate = LocalDate.now().minusDays(2)
				.format(DateTimeFormatter.BASIC_ISO_DATE);
		
		urlBuilder.append("?ServiceKey=").append(serviceKey);
		urlBuilder.append("&pageNo=").append(pageNo);
		urlBuilder.append("&numOfRows=").append("5");
		urlBuilder.append("&dataType=").append("JSON");
		urlBuilder.append("&CURRENT_DATE=").append(currentDate);
		urlBuilder.append("&DAY=").append("4");
		urlBuilder.append("&CITY_AREA_ID=").append(cityAreaId);
		
		log.info("Request URL : {}", urlBuilder.toString());
		
		return restTemplate.getForObject(new URI(urlBuilder.toString()), WeatherResponse.class);
	}
}