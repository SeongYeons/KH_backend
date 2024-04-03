package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		// 입력값이 양수인가? 아닌가?
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		
		int num = sc.nextInt();
		String result = num > 0 ? "양수다" : "양수가 아니다";
		
		System.out.println(result);
	}
	
	public void practice2() {
		// 입력값이 양수인지? 음수인지?
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		
		int num = sc.nextInt();
		String result = num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다");
		// num > 0 조건이 참이면 result 문자열 변수에 "양수다" 값을 대입
		//         조건이 거짓이면 (num == 0 ? "0이다" : "음수다") 삼항 연산자를 연산
		//						num == 0 조건이 참이면 result 문자열 변수에 "0이다" 값을 대입
		//								 조건이 거짓이면 result 문자열 변수에 "음수다" 값을 대입
		
		System.out.println(result);
	}
	
	public void practice3() {
		// 입력받은 값이 짝수인지 홀수인지?
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = (num % 2 == 0) ? "짝수다" : "홀수다";
		
		System.out.println(result);
	}
	
	public void practice4() {
		// 사탕 개수 계산
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (candy / person));	// / : 나누기 후 몫
		System.out.println("남는 사탕 개수 : " + (candy % person));	// % : 나누기 후 나머지
	}
	
	public void practice5() {
		// 학생 정보를 입력받아 성별을 표시
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		String genResult = (gender == 'M'?"남학생":(gender=='F'?"여학생":"알수없음"));
		System.out.printf("%s %s의 성적은 %.2f이다.", name, genResult, score);
	}
	
	public void practice6() {
		// 나이를 입력 받아 어린이인지, 청소년인지, 성인인지 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.println((age <= 13 ? "어린이" : (age <= 19 ? "청소년" : "성인")));
	}
	
	public void practice7() {
		// 국어, 영어, 수학 점수를 입력받아 총합, 평균, 합격여부를 출력하기.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int ko = sc.nextInt();
		
		System.out.print("영어 : ");
		int en = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int total = ko + en + math;
		double avg = total / 3.0;
		
		String result = ((ko >= 40 && en >= 40 && math >= 40) && (avg >= 60)) ? "합격" : "불합격";
		
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println(result);
	}
	
	public void practice8() {
		// 주민번호 뒷자리 첫번째 값으로 남자인지, 여자인지 구분하여 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String rrn = sc.nextLine();
		
		char gender = rrn.charAt(7);
		System.out.println((gender == '1' || gender == '3' ? "남자" : (gender == '2' || gender == '4' ? "여자" : "알수없음")));
	}
	
	public void practice9() {
		// 입력 받은 값의 범위에 따라 true 또는 false 출력
		//  마지막 입력 값이 정수1보다 이하거나 정수2보다 초과
		//  (단, 정수1은 정수2보다 작아야 함)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		// 이하 => 작거나 같다.
		// 초과 => 크다.
		boolean result = (num1 < num2) && ((num3 <= num1) || (num2 < num3)) ? true : false;
		// num1=11, num2=4, num3=10
		// false || true => true
		System.out.println(result); 
	}
	
	public void practice10() {
		// 정수 3개를 입력받아 모두 같으면 true, 아니면 false 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 1 : ");
		int a = sc.nextInt();
		System.out.print("입력 2 : ");
		int b = sc.nextInt();
		System.out.print("입력 3 : ");
		int c = sc.nextInt();
		
		System.out.println((a == b && b == c) ? true : false);
	}
	
	public void practice11() {
		// A, B, C 사원의 연봉을 입력받고, 인센티브를 포함한 연봉을 계산하여 출력
		//  인센티브가 포함된 연봉이 3000이상이면 "3000 이상" 출력, 미만이면 "3000 미만" 출력
		//  (인센티브 기준: A 사원 - 0.4, B 사원 - 없음, C 사원 - 0.15)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A 사원의 연봉 : ");
		int a = sc.nextInt();
		
		System.out.print("B 사원의 연봉 : ");
		int b = sc.nextInt();
		
		System.out.print("C 사원의 연봉 : ");
		int c = sc.nextInt();
		
		// A: 0.4, B: x, C: 0.15
		double aIn = a * 1.4;
		double bIn = b;
		double cIn = c * 1.15;
		
		System.out.println("A 사원 연봉/연봉+a : " + a +"/"+aIn);
		System.out.println(aIn >= 3000 ? "3000 이상" : "3000 미만") ;
		
		System.out.println("B 사원 연봉/연봉+a : " + b + "/" + bIn);
		System.out.println(bIn >= 3000 ? "3000 이상" : "3000 미만");
		
		System.out.println("C 사원 연봉/연봉+a : " + c + "/" + cIn);
		System.out.println(cIn >= 3000 ? "3000 이상" : "3000 미만");
	}
}
