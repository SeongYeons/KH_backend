package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	/* 실습문제1 */
	public void practice1() {
		// 길이가 10인 배열 선언 1 ~ 10 (정수형)
		int[] arr = new int[10];
		
		// 1 ~ 10까지 반복
		// 반복문을 통해 arr 배열에 1부터 10까지 값을 대입(저장)
		for(int i=0; i<10; i++) {
			// 인덱스 : 위치 값
			// 배열 인덱스 : 배열의 위치 값
			// arr[??] // 배열의 ??번째 위치
			arr[i] = i+1;
			// i = 0) arr[0] = 0 + 1 = 1;
			// i = 1) arr[1] = 1 + 1 = 2;
			// ...
			// i = 9) arr[9] = 9 + 1 = 10;
		}
		
		// arr 배열에 저장된 데이터 출력
		//  배열 길이 : (배열변수명).length
		//  10 => arr[10] => 데이터 없음
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	/* 실습문제2 */
	public void practice2() {
		int[] arr = new int[10];
		// arr[0] = 10;
		// arr[1] = 9;
		// ...
		// arr[9] = 1;
		
		// arr.length = 10;
		/*
		for(int i=0; i < arr.length; i++) {
			arr[i] = arr.length - i;
			// i = 0) arr[0] = 10;
			// i = 1) arr[1] = 10 - 1 = 9;
			// i = 2) arr[2] = 10 - 2 = 8;
			System.out.print(arr[i] + " ");
		}
		*/
		// arr.length = 10;
		//  배열 길이가 10 => 인덱스 0 ~ 9 
		for(int i=arr.length-1; i >= 0; i--) {
			// i = 9) arr[9] = 1 = 10 - 9 = 1;
			arr[i] = arr.length - i;
			
			System.out.print(arr[i] + " ");
		}
		
		for(int i=arr.length; i > 0; i--) {
			// i = 10) arr[10-1] = arr[9] = 10 - 10 + 1 = 1;
			// i = 9) arr[9-1] = arr[8] = 10-9+1 = 2
			arr[i-1] = arr.length-i+1;
			
			System.out.print(arr[i-1] + " ");
		}
	}
	
	/* 실습문제3 */
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int n = sc.nextInt();
		
		if(n > 0) {
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				// 0 1 2 3 ... n-1
				// i = 0) arr[0] = 0 + 1 = 1;
				// i = 1) arr[1] = 1 + 1 = 2;
				arr[i] = i + 1;
				System.out.printf("%d ", arr[i]);
			}
		}
	}
	
	/* 실습문제4 */
	public void practice4() {
		String[] arr = new String[5];
		// "사과", "귤", "포도", "복숭아", "참외"
		/*
		arr[0] = "사과";
		arr[1] = "귤";
		arr[2] = "포도";
		arr[3] = "복숭아";
		arr[4] = "참외";
		*/
		arr = new String[]{"사과", "귤", "포도", "복숭아", "참외"};
		System.out.println(arr[1]);
//		String[] f = {"사과", "귤", "포도", "복숭아", "참외"};
		for(int i=0; i<arr.length; i++) {
			// arr 배열 데이터 중에 "귤"이 있으면 출력
			if(arr[i].equals("귤")) {
				System.out.println(arr[i] + "은 " + (i+1) + "번째 위치에 있습니다.");
			}
		}
 	}
	
	/* 실습문제5 */
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		// "appp" => 'a', 'p', 'p', 'p'
		char[] arr = new char[str.length()];
		for(int i=0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		String index = "";
		int cnt = 0;
		for(int i=0; i < arr.length; i++) {
			
			
			if(arr[i] == ch) {
				cnt++;
				index += i + " ";
				// index = index + i + " ";
				// "test" + 1 + 2 => "test12"
				// "test" + (1 + 2) => "test3"
			}
		}
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : %s\n", str, ch, index);
		System.out.printf("%c 개수 : %d", ch, cnt);
	}
	
	/* 실습문제10 */
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String ssn = sc.nextLine();
		
		char[] org = new char[ssn.length()];
		for(int i=0; i<ssn.length(); i++) {
			org[i] = ssn.charAt(i);
		}
		
		// char[] copy = org;		// 얕은 복사, 원본이 훼손됨.
		char[] copy = org.clone();	// 깊은 복사
		
		// 123456-7890000 => length = 14
		// 13 12 11 10 9 8
		for(int i=copy.length-1; i > 7; i--) {
			copy[i] = '*';
			// i=13) {'1','2''3''4''5''6''-''7''8''9''0''0''0''*'}
			// i=12
		}
		/*
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i]);
		}
		*/
		System.out.println(org);
		System.out.println(copy);
		// String => char[]
		//  charAt(i)
		/*
		System.out.println(copy.toString());
		int[] a = {1, 2, 3};
		System.out.println(a);
		System.out.println(a.toString());
		*/
	}
	
	/* 실습문제14 */
	public void practice14() {
		// 로또 6자리 숫자를 보관하기 위한 배열 선언
		int[] lotto = new int[6];	// 6개의 정수를 보관하는 배열
		
		// lotto 라는 배열에 값을 대입하기 위해 반복
		for(int i=0; i < lotto.length; i++) {
			// 랜덤 값 : 1 ~ 45
			int random = (int)(Math.random() * 45 + 1);
			lotto[i] = random;
			// i > 0
			// i = 1) lotto[0] == random
			// i = 2) lotto[0] == random
			//        lotto[1] == random // i-1
			// i = 3) lotto[0] == random
			//		  lotto[1] == random
			//        lotto[2] == random // i-1
			// 첫번째 위치부터 현재(i) 직전 위치까지 값을 비교하기 위해
			for(int j=0; j < i; j++) {
				// 중복을 체크
				if(lotto[j] == random) {
					i--;	// i=1 이라면 i=0이됨.
					break;
				}
			}
			
		}
		
		// 정렬: 오름차순
		// 방법1) Araays.sort() 사용
//		Arrays.sort(lotto);
		// 방법2) 버블정렬 사용
		// lotto = {1, 20, 15, 41, 3};
		for(int i=0; i < lotto.length; i++) {
			// i: 현재위치
			// j: 현재위치+1 => 비교할 대상
			// i=0) lotto[i] = lotto[0] = 15
			// j=i+1=1) lotto[j] = lotto[1]
			// j=2) lotto[0] = 15, lotto[2] = 3
			// j=3) lotto[i]=lotto[0]=3, lotto[j]=lotto[3]=41
			// j=4) lotto[i]=lotto[0]=3, lotto[j]=lotto[4]=1
			//      lotto[0]=1, lotto[4]=3
			for(int j=i+1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		
//		for(int i=0; i < lotto.length; i++) {
//			System.out.print(lotto[i] + " ");
//		}
	}
}














