package com.kh.stream;

import com.kh.stream.poly.Animal;
import com.kh.stream.poly.Cat;
import com.kh.stream.poly.Dog;
import com.kh.stream.practice.H_Collect;

public class Application {
	/*
	 * Stream API
	 *   - 컬렉션(배열)의 요소들을 하나씩 참조해서 람다식으로 
	 *     처리할 수 있도록 해주는 반복자이다.
	 *   - 스트림은 Iterator와 비슷한 역할을 하지만 람다식으로 
	 *     요소들의 처리 코드를 제공할 수 있고 내부 반복자를 사용해서
	 *     병렬 처리, 중간 처리, 최종 처리 작업을 수행할 수 있다.
	 * 
	 */
	public static void main(String[] args) {
		// Stream 생성
//		new A_Create().method1();
//		new A_Create().method2();
//		new A_Create().method3();
		
		// 중간 처리 메소드
//		new B_Filtering().method1();
//		new B_Filtering().method2();
//		new C_Sorted().method1();
//		new C_Sorted().method2();
//		new D_Mapping().method1();
//		new D_Mapping().method2();
//		new D_Mapping().method3();
//		new E_Looping().method1();
		
		// 최종 처리 메소드
//		new F_Match().method1();
//		new F_Match().method2();
//		new G_Aggregate().method1();
//		new G_Aggregate().method2();
//		new H_Collect().method1();
		
//		다형성
//		1. 메소드 재정의(Dog, Cat 참고)
//		2. 객체의 형변환
		Animal animal = /* (Animal) */ new Dog("댕댕이");
		
//		Dog dog = (Dog) animal;
		
		animal.eat();
		
		animal = new Cat("나비");
		
		animal.eat();
	}
}
