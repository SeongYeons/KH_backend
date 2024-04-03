package com.kh.wrapper;

public class IntegerTest {

	public static void main(String[] args) {

		// Integer 클래스 선언하고 100을 저장
		Integer num = 100;
		int iNum = num.intValue();
		
		System.out.println(num);
		System.out.println(iNum);

		int jNum = 200;
		int sum = iNum + jNum;
		System.out.println(sum);
		
		System.out.println(num + jNum); 	// num => num.intValue()
											// num.intValue() + jNum
											// => 오토 언박싱
		Integer i = jNum;
		System.out.println(i); 		// Integer.valueOf(jNum)
		
		
		String zero = "0";
		// 정수형 변환
		System.out.println(Integer.parseInt(zero) == 0);
		System.out.println(Integer.parseInt(zero));
		/*
		 * 
		String a = "1234";
		int nA = Integer.parseInt(a);	// 문자열을 정수형으로 바꿔주는
		 */
	}

}







