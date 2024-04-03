package com.kh.opendata.weather.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherItem {
	// 예보 시간
	private String tm;

	// 전체 도시 이름
	private String totalCityName;

	// 도 단위 이름
	private String doName;

	// 시군구 이름
	private String cityName;

	// 시군구 아이디
	private String cityAreaId;

	// 관광 기후지수
	private double kmaTci;

	// 관광 기후지수 등급
	private String tciGrade;
}
