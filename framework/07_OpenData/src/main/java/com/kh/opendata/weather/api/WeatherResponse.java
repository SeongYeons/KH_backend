package com.kh.opendata.weather.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
	private String resultCode;
	
	private String resultMsg;
	
	private int pageNo;
	
	private int numOfRows;
	
	private String dataType;
	
	private int totalCount;
	
	private List<WeatherItem> weatherItems = new ArrayList<>();
	
	@JsonProperty("response")
	@SuppressWarnings("unchecked")
	public void unpackResponse(Map<String, Object> response) {
		Map<String, String> header = 
				(Map<String, String>) response.get("header");
		Map<String, Object> body = 
				(Map<String, Object>) response.get("body");
		Map<String, ArrayList<Map<String, Object>>> items = 
				(Map<String, ArrayList<Map<String, Object>>>) body.get("items");
		ArrayList<Map<String, Object>> item = items.get("item");
		
		this.resultCode = header.get("resultCode");
		this.resultMsg = header.get("resultMsg");
		this.pageNo = (Integer) body.get("pageNo");
		this.numOfRows = (Integer) body.get("numOfRows");
		this.dataType = (String) body.get("dataType");
		this.totalCount = (Integer) body.get("totalCount");	
		
		for (Map<String, Object> map : item) {
			WeatherItem weatherItem = new WeatherItem();
			
			weatherItem.setTm((String) map.get("tm"));
	    	weatherItem.setTotalCityName((String) map.get("totalCityName"));
	    	weatherItem.setDoName((String) map.get("doName"));
	    	weatherItem.setCityName((String) map.get("cityName"));
	    	weatherItem.setCityAreaId((String) map.get("cityAreaId"));
	    	weatherItem.setKmaTci((Double) map.get("kmaTci"));
	    	weatherItem.setTciGrade((String) map.get("TCI_GRADE"));
	    	
	    	weatherItems.add(weatherItem);
		}		
	}
}