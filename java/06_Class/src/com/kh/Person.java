package com.kh;

public class Person {
	// 이름, 나이, 핸드폰번호
	// 데이터 (인스턴스 변수)
	private String name;	// 이름
	private int age;		// 나이
	private double height;	// 키
	

	// 기능 (인스턴스 메소드)
	// 생성자 : 초기화
	// public Person() {}
	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public Person(String name) {
		this.name = name;
	}
	
	// getter, setter
	// name 변수의 값을 확인
	public String getName() {
		return name;
	}
	// name 변수에 값을 대입
	public void setName(String name) {
		this.name = name;
	}
	
//	public void printInfo() {
//		System.out.printf("%s %d %s\n", name, age, phone);
//	}
}





