package com.kh.generics;

// 제네릭 클래스 : 클래스명<T, L, M, ...>
public class Point<T, V> {	// 타입 매개변수 2개(T, V)
	// 멤버변수의 타입을 타입 매개변수를 사용하여 선언
	T x;	// T 타입의 x 변수
	V y;	// V 타입의 y 변수
	
	// 생성자
	Point(T x, V y) {	// T타입의 x, V타입의 y 매개변수 정의
		this.x = x;		// 전달받은 x값을 멤버변수 x에 대입
		this.y = y;		// 전달받은 y값을 멤버변수 y에 대입
	}
	
	// getter 메소드
	public T getX() {	// 반환타입: T타입
		return x;
	}
	
	public V getY() {	// 반환타입: V타입
		return y;
	}
}





