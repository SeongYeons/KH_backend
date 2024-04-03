package com.kh.lambda.standard;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class D_Operator {
	/*
	 * Operator
	 *   - Operator 함수적 인터페이스는 매개값과 리턴값이 있는
	 *     apply() 추상 메소드를 가지고 있다.
	 *   - apply() 추상 메소드 주로 매개값을 이용해서 연산하고
	 *     동일한 타입으로 결과를 리턴하는 역할을 한다.
	 */
	
	public void method1() {
		Student student1 = new Student("홍길동", 20, "남자", 70, 80);
		Student student2 = new Student("이몽룡", 25, "남자", 90, 90);
		
		IntBinaryOperator intBinaryOperator;
		
//		intBinaryOperator = (int a, int b) -> {
//			return a + b;
//		};
		
		intBinaryOperator = (a, b) -> a + b;
		
		System.out.println(intBinaryOperator.applyAsInt(10, 20));
		
		IntUnaryOperator intUnaryOperator;
		
//		intUnaryOperator = (int a) -> {
//			return a * a;
//		};
		
		intUnaryOperator = a -> a * a;
		
		System.out.println(intUnaryOperator.applyAsInt(10));
		
		BinaryOperator<Student> binaryOperator;
		
//		binaryOperator = (Student s1, Student s2) -> {
//			return s1.getMathScore() > s2.getMathScore() ? s1 : s2;
//		};
		
		binaryOperator = (s1, s2) -> s1.getMathScore() > s2.getMathScore() ? s1 : s2;
		
		System.out.println(binaryOperator.apply(student1, student2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
