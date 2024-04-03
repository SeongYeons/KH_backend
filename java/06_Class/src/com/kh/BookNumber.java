package com.kh;

public class BookNumber {
	int number = 1;
	// (2) static 인스턴스 생성
	private static BookNumber bn = new BookNumber();
	
	// (1) private 생성자
	private BookNumber() {};
	
	// (3) 외부에서 접근 가능한 public 메소드
	public static BookNumber getInstance() {
		return bn;
	}
	
	public int addNumber() {
		return number++;
	}
}
