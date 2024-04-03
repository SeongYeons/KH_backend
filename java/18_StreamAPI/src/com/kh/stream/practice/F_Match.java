package com.kh.stream.practice;

import java.util.Arrays;
import java.util.List;

public class F_Match {
	/*
	 * 매칭
	 *   - 최종 처리 단계에서 요소들이 특정 조건을 만족하는지 확인하는 역할을 한다.
	 *   - allMatch(Predicate)
	 *     - 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하는지 확인한다.
	 *   - anyMatch(Predicate)
	 *     - 최소한 한 개의 요소가 매개값으로 주어진 Predicate의 조건을 만족하는지 확인한다.
	 *   - noneMatch(Predicate)
	 *     - 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하지 않는지 확인한다.
	 */
	
	public void method1() {
		boolean result = false;
		int[] values = {2, 4, 6};
		
		result = Arrays.stream(values)
				  .allMatch(value -> value % 2 == 0);
		
		System.out.println(result);
		
		result = Arrays.stream(values)
				  .anyMatch(value -> value % 3 == 0);
		
		System.out.println(result);
		
		result = Arrays.stream(values)
				  .noneMatch(value -> value % 5 == 0);
		
		System.out.println(result);
	}
	
	public void method2() {
		boolean result = false;
		List<Student> students = Arrays.asList(
			new Student("홍길동", 30, "남자", 50, 70),
			new Student("성춘향", 18, "여자", 90, 90),
			new Student("이몽룡", 22, "남자", 10, 80)
		);
		
		// 나이가 20살 이상인 학생들이 모두 남자인지 확인하시오.
		result = students.stream()
					.filter(student -> student.getAge() >= 20)
					.peek(System.out::println)
					.allMatch(student -> student.getGender().equals("남자"));
		
		System.out.println(result);
		
		// 남학생들 중에 평균이 70점 이상인 학생이 
		// 한 명이라도 존재하는지 확인하시오.
		result = students.stream()
		            .filter(student -> student.avg() >= 70)
		            .peek(System.out::println) 
		            .anyMatch(student -> student.getGender().equals("남자"));
		
		System.out.println(result);
	}
	
}
