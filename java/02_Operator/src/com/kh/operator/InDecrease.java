package com.kh.operator;

public class InDecrease {
	/*
	 * 증감 연산자 (단항 연산자)
	 * - ++ : 값을 1 증가시켜주는 연산자
	 *        예) ++변수, 변수++
	 * - -- : 값을 1 감소시켜주는 연산자
	 *        예) --변수, 변수--
	 *        
	 * - 처리 순서 (다른 연산자가 같이 있을 경우)
	 *   * (증감 연산자)변수 : 전위연산   => "선증감" 후처리
	 *   * 변수(증감 연산자) : 후위연산   => 선처리 "후증감"
	 */
	public void method1() {
		int num1 = 10;
		
		System.out.println("초기 num1 : " + num1);			// num1 = 10
		System.out.println("전위 연산 1회 수행 : " + ++num1);	// num1 = 11
		System.out.println("후위 연산 1회 수행 : " + num1++);	// num1 = 11
		System.out.println("최종 num1 : " + num1);			// num1 = 12
	}
	
	public void method2() {
		int num1 = 20;
		int result1 = ++num1 * 3;	// num1 = 21, result1 = 21 * 3 = 63
		// num1 = num1 + 1;
		// result1 = num1 * 3;
		
		int num2 = 20;
		int result2 = num2++ * 3;	// result2 = 60, num2 = 21
		// result2 = num2 * 3;
		// num2 = num2 + 1;
		
		System.out.printf("num1 : %d, result1 : %d\n", num1, result1);
		System.out.printf("num2 : %d, result2 : %d\n", num2, result2);
	}
	
	public void method3() {
		// 실행 전 결과 예측하기
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);							// 출력 결과 : 10
		// a = 11, b = 20
		System.out.println((++a) + (b++));					// 출력 결과 : 12 + 20 = 32
		// a = 12, b = 21, c = 30
		System.out.println((a++) + (--b) + (--c)  );		// 출력 결과 : 12 + 20 + 29 = 61
		// a = 13, b = 20, c = 29
		System.out.printf("a : %d, b : %d, c : %d", a, b, c); // 출력 결과 :
	}
}






