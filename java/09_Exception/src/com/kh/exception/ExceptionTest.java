package com.kh.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	/*
	 * 예외 (Exception)
	 * : 소스 수정으로 해결 가능한 에러(오류)
	 * 
	 * * 예외 처리 : 예측 가능한 예외를 처리하는 방법
	 * 
	 * * Checked Exception : 반드시 예외처리를 해야하는 예외
	 * 	 Exception, IOException, FileNotFoundException, ...
	 * * Unchecked Exception : 필수적으로 예외처리 하지 않아도 되는 예외
	 * 						   프로그램 실행에 영향을 주진 않지만, 
	 * 							흐름상 오류가 있는 경우 예외 발생
	 * 	 RuntimeException, ArithmeticException, 
	 * 								NullPointerException, ...
	 * 
	 * * 예외 처리 방법 (2가지)
	 * [1] 예외가 발생한 위치에서 직접 처리 (try ~ catch)
	 * 		[구조]
	 * 		try {
	 * 			// 예외가 발생할 가능성이 있는 부분 작성
	 * 		} catch(예상되는예외클래스명 참조변수명) {
	 * 			// 예외 발생 시 해당되는 예외에 대해 처리할 내용 작성
	 * 			// 예외 내용 확인 메소드명 : 참조변수명.getMessage()
	 *			// 예외 발생 지점, 호출된 메소드 등 자세한 정보 출력
	 *				참조변수명.printStackTrace()
	 * 		} finally {
	 * 			// 예외 발생 유/무에 상관 없이 반드시 처리할 부분 작성
	 * 		}
	 * 
	 * 	[2] 호출한 메소드에게 예외를 전달 (회피) : throws 사용
	 * 		[구조]
	 * 		메소드 선언부 throws 발생되는예외클래스명 { }
	 * 
	 * 		* 예외 발생 시키는 방법 : throw 사용
	 * 		[사용법]
	 * 		throw new 예외클래스명();	// 예외클래스를 발생시킨다.
	 */
	
	public static void main(String[] args) {
		// Unchecked Exception : 예외처리가 필수가 아닌 예외
//		arithmeticTest();
//		inputMismatchTest();
//		arrayIndexOutOfBoundsTest();
//		nullPointerTest();
		
		// Checked Exception : 반드시 예외처리가 필요한 예외
		try {
			System.out.println("[1]");
			fileNotFoundTest();
			System.out.println("[2]");
		} catch(FileNotFoundException e) {
			System.out.println("[3]");
			System.out.println("[Exception] " + e.getMessage());
		} finally {
			System.out.println("[4]");
			System.out.println("** finally 부분 **");
		}
		System.out.println("[5]");
		System.out.println("-----------------------");
	}

	public static void arithmeticTest() {
		// ArithmeticException : 산술관련 예외
		int n1 = 10;
		int n2 = 0;
		
		System.out.println("=== ArithmeticException Test ===");
		if (n2 > 0) {
			System.out.println(n1 / n2);
		}
		System.out.println("================================");
	}
	
	public static void inputMismatchTest() {
		// InputMismatchException : 입력이 잘못된 경우
		Scanner sc = new Scanner(System.in);
		boolean bCheck = false;	// 기본값: false
		int n1;
		
		System.out.println("=== InputMismatchException Test ===");
		while(!bCheck) {
			try {
				System.out.print("정수 입력: ");
				n1 = sc.nextInt();
				bCheck = true;
			} catch(InputMismatchException e) {
				System.out.println("입력이 잘못되었습니다.");
//				System.out.println(e.getMessage());
				bCheck = false;
			} finally {
				sc.nextLine();
			}
		}
		System.out.println("===================================");
	}
	
	public static void arrayIndexOutOfBoundsTest() {
		// ArrayIndexOutOfBoundsException
		int[] arr = {10, 20, 30};
		
		System.out.println("=== ArrayInexOutOfBoundsException Test ===");
		// 해결 방법 [1] 반복문 조건식 변경
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		try {
			for(int i=0; i<4; i++) {
					System.out.println(arr[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("[Exception] " + e.getMessage());
		}
		System.out.println("==========================================");
	}
	
	public static void nullPointerTest() throws NullPointerException {
		// NullPointerException : null 관련 예외
		String str = null;	// String 초기값: null
		System.out.println("=== NullPointerException test ===");
		System.out.println(str);
		// 조건문 사용한 예외처리
		if (str != null) {
			int len = str.length();
		}
		// try~catch문 사용한 예외처리
		try {
			int len = str.length();
		} catch(NullPointerException e) {
			System.out.println("[Exception] " + e.getMessage());
		}
		System.out.println("=================================");
	}
	
	public static void fileNotFoundTest() throws FileNotFoundException {
		// FileNotFoundException : 파일처리 관련 예외
		FileInputStream fis = null;
		
		System.out.println("=== FileNotFoundException Test===");
		try {
			System.out.println("\t (1)");
			fis = new FileInputStream("a.txt");
			System.out.println("\t (2)");
		} catch(FileNotFoundException e) {
			System.out.println("\t (3)");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		} finally {
			System.out.println("\t (4)");
		}
		System.out.println("\t (5)");
		System.out.println("=================================");
	}
}










