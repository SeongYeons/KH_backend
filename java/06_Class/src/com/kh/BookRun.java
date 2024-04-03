package com.kh;

public class BookRun {
	public static void main(String[] args) {
		int num = 1;
		// Book 클래스 객체 생성
		Book b1 = new Book();
//		b1.title = "어린왕자";
		b1.setTitle("어린왕자");
//		b1.setNumber(num++);
		b1.addNumber();
		System.out.printf("%s (%d)\n", b1.getTitle(), b1.getCurrNumber());
		
		Book b2 = new Book();
		b2.setTitle("수학의 정석");
//		b2.setNumber(num++);
		b2.addNumber();
		System.out.printf("%s (%d)\n", b2.getTitle(), b2.getCurrNumber());
		
		// static 메소드: 객체 생성 없이 바로 호출이 가능하다. 클래스명.메소드명();		
//		Math.random();	//랜덤함수
//		System.arraycopy(b1, num, b2, num, num);	// 배열 복사
	}
}













