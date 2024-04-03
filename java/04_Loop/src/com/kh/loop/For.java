package com.kh.loop;
import java.util.Scanner;
import java.lang.Math;
public class For {
	/*
	 * 반복문 : 프로그램 흐름을 제어하는 제어문 중 하나로
	 *        어떤 실행코드를 반복적으로 수행
	 *        
	 * [표현법]
	 * for(초기식;조건식;증감식) {
	 *   // 반복적으로 수행할 코드
	 * }
	 * 
	 * * 초기식: 반복문이 수행될 때 "최초 한번만 실행되는 구문"
	 * * 조건식: "반복문이 수행될 조건"을 작성하는 구문
	 *          - 조건식이 true이면 반복할 코드를 수행
	 *          - 조건식이 false이면 반복문 종료
	 * * 증감식: 반복문을 제어하는 변수 값을 증감 시키는 구문
	 * => 보통 초기식,조건식,증감식에서 사용하는 변수가 동일하다.
	 * 
	 * * for문 실행 순서
	 * 초기식 -> 조건식 검사 -> true라면 반복할 코드 실행 -> 증감식
	 *      -> 조건식 검사 -> true라면 반복할 코드 실행 -> 증감식
	 *      ---------- 계속 반복 -------------------------
	 *      -> 조건식 검사 -> false라면 반복문(for) 종료
	 *      
	 * * 초기식, 조건식, 증감식 생략 가능
	 *   : ; 필수로 입력 
	 *   for(초기식;조건식;) {}	 // 증감식 생략
	 *   for(;조건식;증감식) {} // 초기식 생략
	 *   for(초기식;;증감식) {} // 조건식 생략
	 */
	public void method1() {
		// "Happy" 5번 출력
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
		
		// for문을 사용해서 출력함수를 1번만 사용
		/*
		for(int i=5; i>0; i--) {
			System.out.println(i+" Happy");
		}
		*/
		int j;
		for(j=1; j<6; j++) {
			System.out.println(j+" Happy");
		}
		
		System.out.println("최종: "+j);
	}
	
	public void method2() {
		// 반복문을 사용해서 10 ~ 1 출력
		// 10 9 8 7 ... 3 2 1
		for(int i=10; i>0; i--) {
			// i 값이 10부터 1까지만 수행되는 부분
			System.out.print(i);
			if (i != 1) {	// i값이 1이 아닌 경우만 공백 출력
				System.out.print(" ");
			}
		}
	}
	
	public void method3() {
		// 1 ~ 10 까지의 총 합을 구하여 출력
		
		// 1 ~ 10 까지 정수 중에 사용자에게 입력받은 값까지의 총 합
		Scanner sc = new Scanner(System.in);
		System.out.print("1 ~ 10까지 정수 중 하나를 입력하시오: ");
		int end = sc.nextInt();
		
		if (1 <= end && end <= 10) {
			int total = 0;
			for(int i=1;i<=end;i++) {
				// i=1, total=0 > total = 0 + 1=1
				// i=2, total=1 > total = 1 + 2=3
				// i=3, total=3 > total = 3 + 3=6
				System.out.print("i="+i+", total="+total);
				total += i;	// total = total + i;
				System.out.println(", 연산 후 total="+total);
			}
			System.out.println("총 합: " + total);			
		} else {
			System.out.println("범위를 벗어난 값이 입력되었습니다.");
		}

	}
	
	public void method4() {
		// 랜덤값까지의 총 합을 구하여 출력
		// (1 ~ 10)
		/*
		 * [랜덤값 구하는 방법]
		 * - Math : java.lang.Math
		 *          random()
		 *   * Math.random() 호출
		 *     0.0 ~ 0.9999999 ( 0.0 <= < 1.0) 랜덤값       
		 */
		// Math.random() * 10 		// 0.0 ~ 9.99999999 랜덤값
		// Math.random() * 10 + 1	// 1.0 ~ 10.99999999 랜덤값
		// (int)(Math.random() * 10 + 1)	// 1 ~ 10 랜덤값
		int random = (int)(Math.random() * 10 + 1);
		System.out.print("1부터 "+random+"까지의 합: ");
		
		int total = 0;
		for(int i=1;i<=random;i++) {
			total += i;
		}
		System.out.print(total);
	}
	
	public void method5() {
		final String STR = "Story";
		// 각 인덱스(위치) 별 문자를 한 줄씩 출력
		// S
		// t
		// o
		// r
		// y
		for(int i=0;i<STR.length();i++) {
			System.out.println(STR.charAt(i));
		}
	}
	
	public void method6() {
		// 구구단 3단 출력하기
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ...
		// 3 x 9 = 27
		Scanner sc = new Scanner(System.in);
		System.out.print("출력하고자 하는 단수 입력: ");
		int su = sc.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d x %d = %d\n", su, i, (su*i));
		}
	}
	
	public void method7() {
		// 구구단 2단 ~ 9단 출력
		// 중첩 반복문 사용.
		//  for(초기식1;조건식1;증감식1) {
		//		for(초기식2; 조건식2; 증감식2) {
		//		}
		//	}
		/* 세로로 출력
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i*j));
			}
			System.out.println("-----------");
		}
		*/
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.printf("%d x %d = %d\t", j, i, (j*i));
				// \n : 줄바꿈, \t : 탭(	)
			}
			System.out.println();
		}
	}
}








