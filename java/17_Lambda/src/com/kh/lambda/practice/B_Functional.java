package com.kh.lambda.practice;

import com.kh.lambda.practice.functional.A_FunctionalInterface;
import com.kh.lambda.practice.functional.B_FunctionalInterface;
import com.kh.lambda.practice.functional.C_FunctionalInterface;

public class B_Functional {
	private int num = 100;	
	
	public void method1() {
		A_FunctionalInterface fi;
		
//		fi = () -> {
//			System.out.println("매개변수와 반환값이 없는 람다식");
//		};
		
		// 실행문이 한 줄이라면 중괄호를 생략 가능
		fi = () -> System.out.println("매개변수와 반환값이 없는 람다식");
	
		fi.method();
		
		System.out.println();
	}
	
	public void method2() {
		B_FunctionalInterface fi;
		
//		fi = (int x) -> {
//			System.out.println(x * x);
//		};
		
		// 매개변수의 자료형을 생략 가능
//		fi = (x) -> {
//			System.out.println(x * x);
//		};
		
		// 매개변수가 하나면 괄호를 생략 가능
		fi = x -> System.out.println(x * x);
		
		fi.method(10);
	}
	
	public void method3() {
		int result = 0;
		C_FunctionalInterface fi;
		
//		fi = (int x, int y) -> {
//			return x + y;
//		};
		
		// 매개변수의 자료형, return 구문, 중괄호 생략 가능
		fi = (x, y) -> x + y;
		
		result = fi.method(10, 20);
		
		System.out.println("result : " + result);
	}
	
	public void method4(int arg) {
		// 람다식에서 필드(멤버 변수)와 지역 변수 사용하기
		int num = 20;
		A_FunctionalInterface fi;
		
//		System.out.println(num); // 지역 변수
//		System.out.println(this.num); // 필드(멤버 변수)
		
//		num = 400;
//		arg = 500;
//		this.num = 300;
		
		// 람다식에서 사용되는 this는 람다식을 실행하는 인스턴스의 참조이다.
		// 람다식에서 지역변수를 이용할 때는 지역변수가 final, 
		// effectively final이어야 한다.
		fi = () -> {
//			num = 400;
//			arg = 500;
			this.num = 300;
			
			System.out.println(num);
			System.out.println(arg);
			System.out.println(this.num);
		};
		
		fi.method();
		
		// 익명 구현 객체에서 사용되는 this는 익명 구현 객체로 
		// 생성된 인스턴스의 참조이다.
		fi = new A_FunctionalInterface() {
			
			@Override
			public void method() {
//				num = 400;
//				arg = 500;
				
				System.out.println(num);
				System.out.println(arg);
//				System.out.println(this.num);	
			}
		};
		
	}
}
