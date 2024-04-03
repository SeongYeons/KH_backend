package com.kh.exception;

// 예외 클래스 작성
// [1] Exception 클래스를 상속한다.
public class PWFormatException extends Exception {
	
	// [2] 생성자 정의. 문자열 매개변수를 하나 받는다.
	//				  => 예외 발생 시 표시할 내용
	//				 부모클래스의 생성자를 호출. 
	//						전달받은 값을 인자값으로 전달
	public PWFormatException(String msg) {	// 매개변수 
		super(msg);		// 인자값
	}

}





