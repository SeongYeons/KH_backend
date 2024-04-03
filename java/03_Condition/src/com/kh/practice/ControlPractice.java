package com.kh.practice;

import java.util.Scanner;

public class ControlPractice {
	
	public void practice1() {
		// 실습문제 1
		//  정수를 입력받아서 1 ~ 100 사이의 값이 아닌 경우 "잘못 입력되었습니다." 출력
		//  범위에 해당되면 입력 값을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int num = sc.nextInt();
		String result = "";
		
		if(num >=1 && num <=100) {
//			System.out.println("결과 : " + num);
			result = "결과 : " + num;
		} else {
//			System.out.println("잘못 입력되었습니다.");
			result = "잘못 입력되었습니다.";
		}
		System.out.println(result);
	}
	
	public void practice2() {
		// 국어, 영어, 수학 점수 입력 받아서 총점, 평균 출력
		// 세 과목 점수 40점 이상이고, 평균이 60점 이상일 때 "합격", 그렇지 않으면 "불합격" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		double ko = sc.nextDouble();
		
		System.out.print("영어 : ");
		double en = sc.nextDouble();
		
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		int total = (int)(ko + en + math);
		int avg = total / 3;
		
		System.out.printf("총점은 %d점이고, 평균은 %d점입니다.\n",total,avg);
		
		if(ko>=40 && en>=40 && math>=40 && avg >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(cm) : ");
		double h = sc.nextDouble();
		
		System.out.print("몸무게(kg) : ");
		double w = sc.nextDouble();
		
		// 키 cm => m
		h /= 100; // h*=0.01;
		
		double bmi = (w/(h*h));
		String result = "";
		if (bmi <= 18.4) {
			result = "저체중";
		} else if ((18.5 <= bmi) && (bmi <= 22.9)) {
			result = "정상";
		} else if ((23.0 <= bmi) && (bmi <= 24.9)) {
			result = "과체중";
		} else {
			result = "비만";
		}
		
		System.out.printf("BMI는 %.1f로 %s입니다.", bmi, result);
	}
	
	public void practice4() {
		// 아이디랑 비밀번호를 비교해서 같은 경우 "로그인 성공", 다른 경우 "로그인 실패" 출력
		//  초기값 : 아이디= kh_manager, 비밀번호=1234567
		//  문자열이 같은 지 비교해주는 메소드 : equals()
		Scanner sc = new Scanner(System.in);
		
		final String id = "kh_manager";
		final String pw = "1234567";
		
		System.out.print("아이디 : ");
		String _id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String _pw = sc.nextLine();
		// A.equals(B) : A와 B가 같으면 true, 다르면 false
		if(id.equals(_id) && _pw.equals(pw)) { 
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	public void practice5() {
		// 정수 2개를 입력받고 연산 기호를 입력받아서 연산 결과 출력
		//  연산 기호 잘못 입력했을 경우 "입력이 잘못되었습니다." 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피연산자 입력: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.print("연산기호 입력(+, -, *, /, %): ");
		char op = sc.next().charAt(0);
		
		switch(op) {
		case '+':
			System.out.println("결과 : " + (num1 + num2));
			break;
		case '-':
			System.out.println("결과 : " + (num1 - num2));
			break;
		case '*':
			System.out.println("결과 : " + (num1 * num2));
			break;
		case '/':
			System.out.println("결과 : " + (num1 / num2));
			break;
		case '%':
			System.out.println("결과 : " + (num1 % num2));
			break;
			default:
				System.out.println("입력이 잘못되었습니다.");
		}
	}
	
	public void practice6() {
		// 입력받은 값의 가운데 값을 출력
		//  (단, 입력받은 값의 길이가 짝수이면 가운데 문자 중 앞의 문자를 출력)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String temp = sc.nextLine();
		
		int center = temp.length() / 2;
		// abcde length > 5, center=2 => c
		// abcdef length > 6, center=3 => d center = center - 1
		if (temp.length() % 2 == 0) {
			center--;
		}
		
		char ch = temp.charAt(center);
		
		System.out.println("결과 : " + ch);
	}
	
	public void practice7() {
		// 두 자리 정수를 입력받아 10의 자리수와 1의 자리수가 같으면 "10의자리수와 1의자리수가 같습니다." 출력
		// 다른 경우에는 큰 값에서 작은 값을 뺀 결과를 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 자리 정수 입력: ");
		int num = sc.nextInt();
		
		if (10 <= num && num <= 99) {
			// 10 <= num <= 99 사이인 값인 경우
			int ap = num / 10;	// 28 / 10 => 2
			int dui = num % 10; // 28 % 10 => 8
			
			if (ap == dui) {
				System.out.println("10의 자리 수와 1의 자리 수가 같습니다.");
			} else {
				int result = ap < dui ? dui - ap : ap - dui;
				System.out.println("결과 : " + result);
			}
		}
	}
	
	public void practice8() {
		// 입력한 입금 금액에서 5만원권, 1만원권, 5천원권, 1천원권의 개수 동전 금액을 출력
		// (단, 사용자의 입력은 정수로 받음)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입금 금액 : ");
		int money = sc.nextInt();
		
		// 83200
		int _man = money / 10000;	// 8
		int _5man = 0;
		if (_man >= 5) {
			_5man = 1;	// 1
			_man -= 5;	// 8 - 5 = 3
		}
		money %= 10000;				// 3200
		System.out.println("5만원권: " + _5man);
		System.out.println("1만원권: " + _man);
		
		int _1000 = money / 1000;	// 3
		int _5000 = 0;
		if(_1000 >= 5) {
			_5000 = 1;
			_1000 -= 5;
		}
		money %= 1000;				// 3200 % 1000 = 200
		System.out.println("5천원권: " + _5000);
		System.out.println("1천원권: " + _1000);
		
		System.out.println("동전 금액: " + money);
	}
}












