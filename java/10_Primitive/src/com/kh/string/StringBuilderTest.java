package com.kh.string;

public class StringBuilderTest {

	public static void main(String[] args) {

		String str = new String("java");
		
		// String으로부터 StringBuilder를 생성
		StringBuilder builder = new StringBuilder(str);
		System.out.println("변경 전 builder의 주소 : " + 
							System.identityHashCode(builder));
		System.out.println(builder.toString());
		
		builder.append(" python");
		builder.append(" C");
		builder.append(" C++");
		
		System.out.println("변경 후 builder의 주소 : " + 
							System.identityHashCode(builder));
		
		System.out.println(builder.toString());
	}

}










