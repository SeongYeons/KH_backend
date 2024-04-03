package com.kh.operator;

public class Arithmetic {
	/*
	 * 산술연산자 (이항연산자, 두 개의 값으로 연산 수행)
	 * => + - * / %
	 * 
	 * 우선 순위 : * / % > + -
	 */
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
		
		// 나머지 연산자 (%)
		// - 짝수/홀수 판별
		// (num % 2 == 0) => 짝수
		// (num % 2 != 0) or !(num % 2 == 0) => 홀수
		System.out.printf("num1의 값 %d은 짝수인가? %b\n", num1, (num1 % 2 == 0));
		System.out.printf("num2의 값 %d는 홀수인가? %b", num2, (num2 % 2 != 0));
	}
	
	public void method2() {
		// 결과 예측해보기
		int a = 5;
		int b = 10;
		
		// a=5, b=10
		int c = (++a) + b;	// c = 6 + 10 = 16
		System.out.println(c);
		// a=6, b=10, c=16
		int d = c / a;		// d = 16 / 6 = 2
		// a=6, b=10, c=16, d=2
		int e = c % a;		// e = 16 % 6 = 4
		// a=6, b=10, c=16, d=2, e=4
		int f = e++;		// f = 4, e = e+1
		// a=6, b=10, c=16, d=2, e=5, f=4
		int g = (--b) + (d--);	// g = 9 + 2 = 11, d = d-1
		// a=6, b=9, c=16, d=1, e=5, f=4, g=11
		int h = 2;
		// a=6, b=9, c=16, d=1, e=5, f=4, g=11, h=2
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		// i = 12
		// 괄호 먼저 계산
		//  (--c / f) => 15 / 4 = 3
		//  (g-- - d) => 11 - 1 = 10
		//  (++e + h) => 6 + 2 = 8
		//      6 + 9 / (3) * (10) % (8)
		//      6 + 3 * 10 % 8
		//      6 + 30 % 8
		//		6 + 6 => 12
		
		// a=7, b=9, c=15, d=1, e=6, f=4, g=10, h=2, i=12
		
		System.out.println(" a : " + a);	// 출력 : 7
		System.out.println(" b : " + b);	// 출력 : 9
		System.out.println(" c : " + c);	// 출력 : 15
		System.out.println(" d : " + d);	// 출력 : 1
		System.out.println(" e : " + e);	// 출력 : 6
		System.out.println(" f : " + f);	// 출력 : 4
		System.out.println(" g : " + g);	// 출력 : 10
		System.out.println(" h : " + h);	// 출력 : 2
		System.out.println(" i : " + i);	// 출력 : 12
	}
}









