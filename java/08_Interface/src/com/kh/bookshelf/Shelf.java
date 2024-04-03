package com.kh.bookshelf;
/*
 * 변수의 초기화
 * (1) 자료형 변수명;
 *     변수명 = 값;
 * (2) 자료형 변수명 = 값;
 */
import java.util.ArrayList;
public class Shelf {
	// 변수.
	// (1) shelf 이름의 ArrayList 사용한 문자열 배열. 
	//     상속받은 클래스(#) 접근 가능.
	protected ArrayList<String> shelf;
	
	// 생성자: 멤버변수 초기화
	// (1) 매개변수 없이. shelf 배열을 초기화.
	public Shelf() {
		shelf = new ArrayList<String>();
	}
	
	// 메소드.
	// (1) shelf 배열 getter 메소드.
	public ArrayList<String> getShelf() {
		return shelf;
	}
	
	// (2) getCount 이름의 shelf 배열의 크기를 결과로 반환해주는 메소드.
	public int getCount() {
		return shelf.size();
	}
}







