package com.kh.loop;

import java.util.Scanner;

public class While {
	/*
	 * 반복문 while
	 * 
	 * [표현법]
	 * // [초기식]   // 생략가능
	 * while(조건식) {
	 * 	// 반복적으로 실행할 코드
	 *  // [증감식]  // 생략가능
	 * }
	 * 
	 * - 실행순서
	 * 조건식 검사 -> 조건이 true면 반복할 코드 실행
	 * -> 조건식 검사 -> 조건이 true면 반복할 코드 실행
	 * -> 조건식 검사 -> 조건이 false면 반복문 종료
	 */
	public void method1() {
		// "Happy" 문장을 5번 출력하기
		int i=10;
		
		while(i>5) {
			System.out.println("Happy");
			i--;
		}
	}
	
	public void method2() {
		System.out.println("1) 짝수 출력");
		System.out.println("2) 홀수 출력");
		System.out.print("선택 : ");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		// 사용자가 선택한 값에 따라 1 ~ 10사이 정수 중
		//  짝수 또는 홀수만 출력
		/**** 방법 1)
		if (sel == 1) {
			int i=2;
			while(i % 2 == 0 && i <= 10) {
				System.out.println(i);
				i+=2;
			}
		} else if (sel == 2) {
			int i=1;
			while(i % 2 != 0 && i <= 10) {
				System.out.println(i);
				i+=2;
			}
		}
		****/
        int i = 1;
        
        while(i <= 10)
        {
            if(sel == 1 && i%2 == 0)
            {
                System.out.println(i);
            }
            else if(sel == 2 && i%2 == 1)
            {
                System.out.println(i);
            }
            i++;
        }
	}
	
	public void method3() {
		// For문 예제 4번 - 1부터 랜덤값까지의 총 합
		int random = (int)(Math.random() * 10 + 1);
		System.out.print("1부터 "+random+"까지의 합: \n");
		
		int i=1;
		int total = 0;
		while(i <= random) {
			total += i++;
			// total = total + i; > i++;
//			i++;
		}
		System.out.print(total);
	}
	
	public void method4() {
		int sel=3;
		do {
			System.out.println("1) 짝수 출력");
			System.out.println("2) 홀수 출력");
			System.out.println("3) 종료");
			System.out.print("선택 : ");
			
			Scanner sc = new Scanner(System.in);
			sel = sc.nextInt();
			// .. method2 ..
	        int i = 1;	        
	        while(i <= 10)
	        {
	            if(sel == 1 && i%2 == 0)
	            {
	                System.out.println(i);
	            }
	            else if(sel == 2 && i%2 == 1)
	            {
	                System.out.println(i);
	            }
	            i++;
	        }
		} while(sel != 3);
	}
}











