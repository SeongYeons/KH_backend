package com.kh;

import java.util.Scanner;

public class Variable {
	public static void main(String[] args) {
		// 실습문제 1 메소드 호출
		// practice1();
		
		// 실습문제 2 메소드 호출
		// practice2();
		
		// 실습문제 3 메소드 호출
		// practice3();
		
		// 실습문제 4 메소드 호출
		practice4();
		
		/*
		// * 실습문제 4 참고
		String str = "hi";
		str.charAt(0);		// 문자열 값 중 전달한 숫자의 위치에 값을 가져와라.
							// * 첫번째 위치는 0부터 시작.
		 */
	}
	
	public static void practice1() {
		// 실습문제 1.
		// Scanner 클래스 객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");	// print : 줄바꿈하지않고 출력
		String name = sc.nextLine();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		String gender = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		
		System.out.printf("키 %.1fcm인 %d살 %s자 %s님 반갑습니다^^", height, age, gender, name);
	}
	
	public static void practice2() {
		// 실습문제 2.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("더하기 결과 : " + (num1 + num2));
		System.out.println("빼기 결과 : " + (num1 - num2));
		System.out.println("곱하기 결과 : " + (num1 * num2));
		System.out.println("나누기 결과 : " + (num1 / num2));
	}
	
	public static void practice3() {
		// 실습문제 3.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double w = sc.nextDouble();
		
		System.out.print("세로 : ");
		double h = sc.nextDouble();
		
		System.out.println("면적 : " + (w * h));
		System.out.println("둘레 : " + (w+h)*2);
	}
	
	public static void practice4() {
		// 실습문제 4.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String temp = sc.nextLine();
		
		// temp > "apple" // 
//		char c1 = temp.charAt(0); // c1 > a
//		char c2 = temp.charAt(1); // c2 > p
//		char c3 = temp.charAt(2); // c3 > p
		System.out.println("첫 번째 문자 : " + temp.charAt(0));
		System.out.println("두 번째 문자 : " + temp.charAt(1));
		System.out.println("세 번째 문자 : " + temp.charAt(2));
	}
}
