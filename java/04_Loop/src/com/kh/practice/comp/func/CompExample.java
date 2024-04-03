package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {
	/* 실습문제1 */
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		if(num < 1) {	// num 값이 양수가 아닐때, 0 또는 음수
			System.out.println("양수가 아닙니다.");
		} else {
			// num >= 1일 때 수행할 부분
			for(int i=1; i<=num; i++) {
				// i 값이 짝수인지 홀수인지
				if(i % 2 == 0) {	// 짝수일때
					System.out.print("수");
				} else {			// 홀수일때
					System.out.print("박");
				}
			}
		}
	}
	
	/* 실습문제2*/
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		do {
			System.out.print("정수 입력: ");
			num = sc.nextInt();
			
			if(num < 1) {	// num 값이 양수가 아닐때, 0 또는 음수
				System.out.println("양수가 아닙니다.");
			} else {
				// num >= 1일 때 수행할 부분
				for(int i=1; i<=num; i++) {
					// i 값이 짝수인지 홀수인지
					if(i % 2 == 0) {	// 짝수일때
						System.out.print("수");
					} else {			// 홀수일때
						System.out.print("박");
					}
				}
				break;
			}
		} while(true);
	}
	
	
	/* 실습문제3 */
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		// str = "banana", ch = 'a'
		// 문자열 길이=> length()
		// 인덱스 시작번호=> 0
		int cnt = 0;
		for(int i=0; i<str.length(); i++) {
			// str.charAt(i) 0 ~ 길이-1 
			// str = "banana", length() => 6
			//  i = 0) str.charAt(0) => 'b'
			//  i = 1) str.charAt(1) => 'a'
			//  i = 2) str.charAt(2) => 'n'
			//  i = 3) str.charAt(3) => 'a'
			//  i = 4) str.charAt(4) => 'n'
			//  i = 5) str.charAt(5) => 'a'
			//  i = 6) 반복문 종료 (i < str.length()), str.charAt(6)=> 7번째 위치
//			System.out.println(str.charAt(i));
			if(str.charAt(i) == ch) {
				cnt++; // cnt += 1;
			}
		}
		System.out.printf("%s 안에 포함된 %c 개수 : %d", str, ch, cnt);
	}
	
	/* 실습문제4 */
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		char answer = 'y';
		do {
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			
			System.out.print("문자 : ");
			char ch = sc.next().charAt(0);
			
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == ch) {
					cnt++;
				}
			}
			System.out.printf("%s 안에 포함된 %c 개수 : %d\n", str, ch, cnt);
			
			while(true) {
				System.out.print("더 하시겠습니까?(y/n): ");
				answer = sc.next().charAt(0);
				sc.nextLine();
				
				if(answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n') {
					System.out.println("잘못된 대답입니다. 다시 입력하세요.");
				} else {
					// answer == 'Y' || answer == 'y' || answer == 'N' || answer == 'n'
					break;
				}
			}
			
		} while(answer == 'Y' || answer == 'y');
	}	
}











