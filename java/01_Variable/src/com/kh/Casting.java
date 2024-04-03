package com.kh;

import java.util.Scanner;

public class Casting {
	public static void main(String[] args) {
		// 실습문제 1 메소드 호출
//		practice1();
		// 실습문제 2 메소드 호출
//		practice2();
		// 실습문제 3 메소드 호출
		practice3();
	}
	
	public static void practice1() {
		// 실습문제 1
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 : ");
		// char <=> int // 아스키코드 기준에 의해 자동 형변환 가능.
		// 방법1)
		// String _input = sc.nextLine();
		// int unicode = _input.charAt(0); // 0부터 시작.
		// 방법 2)
		char _input = sc.next().charAt(0);
		int unicode = _input;
		System.out.println(_input + " unicode : " + unicode);
	}
	public static void practice2() {
		// 실습문제 2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : " );
		double ko = sc.nextDouble();
		
		System.out.print("영어 : ");
		double en = sc.nextDouble();
		
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		int total = (int)(ko + en + math);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + total/3);
	}
	
	
	
	
	public static void practice3() {
		// 실습문제 3
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;	// float 자료형임을 알려주기 위해 값 뒤에 f를 붙인다.
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2);  	// 2
		System.out.println((int)dNum);			// 2
		
		System.out.println(iNum2 * dNum);		// 4 * 2.5 => 10.0
		System.out.println((double)iNum1); 		// 10 => 10.0
		
		// 2.5
		System.out.println((double)iNum1/iNum2);// 10.0 / 4.0 => 2.5
		System.out.println(dNum);		// 2.5
		
		// 3
		System.out.println((int)fNum);		// 3.0 => 3
		System.out.println(iNum1 / (int)fNum);		// 10 / 3 => 3
		
		System.out.println(iNum1 / fNum);   // 10.0 / 3.0 => 3.3333333
		System.out.println((double)iNum1 / fNum); // 10.0 / 3.0 => 3.333333333333335
		
		System.out.println(ch);	       // 'A'
		System.out.println((int)ch);   // 65
		System.out.println(ch + iNum1);  // 'A' -> 65 + 10 => 75
		System.out.print((char)(ch + iNum1)); 	// 'K'
		
	}
	
	
	
	
	
	
	
	
	
}
