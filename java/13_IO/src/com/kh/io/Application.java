package com.kh.io;

import com.kh.io.assiststream.D_ObjectStream;

public class Application {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");

//		File 클래스 테스트
//		new FileTest().method1();
//		FileTest fileTest = new FileTest();
		
//		fileTest.method1();
//		fileTest.method2();
		
//		FileInputStream, FileOutputStream 테스트
//		new FileByteStream().fileSave();		
//		new FileByteStream().fileRead();
		
//		FileReader, FileWriter 테스트
//		new FileCharStream().fileSave();
//		new FileCharStream().fileRead();
				
		// 가변인자
//		new FileCharStream().sum(5, 10, 20);
//		new FileCharStream().sum(6, 4);
//		new FileCharStream().sum();
		
		// 문자 변환 보조 스트림 테스트
//		new A_ByteToCharStream().input();
//		new A_ByteToCharStream().output();
		
		// 성능 향상 보조 스트림 테스트
//		new B_BufferedStream().fileSave();
//		new B_BufferedStream().fileRead();
		
		// 기본 타입 입출력 보조 스트림 테스트
//		new C_DataStream().fileSaveAndRead();

		// 객체 입출력 보조 스트림
		new D_ObjectStream().fileSave();
		new D_ObjectStream().fileRead();
		
		System.out.println("프로그램 종료");
	}
}