package com.kh.loop;

public class Continue {
	/*
	 * 분기문 continue;
	 * : 반복문 안에서 수행되는 구문
	 * : continue; 실행 시 뒤에 구문들은 무시하고
	 *   증감식 또는 조건식으로 이동 => 반복문 처음부터 다시
	 */
	public void method1() {
		// 1부터 10까지 정수 중에 짝수 출력
		/*
		for(int i=1; i<=10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			
			System.out.println(i);
			
		}
		*/
		int i = 1;
		while(i<=10) {
			if(i % 2 != 0) {
				i++;
				continue;
			}
			System.out.println(i++);
		}
	}
	
	public void method2() {
		
		// 1 부터 100 까지 총 합계
		// 단, 3의 배수이거나 5의 배수는 합산에서 제외
		int total = 0;
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				continue;
			}
			
			total = total + i;
		}
		System.out.println("총 합계 : " + total);
	}
}




