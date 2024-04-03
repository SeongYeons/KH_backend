package com.kh.object;

// 부모클래스로 사용할 Vihicle
public class Vehicle {
	String melody = "빵빵";	// 경적소리
	boolean isMove;			// 주행상태
	
	public void move() { 
		// 주행상태를 움직이는 것으로 변경
		//  주행중 : true
		isMove = true;
	}

	public void stop() { 
		// 주행상태를 멈춘 것으로 변경 
		//  멈춤 : false
		isMove = false;
	}

	public boolean checkMove() { 
		// 주행상태 출력 및 주행상태 반환
		if(isMove) {
			System.out.println("주행중 입니다.");
		} else {
			System.out.println("멈춘 상태입니다.");
		}
		return isMove;
	}

	public void setMelody(String melody) { 
		// 경적소리를 설정 
		this.melody = melody;
	}

	public void singingBell() { 
		// 경적 소리 출력
		System.out.println(melody);
	}	
}
