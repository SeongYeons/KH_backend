package com.kh.practice;

import java.util.Scanner;

public class LoopPractice2 {
	/* 실습문제1 */
	public void practice3() {
		// Scanner 클래스타입의 참조변수 선언
		//	Scanner 클래스타입의 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		
		// print 메소드로 "1이상의 숫자를 입력하세요 : " 내용 출력
		System.out.print("1이상의 숫자를 입력하세요 : ");
		// 사용자로부터 입력받은 값을 정수형타입으로 
		//	정수형(int) 변수 num에 대입
		int num = sc.nextInt(); 
		
		if(num >= 1) {	// 조건식: num 값이 1이상(1, 2, ~)
			for(;num>=1;num--) { // 조건식: num 값이 1이상일때
				System.out.print(num + " ");
			}
		} else {
			// num 값이 0 이하일 때 (0, -1, ...)
			System.out.println("1 이상의 숫자를 입력하세요.");
		}
	}
	
	/* 실습문제2 */
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		int num = 1;// 정수형(int) 변수 num에 1로 초기화
					// 초기화 하지 않아도 됨=> do~while을 사용했고,
					// 사용자에게 입력을 받으면 값을 변경하기 때문에		

		do {		// 조건 상관없이 1회 실행
			System.out.print("1이상의 값을 입력하세요 : ");
			num = sc.nextInt();	// num 변수의 값이 입력받은 값으로 변경(대입)
			
			if(num < 1) {	// 조건식: num 값이 1미만 (0, -1, ...)
				System.out.println("1 이상의 숫자를 입력하세요.");
			} else {	// num 값이 1이상 (1, 2, 3, ...)
				for(int i=1; i <= num; i++) {
					// 초기식: 정수형(int) i 변수를 선언하고 1로 초기화
					// 조건식: i값이 num값보다 작거나 같을때 (이하), i == num
					// 증갑식: i값을 1씩 증가시킨다.
					System.out.print(i + " ");
				}
				// break;		// do ~ while 반복문을 종료
			}
		} while(num < 1);	// num	

	}
	
	/* 실습문제3 */
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int n1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int n2 = sc.nextInt();
		
		if(n1 < 1 || n2 < 1) { // && > n1 : 5, n2 : -1
			System.out.println("1 이상의 값을 입력해주세요.");
		} else {
			// n1 >= 1 && n2 >= 1 인 경우 수행할 문장
			// n1, n2
			int min = n1 > n2 ? n2 : n1;
			int max = n1 < n2 ? n2 : n1;
			
			// 방법1) 초기식, 조건식, 증감식 모두 사용
			/*
			for(int i=min; i<=max; i++) {
				System.out.printf("%d ", i);
			}
			*/
			// 방법2) 초기식 생략, 조건식/증감식 사용
			//  min 이라는 변수를 사용
			/*
			for(; min<=max; min++) {
				System.out.printf("%d ", min);
			}
			*/
			// 방법3) 초기식, 조건식 생략, 증감식만 사용
			/*
			for(;; min++) {
				// 조건식 생략해서 추가
				if(min > max) {
					break;	// 반복문 즉시 종료
				}
				System.out.printf("%d ", min);
			}
			*/
			// 방법4) 초기식, 조건식, 증감식 모두 생략 (추천 하지 않음!)
			for(;;) {
				// 조건식 생략해서 추가
				if(min > max) {
					break;	// 반복문 즉시 종료
				}
				// ---
				System.out.printf("%d ", min);
				min++;	// 증감식 생략해서 추가
			}
		}
	}
	
	/* 실습문제4 */
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자: ");
		int num = sc.nextInt();
		
		System.out.print("공차 : ");
		int d = sc.nextInt();
		
		// 랜덤하게 증가하거나 감소하거나
		//  1 ~ 10 : (int)(Math.random() * 10 + 1)
		//  0, 1 : (int)((Math.random() * 10 + 1) % 2)
		//   0: 감소하도록, 1: 증가하도록
		int random = (int)((Math.random() * 10 + 1) % 2);
		
		// 방법 1) 출력 후 계산 (반복)
		/*
		for(int i=0; i<10; i++) {	// 10개만 출력하기 위해,
			System.out.print(num + " ");
			if(random == 1) num += d;
			else num -= d;
		}
		*/
		// 방법 2) 출력과 동시에 계산 (반복)
		/*
		for(int i=0; i<10; i++) {	// 10개만 출력하기 위해,
			if(random == 1)
//				System.out.print(num + (i*d) + " ");
			else
//				System.out.print(num - (i*d) + " ");
		}
		*/
	}
	
	/* 실습문제5 */
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		// ---- 
		while(true) {
			
			System.out.print("연산자(+, -, *, /, %) : ");
			String op = sc.nextLine();
			// equals() // 문자열 비교, true/false
			if(op.equals("exit")) { // op 변수의 값이 "exit"인가?
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			// 여기서부터는 op 값이 "exit"가 아닌 경우 아래 문장들 실행
			
			System.out.print("정수1 : ");
			int n1 = sc.nextInt();
			
			System.out.print("정수2 : ");
			int n2 = sc.nextInt();
			
			sc.nextLine();
			
			// 방법1) 연산자 값 확인 후 바로 출력
			/*
			switch(op) {	// == != , .equals()
			case "+":
				System.out.printf("%d %s %d = %d\n", n1, op, n2, n1+n2);
				break;
			case "-":
				System.out.printf("%d %s %d = %d\n", n1, op, n2, n1-n2);
				break;
			case "*":
				System.out.printf("%d %s %d = %d\n", n1, op, n2, n1*n2);
				break;
			case "/":
				if(n2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				} else {
					System.out.printf("%d %s %d = %d\n", n1, op, n2, n1/n2);
				}
				break;
			case "%":
				if(n2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				} else {
					System.out.printf("%d %s %d = %d\n", n1, op, n2, n1%n2);
				}
				break;
			default:
					System.out.println("없는 연산자입니다. 다시 입력해주세요.");
			}
			*/
			
			// 방법2) 결과를 문자열 변수에 저장하여 마지막에 출력
			/*
			String result = n1 + " " + op + " " + n2 + " = ";
			switch(op) {	// == != , .equals()
			case "+":
				result += (n1+n2); 
				// result = result + (n1+n2)
				break;
			case "-":
				result += (n1-n2); 
				break;
			case "*":
				result += (n1*n2); 
				break;
			// 아래 case문을 연이어 사용하면 다음과 같음
			//	op.equals("/") || op.equals("%")
			case "/":
			case "%":
				if(n2 == 0) {
					result = "0으로 나눌 수 없습니다. 다시 입력해주세요.";
				} else {
					// "/" , "%"
					result += ((op.equals("/")) ? n1/n2 : n1%n2);
				}
				break;
			default:
				result = "없는 연산자입니다. 다시 입력해주세요.";
			}
			System.out.println(result);
			*/
			
			// 방법3) 연산 결과를 정수형 변수에 저장하여 마지막에 출력
			//		  조건에 해당되지 않는 경우 에러메시지로 처리
			int result=0;
			String err="";
			switch(op) {
			case "+":
				result = n1 + n2;
				break;
			case "-":
				result = n1 - n2;
				break;
			case "*":
				result = n1 * n2;
				break;
			case "/":
			case "%":
				if (n2 == 0) {
					err = "0으로 나눌 수 없습니다. 다시 입력해주세요.";
				} else {
					result = op.equals("/") ? n1 / n2 : n1 % n2;
				}
				break;
			default:
				err = "없는 연산자입니다. 다시 입력해주세요.";
			}
			// err.equals("") => err.isEmpty()
			if(!err.isEmpty()) {
				System.out.println(err);
			} else {
				System.out.printf("%d %s %d = %d\n", n1, op, n2, result);
			}
			
			// 문자열(String) 관련 메소드
			// 1) charAt([index])   // 문자열에서 해당 index에 문자값, 반환 자료형: 문자형(char)
								    // index: 정수(int), 문자열에서 위치, 0번부터 시작
			// 2) length()		    // 문자열 길이, 반환 자료형: 정수(int)
			// 3) equals([비교할 대상])// 문자열 비교, 반환 자료형: 논리형(boolean, true/false)
			// 4) isEmpty()			// 문자열이 빈 값인지 확인. 반환 자료형: 논리형(boolean, true/false)
		}
		
		// ----
	}
	
	/* 실습문제6 */
	public void practice13() {
        // 정수 입력 : 4
		// 1 *
		// 2 **
		// 3 ***
		// 4 ****
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		// 방법1) 중첩 for문 사용
		// 몇 개의 줄을 표시할 지?
		for(int i=1; i<=num; i++) {
			// *을 출력. 시작점: 1, 끝점: 줄 수
			for(int j=1; j<=i; j++)
				System.out.print("*");
			
			System.out.println();
		}
		
		// 방법2) for문 하나만 사용
        String inputStr = "*";
        for(int i =0; i < num; i++)
        {
            System.out.println(inputStr);
//            System.out.println();
            inputStr += "*";
        }
		
	}
	
	/* 실습문제7 */
	public void practice14() {
		// 정수 입력: 4
		// ****
		// ***
		// **
		// *
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		// 시작점: 입력 값(num), 끝점: 1
		/*
		for(int i=num; i>=1; i--) {
			for(int j=1; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		*/
		/* 
		 * "*" 문자를 입력받은 값만큼 미리 만들고
		 * substring(start, end) : 시작 위치부터 끝 위치까지 문자열을 잘라서 반환(문자열)
        String inputStr = "";
        for(int i = 0; i < num; i++)
        {
            inputStr += "*";
        }
        // inputStr => "****"; length() => 4 - 1
        for(int i = 0; i < num; i++)
        {
            System.out.print(inputStr.substring(0, inputStr.length()-i));
            System.out.println();
        }
        */
	}
}
















