package com.kh.string;

public class StringTest {
	
	public static void main(String[] args) {
		
		String str1 = new String("apple");
		String str2 = new String("apple");
		
//		if(str1 == "apple") {}
//		System.out.println(str1 == str2); 		// false
//		System.out.println(str1.equals(str2));  // true
		
		String str3 = "samsung";
		String str4 = "samsung";

		
//		System.out.println(str3 == str4); 		// false? => true
//		System.out.println(str3.equals(str4));  // true
		
		String str5 = new String("java");
		String str6 = new String("python");
		
		System.out.println(str5);
		System.out.println("처음 문자열 주소 값: " +
							System.identityHashCode(str5));
		
		str5 = str5.concat(str6);	// concat : 문자열을 연결해주는 메소드
									// javapython
		
		System.out.println(str5);
		System.out.println("연결 후 문자열 주소 값: " +
							System.identityHashCode(str5));
		
		// 문자열 값 수정 불가능.
		
	}
}








