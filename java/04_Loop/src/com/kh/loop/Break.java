package com.kh.loop;

import java.util.Scanner;

public class Break {
	/*
	 * 분기문 break;
	 * : 반복문 안에서 사용되는 분기문
	 *   break; 실행되면 즉시 반복문 종료
	 */
	public void method1() {
		// 랜덤값(1 ~ 100)을 발생시켜 출력
		// 해당 랜덤 값이 짝수일 때 반복문을 종료, 이후 "종료"라고 출력
		while(true) {
			int random = (int)(Math.random() * 100 + 1);
			
			if(random % 2 == 0) {
				System.out.println("종료 : " + random);
				break;
			}
			
			System.out.println("랜덤값 : " + random);
		}
//		System.out.println("종료");
	}
	
	public void method2() {
		// 사용자에게 문자를 입력 받아 정수값으로 출력
		// 출력 예) A unicode : 65
		// 단, 'x' 또는 'X' 입력 시 종료
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("종료를 원할 경우 x 또는 X 입력");
			System.out.print("문자 입력: ");
			char ch = sc.next().charAt(0);
			
			if(ch == 'x' || ch == 'X') {
				break;
			}
			
			System.out.println(ch + " unicode : " + (int)ch);
		}
	}
}








