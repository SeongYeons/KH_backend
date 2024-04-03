package com.kh;

import java.util.Scanner;

/*
 * [2] 연산자(Operator) 관련 실습 예제
 */
public class Practice {
	/*
	 * 실습 예제 1. 복합 대입 연산자
	 *  아래 요구사항을 [복합 대입 연산자]를 사용하여 계산하도록 구현해주세요.
	 *  * 복합 대입 연산자 : 대입 연산자와 다른 연산자를 조합해 하나의 연산자처럼 사용하는 연산자
	 *  예) num1 = num1 + 2; => num1 += 2;	// num1 변수에 num1 + 2 계산한 결과를 대입한다.
	 */
	public static void example01() {
		//  사용자로부터 숫자를 입력받아 그 값에 7L을 더한다.
		System.out.print("1 ~ 10 까지 자연수 중 원하는 값을 입력하세요: ");
		// 사용자 입력 받기
		short num;		
		// Scanner 생성(선언)
		Scanner sc = new Scanner(System.in);
		// 사용자로부터 입력받은 값을 short 자료형으로 바꿔서 뱉어낸다.
		// 그 값을 num 이라는 변수에 저장.
		num = sc.nextShort();
		
		// 사용자가 입력한 값에 7L 더하기
		//  예) 복합 대입 연산자를 사용하지 않은 경우 
		// > num = (short)(num + 7L);
		// num = (short)(num + 7L);
		// num += 7L; 	// long 자료형은 값 뒤에 L을 붙여서 표현.
		// => num = (short)(num+7L);
		
		
		// 결과 출력해주기
		//  출력 예) 입력 값 5에 7L을 더한 결과는 12 입니다.
		System.out.println("입력 값 " + num + "에 7L에 더한 결과는 " + (num += 7L) + "입니다.");
		
	}
	
	
	/*
	 * 실습 예제 2. 관계(비교) 연산자와 논리 연산자
	 *  공통 점 > 항이 두 개인 이항 연산자, 결과 값은 참(true) 또는 거짓(false)
	 * 	관계(비교) 연산자: 두 개의 항 중 어느 것이 더 큰지/작은지/같은지 등의 여부 검사
	 *  논리 연산자 : 논리 연산자 공식에 따라 참 인지 거짓인지 여부 검사 (&&:논리 곱, ||:논리 합, !:부정)
	 */
	public static void example02() {
		int age = 18;
		System.out.println("당신은 " + ((age >= 20) ? "성인" : "미성년자") + "입니다.");
		// 위 출력문의 결과?
		// 번외) 위에서 사용된 삼항 연산자 부분은? 
		//      해석은?

		
		// 추가) 초등학생, 중학생, 고등학생인지 구별하여 출력해보기
		//		- 초등학생 : 8살 ~ 13살 까지
		//		- 중학생	: 14살 ~ 16살 까지
		//		- 고등학생 : 17살 ~ 19살 까지
		String grade = "알수 없음";			// 기본 값을 "알수 없음"으로 함.
		// 나이 범위에 따라 학년 등급을 변경
		//	초등학생 나이 범위 체크
		grade = (age >= 8) && (age <= 13) ? "초등학생" : grade;		// 나이 범위에 해당되지 않는 경우 기존 grade 변수의 값을 대입
		//	중학생 나이 범위 체크
		
		// 	고등학생 나이 범위 체크
		
		// 화면에 출력 예시: "나이가 18살이면 고등학생 입니다."
		
		
		// 아래 코드가 오류가 나는 이유는?
//		System.out.println("[확인] " + (true && 5));
		
		
		// SCE : Short Circuit Evaluation (단락 회로 평가)
		// 	논리 곱 연산과 논리 합 연산을 할 때 두 항을 모두 실행하지 않더라도 결과 값을 알 수 있는 경우,
		//	나머지 항은 실행되지 않는 것
		int num = 10;
		int i = 3;
		boolean result;
		
		result = ((num += 15) < 0) && ((i*=2) > 2);
		System.out.println("====== 논리 곱 결과 ======");
		System.out.println(result);
		System.out.println(num);
		System.out.println(i);
		// 실행 전 결과를 예상해보세요.
		/* 출력 결과는?
		 * 
		 * 
		 * 
		 */
		
		result = ((num += 15) < 0) || ((i*=2) > 2);
		System.out.println("====== 논리 합 결과 ======");
		System.out.println(result);
		System.out.println(num);
		System.out.println(i);
		// 실행 전 결과를 예상해보세요.
		/* 출력 결과는?
		 * 
		 * 
		 * 
		 */	
	}
	
	
	/*
	 * 실습 예제 3. 산술 연산자 활용
	 *  키와 몸무게를 입력받아, BMI를 계산하여 출력해주세요.
	 *  * BMI 계산식 : 몸무게 ÷ (키(m) × 키(m))
	 *  * BMI 판정 기준
	 *    - 18.5 이하 : 저체중
	 *    - 18.5 ~ 22.9 : 정상
	 *    - 23.0 ~ 24.9 : 과체중
	 *    - 25.0 이상 : 비만
	 *  출력 예) "BMI 지수는 20.5로 정상입니다."
	 *  참고) 신체질량지수(BMI : Body Mass Index): 
	 */
	public static void example03() {
		// 키를 입력받는다.
		//  사용자 입력을 받기 위한 화면 안내 출력
		System.out.print("키를 입력해주세요. (cm) :");
		//  사용자 입력 받기
		
		
		// 몸무게를 입력받는다.
		//  사용자 입력을 받기 위한 화면 안내 출력
		
		//  사용자 입력 받기
		
		
		// 키에 대한 값의 단위를 cm에서 m로 변환한다.
		
		
		// BMI를 계산한다.
		
		
		// 출력 예를 참고하여 결과를 화면에 출력한다.
		
		
	}
	
	
	/*
	 * 실습 예제 4. 조건 연산자
	 * 	삼항 연산자를 사용하여 커플 종류를 출력해주세요.
	 */
	public static void example04() {
		// 커플의 나이를 입력받기
		System.out.print("남자분 나이 : ");
		// 입력 받기
		
		System.out.print("여자분 나이 : ");
		// 입력 받기
		
		String result = "솔로";		// 기본 값은 슬프지만 "솔로"
		// 나이를 계산하여 아래 기준에 따라 출력해주세요.
		//	남자 나이가 많은 경우 "연상남 연하녀 커플"
		//	여자 나이가 많은 경우 "연상녀 연하남 커플"
		//	나이가 같은 경우 "동갑 커플"
		
		
	}
	
	public static void main(String[] args) {
		/*
		 * 각 예제 별 실행이 필요한 경우 주석을 해제하여 실행해주세요.
		 */
		
		// 실습 예제 1 실행
//		example01();
		
		// 실습 예제 2 실행
//		example02();
		
		// 실습 예제 3 실행
//		example03();
		
		// 실습 예제 4 실행
//		example04();
		int n = 1;
		int m = 1;
		System.out.println("++n : " + (++n) + ", m++ : " + (m++));
		System.out.println(m);
	}	
}
