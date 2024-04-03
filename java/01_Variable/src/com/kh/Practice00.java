package com.kh;

public class Practice00 {
	public static void main(String[] args) {
		// 상수 : 변하지 않는 값 의미
		final int MAX;
		MAX = 100;
		
		System.out.println("상수 MAX : " + MAX);
		
	}
	
	public static void method1() {
		// 기념일 계산
		//  변수를 사용하지 않은 경우
		System.out.println(1000 + 10);  // 10일 후
		System.out.println(1000 / 365); // 기념일 기준 몇 년째?
		System.out.println(1000 * 24);	// 기념일 기준 시간 단위로.
		System.out.println(1000 * 24 * 60);	// 분 단위로.
		System.out.println(1000 * 24 * 60 * 60); // 초 단위로
		
		System.out.println("-----------------");
		//  변수를 사용하면?
		int days = 1002;	// 1000 값을 저장하는 정수형(int)
		int d365 = 365;		// 365 값을 저장하는 정수형(int)
		int h24 = 24;		// 24 값을 저장하는 정수형(int)
		int m60 = 60;		// 60(분) 값을 저장하는 정수형(int)
		int s60 = 60;		// 60(초) 값을 저장하는 정수형(int)
		
		System.out.println(days + 10);  // 10일 후
		System.out.println(days / d365); // 기념일 기준 몇 년째?
		System.out.println(days * h24);	// 기념일 기준 시간 단위로.
		System.out.println(days * h24 * m60);	// 분 단위로.
		System.out.println(days * h24 * m60 * s60); // 초 단위로
	}

	public static void method2() {
		// 변수명 제약사항
		//  1) 자바는 대소문자를 구분한다.
		int level;
		int Level = 0;
		
		level = 10;
		
		System.out.println("level : " + level + ", Level : " + Level);
		
		//  2) 변수의 이름은 숫자로 시작할 수 없다.
		// int 365h;
		
		//  3) $, _ 외에는 특수문자는 사용할 수 없다.
		int $_100 = 100;
		System.out.println("$_100 : " + $_100);
		
		//  4) 키워드(예약어)는 사용할 수 없다.
		double d_314 = 3.14;
	}
}
