package com.kh.inherit;

public class Bird extends Animal {
	// 변수: (7) =>
//		본인 (3) featherCount, type, maxHeight
//	    부모 (4) eatType, crySound, color, isDanger
	// 메소드: (4) => 
//		본인 (1) getMaxHeight
//		부모 (3) setCrySound, eatFood, showDanger
	// 데이터: 부리, 날개, 깃털개수, 번식종류(0: 알, 1: 새끼, 2: ...)
	//      , 잡식?
	// 기능: 날아다닌다. 어느 높이까지 날수 있는가. ..
	
	// 제거 항목: 부리, 날개, 잡식, 날아다닌다.
	
	int featherCount;		// 깃털 개수
	String type;			// 번식 종류
	double maxHeight;		// 최대 높이
	
	// 날 수 있는 최대 높이 조회 ( 최대 높이값을 전달 )
	public double getMaxHeight() {
		return maxHeight;
	}
	
	// 새의 색상을 출력하는 기능 (printColor)
	//  Animal 멤버 변수 사용: color
	public void printColor() {
		System.out.println("새의 색상은: " + color);
	}
	
	
	// 울음 소리를 출력하는데, 값이 없을 경우 "짹짹"이라고 출력
	// 메소드명 : setCrySound
	// 오버라이딩: 부모클래스의 메소드를 자식 클래스에서 재정의하는 것
	@Override
	public void setCrySound(String crySound) {
		if(crySound == null || crySound.isEmpty()) {
			this.crySound = "짹짹";
		} else {
			// crySound.equals(null) || crySound.isEmpty()
			// <> crySound 값이 null이 아니고 빈 값도 아닐때
			this.crySound = crySound;
		}
	}
}








