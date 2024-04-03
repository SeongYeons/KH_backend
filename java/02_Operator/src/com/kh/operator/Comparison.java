package com.kh.operator;

import java.util.Scanner;

public class Comparison {
	/*
	 * 비교연산자 (이항 연산자)
	 * - 두 값을 비교하는 연산자
	 * - 조건을 만족하면 결과가 true, 그렇지 않으면 false
	 * 
	 * - 종류
	 *   * 대소비교연산자 : < > <= >=
	 *   * 동등비교연산자 : == !=
	 */
	public void method() {
		// 입력받은 두 정수의 값을 비교하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 2개 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.printf("입력 값 : %d, %d\n", num1, num2);
		
		System.out.println("첫번째 값이 두번째 값보다 큰가 ? "+(num1>num2));
		System.out.println("첫번째 값이 짝수인가? " + (num1 % 2 == 0));
		
		System.out.println(num2 == 'A');
		// A : 65 ~ Z: 90 (ASCII)
	}
}



