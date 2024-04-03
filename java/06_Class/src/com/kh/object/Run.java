package com.kh.object;

public class Run {

	public static void main(String[] args) {
		
		// Car 객체 생성
		Car carA = new Car();
		
		carA.singingBell();
		carA.setMelody("AAA!");
		carA.singingBell();
		
		System.out.println("==============");
		// Bus 객체 생성
		Bus busA = new Bus();
		busA.singingBell();
		busA.setMelody("BBBB!");
		busA.singingBell();
	}

}







