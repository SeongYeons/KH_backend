package com.kh.object;

public class Bus extends Vehicle {
	/*
	 * 추상화과정
	 * [1] 필요한 데이터 나열
	 * : 탑승인원, 버스번호, 차량번호, 버스종류, 버스색상, 가격, usb충전여부, 배차간격, 
	 *   출입문 열기, 출입문 닫기, 움직이기, 경적을 울린다, 승객 수 표시, 현재 위치 조회,
	 * [2] 불필요한 정보 제거
	 * : usb충전여부, 가격, 버스색상, 차량번호, 승객 수 표시, 출입문 열기/닫기, ...
	 * [3] 변수 및 메소드 정의
	 */
	int passengerNumber;
	private String busNumber;
	String kind;
	int interval;
//	String melody = "빵빵";	// 경적소리
//	boolean isMove;			// 주행상태	
	
	// busNumber 캡슐화
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	
//	// 움직이기, 경적을 울린다, 현재 위치 조회
//	public void move() { 
//		// 주행상태를 움직이는 것으로 변경
//		//  주행중 : true
//		isMove = true;
//	}
//
//	public void stop() { 
//		// 주행상태를 멈춘 것으로 변경 
//		//  멈춤 : false
//		isMove = false;
//	}
//
//	public boolean checkMove() { 
//		// 주행상태 출력 및 주행상태 반환
//		if(isMove) {
//			System.out.println("주행중 입니다.");
//		} else {
//			System.out.println("멈춘 상태입니다.");
//		}
//		return isMove;
//	}
//	
//	public void setMelody(String melody) { 
//		// 경적소리를 설정 
//		this.melody = melody;
//	}
//
//	public void singingBell() { 
//		// 경적 소리 출력
//		System.out.println(melody);
//	}
	// 현재 위치 조회
	//  결과 값 없이 출력만 => 반환형: void
	public void getCurrLocation() {
		System.out.println("현재 위치는 종로입니다.");
	}
}








