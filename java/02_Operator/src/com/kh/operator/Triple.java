package com.kh.operator;
import java.util.Scanner;

public class Triple {
	/*
	 * 삼항연산자 (항이 3개인 연산)
	 * 
	 * - 표현방법
	 *   (조건식) ? (조건이 참일 경우 결과 값) : (조건이 거짓일 경우 결과 값)
	 */
	public void method1() {
		// 종료 의사를 입력받아 결과 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("종료를 원할 경우 x 입력 : ");
		char ch = sc.next().charAt(0);
		
		// 입력받은 값이 x 또는 X 인 경우 "종료합니다." 출력하고
		//  그렇지 않은 경우 "계속 진행합니다." 출력
		String result = "";
		
		result = (ch == 'x' || ch == 'X') ? "종료합니다." : "계속 진행합니다.";
		
		System.out.println(result);
	}
	
	public void method2() {
		/*
		 * 사용자에게 두 개의 정수와 + 또는 - 값을 입력받아
		 * 연산 결과 출력
		 * 입력 예) 10 20 +
		 * 
		 * 단, + 또는 - 외의 문자 입력 시 "입력이 잘못되었습니다." 출력
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아래와 같이 입력하면 연산 결과를 확인할 수 있습니다.");
		System.out.println("예) 10 20 + => 10+20=30 의 결과 확인");
		System.out.print(" : ");
		
		// buffer : 10 20 +\n
		int num1 = sc.nextInt();	// buffer : 20 +\n, num1 = 10
		int num2 = sc.nextInt();	// buffer : +\n, num2 = 20
		char op = sc.next().charAt(0);	// buffer : \n, op = +
		
		sc.nextLine();
		
		String result = "" + ((op == '+') ? num1 + num2 : ((op == '-') ? num1 - num2 : "입력이 잘못되었습니다."));
		
		System.out.println("결과 : " + result);
	}
}











