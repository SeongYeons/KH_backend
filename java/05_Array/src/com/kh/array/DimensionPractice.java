package com.kh.array;

public class DimensionPractice {
	/*
	 * 2차원 배열: 자료형이 같은 1차원 배열의 묶음.
	 *           배열 안에 다른 배열이 존재.
	 *           인덱스 2개 필요 (앞에는 행, 뒤에는 열)
	 *           ※ 인덱스(index): 0부터 시작. 배열에서 위치를 가르키는 숫자
	 *           
	 * [선언 방법]
	 *   자료형[][] 배열이름 = new 자료형[행길이][열길이];
	 *   
	 * - 2차원 배열에 값을 저장하는 방법
	 *   배열이름[행 인덱스][열 인덱스] = 값;
	 * - 2차원 배열에서 값을 참조하는 방법
	 *   배열이름[행 인덱스][열 인덱스]
	 *   
	 * - 2차원 배열 초기화하는 방법
	 *   * 자료형[][] 배열이름 = { 1차원 배열1, 1차원 배열2, 1차원 배열3, ...};
	 *   
	 * - 가변 배열 선언 방법: 열 크기를 지정하지 않고, 각각 다른 길이의 1차원 배열을 생성
	 *   * 자료형[][] 배열이름 = new 자료형[행길이][];
	 */
	public void practice1() {
		// 행의 길이 2, 열의 길이 3인 정수형 2차원 배열
		final int ROW = 2;
		final int COL = 3;
		
		int[][] numbers = new int[ROW][COL];
		// (행의 인덱스+열의 인덱스)의 연산 결과를 데이터로 저장
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				numbers[i][j] = i+j;
			}
		}
		
		// 2차원 배열에서 foreach문 사용
		// (0, 0) (0, 1) (0, 2)
		// (1, 0) (1, 1) (1, 2)
		// numbers = { 
		//            {0, 1, 2}, 
		//            {1, 2, 3}
		//           }
		System.out.println("----- foreach문 사용 -----");
		for(int[] num : numbers) {
			for(int n : num) {
				System.out.print(n + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("----- 인덱스 사용 -----");
		// 행과 열의 인덱스로 출력
		//  2차원 배열 이름: numbers
		for(int i=0; i<ROW; i++) {		// 행의 인덱스 제어
			for(int j=0; j<COL; j++) {	// 열의 인덱스 제어
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("---- 마지막 위치부터 출력 ----");
		// ROW=2, COL=3
		// (1, 2) (1, 1) (1, 0)
		// (0, 2) (0, 1) (0, 0)
		for(int i=ROW-1; i >= 0; i--) {
			for(int j=COL-1; j >= 0; j--) {
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}














