package com.kh.lambda.standard;

import java.util.function.BiFunction;
import java.util.function.Function;

public class C_Function {
	/*
	 * Function 
	 *   - Function 함수적 인터페이스는 매개값과 리턴값이 있는
	 *     apply() 추상 메소드를 가지고 있다.
	 *   - apply() 추상 메소드는 주로 매개값을 리턴값으로 매핑
	 *     (타입 변환)하는 역할을 한다.
	 */
	
	public void method1() {
		Student student;
		
		student = new Student("홍길동", 20, "남자", 80, 70);
		
		Function<Student, String> function;
		
//		function = (Student s) -> {
//			return s.getName();
//		};
		
//		function = s -> s.getName();
		
		function = Student::getName;
		
		System.out.println(function.apply(student));
		
		BiFunction<String, Integer, Student> biFunction;
		
//		biFunction = (String name, Integer age) -> {
//			return new Student(name, age);
//		};
		
//		biFunction = (name, age) -> new Student(name, age);
		
		biFunction = Student::new;
		
		System.out.println(biFunction.apply("이몽룡", 25));
	}
}
