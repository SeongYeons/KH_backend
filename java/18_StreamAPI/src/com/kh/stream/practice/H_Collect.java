package com.kh.stream.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class H_Collect {
	/*
	 * 수집
	 *   - 최종 처리 기능으로 필터링 또는 매핑한 요소들을 
	 *     새로운 컬렉션으로 담아서 리턴 받을 수 있다.
	 */
	
	public void method1() {
		List<Student> students = Arrays.asList(
			new Student("홍길동", 30, "남자", 50, 70),
			new Student("성춘향", 18, "여자", 90, 90),
			new Student("이몽룡", 22, "남자", 10, 80),
			new Student("심청이", 18, "여자", 100, 100),
			new Student("임꺽정", 28, "남자", 60, 60)
		);
		
		// 남학생만 List 컬렉션으로 반환
		List<Student> list = students.stream()
			.filter(student -> student.getGender().equals("남자"))
			.collect(Collectors.toList());
		
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		// 여학생만 Set 컬렉션으로 반환
		Set<Student> set = students.stream()
			.filter(student -> student.getGender().equals("여자"))
			.collect(Collectors.toSet());
				
		set.stream().forEach(System.out::println);
		
//		Map<Integer, String> map = new HashMap<>();
//		
//		map.put(1, "칸쵸");
//		map.put(2, "다이제");
//		map.put(3, "프링글스");
//		map.put(1, "초코송이");
//		
//		System.out.println(map.get(1));
//		System.out.println(map.get(2));
//		System.out.println(map.get(3));
		
		System.out.println();
		
		Map<String, Student> map = students.stream()
//			.collect(Collectors.toMap(student -> student.getName(), student -> student));
			.collect(Collectors.toMap(Student::getName, Function.identity()));
		
		System.out.println(map);
		System.out.println(map.get("임꺽정"));
		System.out.println(map.get("심청이"));
	}
}