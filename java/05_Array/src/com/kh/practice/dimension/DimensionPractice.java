package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {
	
	/* 실습문제1 */
	public void pratice1() {
		// 3행 3열짜리 문자열 배열 선언 및 할당
		String[][] str = new String[3][3];
		
		// 2차원 배열의 행에 해당하는 인덱스를 제어
		for(int i=0; i<3; i++) {
			// 2차원 배열의 열에 해당하는 인덱스를 제어
			for(int j=0; j<3; j++) {
				// "(0, 0)" 형식으로 저장
				str[i][j] = "(" + i + ", " + j + ")";
			}
		}
		
		// 출력
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// i행 j열의 데이터를 출력
				System.out.print(str[i][j]);
			}
			System.out.println();
		}
	}
	
	/* 실습문제2 */
	public void practice2() {
		// 4행 4열짜리 정수형 배열 선언 및 할당
		int[][] nums = new int[4][4];
		
		// 1 ~ 16까지 차례대로 값을 저장
		// int data = 1;
		//  i: 행의 인덱스
		for(int i=0; i<4; i++) {
			// j: 열의 인덱스
			for(int j=0; j<4; j++) {
			//	nums[i][j] = data++;
				nums[i][j] = (j+1) + (i*4);
//				System.out.printf("i=%d, j=%d, %d + %d = %d\n", i, j, (j+1), (i*4), nums[i][j]);
				if (nums[i][j] < 10) System.out.print(" "); 
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * 	1 2 3 4 
		   	5 6 7 8 
         9 10 11 12 
        13 14 15 16 
		 */
		// 출력
	}
	
	/* 실습문제3 */
	public void practice3() {
		// 4행 4열 정수형 배열 선언 및 할당
		int[][] nums = new int[4][4];
		
		// 16~1 순서로 저장
		/*
			16 15 14 13 
			12 11 10  9 
			 8  7  6  5 
			 4  3  2  1 
		 */
		int data = 16;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				nums[i][j] = data--;
//				nums[i][j] = (4-j) + ((3-i)*4);
				
				if(nums[i][j] < 10) System.out.print(" ");
				
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		
		// 저장된 값 처음 위치부터 출력
	}
	
	/* 실습문제4 */
	public void practice4() {
		// 4행 4열 2차원 배열을 생성 (정수형)
		final int ROW = 4;
		final int COL = 4;
		int[][] nums = new int[ROW][COL];
		
		// 0행 0열부터 2행 2열까지 1 ~ 10까지의 임의의 정수 값을 저장
		for(int i=0; i<ROW-1; i++) {		// 행의 인덱스
			for(int j=0; j<COL-1; j++) {	// 열의 인덱스
				// 임의의 정수 값 => 랜덤 값
				int random = (int)(Math.random()*10) + 1;
				nums[i][j] = random;
			}
		}
		
		// 3열 : 각 행 값들의 합
		//  0행 => (0,3) = (0,0) + (0,1) + (0,2)
		//  1행 => (1,3) = (1,0) + (1,1) + (1,2)
		//  2행 => (2,3) = (2,0) + (2,1) + (2,2)
		for(int i=0; i<ROW-1; i++) {
			for(int j=0; j<COL-1;j++) {
				nums[i][3] += nums[i][j];
				// i=0, j=0) nums[0][3] = nums[0][3] + nums[0][0];
				//                      = 0          + ??
				// i=0, j=1) nums[0][3] = nums[0][3] + nums[0][1];
				// i=0, j=2) nums[0][3] = nums[0][3] + nums[0][2];
			}
		}
		
		// 3행: 각 열 값들의 합
		//  (3,0) = (0,0) + (1,0) + (2,0)
		//  (3,1) = (0,1) + (1,1) + (2,1)
		//  (3,2) = (0,2) + (1,2) + (2,2)
		//  (3,3) = (0,3) + (1,3) + (2,3) + (3,0) + (3,1) + (3,2)
		int sum = 0;
		for(int i=0; i<COL; i++) {			// 열 인덱스
			for(int j=0; j<ROW-1; j++) {	// 행 인덱스
				nums[3][i] += nums[j][i];
			}
			
			if (i==3) {
				nums[3][i] += sum;
				continue;
			}
			
			sum += nums[3][i];
		}
		
		// 출력
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				if (nums[i][j] < 10) System.out.print(" ");
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/* 실습문제9 (8번문제포함) */
	public void practice9() {
		String[] students = new String[] {"강건강" ,"남나나" ,"도대담" ,"류라라" ,"문미미" ,"박보배" ,"송성실" ,"윤예의" ,"진재주" ,"차천축" ,"피풍표" ,"홍하하"};
		
		// 2열 3행으로 2차원 배열 2개를 이용
		String[][] group1 = new String[3][2]; // 데이터 개수: 6
		// students : 0 ~ 5
		String[][] group2 = new String[3][2];
		// students : 6 ~ 11
		
		int index = 0;
		// 2차원 배열에 대입하기 위해 반복문 수행
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 2; c++) {
				group1[r][c] = students[index];
				group2[r][c] = students[index+6];
				index++;
			}
		}
		
		// 출력 
		//  3행 2열 2차원 배열
		System.out.println("== 1분단 ==");
		for(int r=0; r<3; r++) {
			for(int c=0; c<2; c++) {
				System.out.print(group1[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int r=0; r<3; r++) {
			for(int c=0; c<2; c++) {
				System.out.print(group2[r][c] + " ");
			}
			System.out.println();
		}
		//-------- 8번 문제 -------------------------
		int sel = 1;
//		do {
		// sel == 1, sel != 0
		while(sel != 0) {
			System.out.println("============================");
			System.out.println("1) 검색");
			System.out.println("0) 종료");
			System.out.println("============================");
			Scanner sc = new Scanner(System.in);
			
			sel = sc.nextInt();
			// 검색을 선택한 경우에만 계속 검색...
			
			System.out.print("검색할 학생 이름을 입력하세요 : ");
			String name = sc.nextLine();
			
			// 1분단(group1), 2분단(group2)에서 검색
			for(int r=0; r<3; r++) {
				for(int c=0; c<2; c++) {
					if(group1[r][c].equals(name)) {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 %s에 있습니다.\n"
								, name, (r+1), (c == 0 ? "왼쪽" : "오른쪽") );
						break;
					} else if(group2[r][c].equals(name)) {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 %s에 있습니다.\n"
								, name, (r+1), (c == 0 ? "왼쪽" : "오른쪽") );
						break;
					}
				}
			}
		}
//		} while(sel == 1);
	}
}














