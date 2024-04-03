package com.kh.object;

import java.util.ArrayList;

// Cloneable 이라는 인터페이스와 구현 관계를 정의
class MyBook implements Cloneable {
	String title;		// 제목
	
	// 생성자: 문자열변수 title을 전달받아, 멤버변수 title에 대입
	public MyBook(String title) {
		this.title = title;
	}
	// title 변수의 setter 메소드
	public void setTitle(String title) {
		this.title = title;
	}
	
	// toString 이름의 메소드는 title 값을 반환해주는 기능을 제공
	public String toString() {
		return title;
	}
	// clone 이라는 메소드를 오버라이딩 ?
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}

public class ObjectArrayClone {

	public static void main(String[] args) {
		
		ArrayList<MyBook> bookList = new ArrayList<MyBook>();
		
		MyBook book1 = new MyBook("이웃집 백만장자");
		MyBook book2 = new MyBook("객체지향의 사실과 오해");
		MyBook book3 = new MyBook("삼국지");
		
		bookList.add(book1);	// new MyBook("이웃집 백만장자")
		bookList.add(book2);	// new MyBook("객체지향의 사실과 오해")
		bookList.add(book3);
		
		ArrayList<MyBook> copyList = (ArrayList)bookList.clone();
		// 책제목을 추가하는데 인스턴스 자체를 추가.
		copyList.add(new MyBook("잠"));
		
		System.out.println(bookList);
		System.out.println(copyList);
		
		System.out.println("-------------------------");
		
		book3.setTitle("자바의 정석");
		System.out.println(bookList);
		System.out.println(copyList);
	}

}








