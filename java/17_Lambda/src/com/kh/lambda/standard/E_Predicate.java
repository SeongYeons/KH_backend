package com.kh.lambda.standard;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class E_Predicate {
	/*
	 * Predicate
	 *   - Predicate 함수적 인터페이스는 매개변수와 논리값을 리턴하는 test()
	 *     추상 메소드를 가지고 있다.
	 *   - test() 추상 메소드는 매개값을 받아서 true/false를 리턴하는 역할을 한다.
	 */
	public void method1() {
		Student student1 = new Student("홍길동", 20);
		Student student2 = new Student("성춘향", 20, "여자", 90, 90);
		
		Predicate<Student> predicate;
		
//		predicate = (Student s) -> {
//			return s.getGender().equals("남자");
//		};
		
		predicate = s -> s.getGender().equals("남자");
		
		System.out.println(predicate.test(student1)); // true
		System.out.println(predicate.test(student2)); // false
		
		BiPredicate<Student, Student> biPredicate;
		
//		biPredicate = (Student s1, Student s2) -> {
//			return s1.getGender().equals(s2.getGender());
//		};
		
		biPredicate = (s1, s2) -> s1.getGender().equals(s2.getGender());
		
		System.out.println(biPredicate.test(student1, student2));
	}
}
