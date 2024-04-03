package com.kh.io.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	// 파일 생성 테스트
	public void method1() {
		try {
			// 메모리상에만 존재하는 객체
			File file = new File("test.txt");
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("경로 : " + file.getAbsolutePath());
			System.out.println("파일 존재 여부 : " + file.exists());
			System.out.println("파일 여부 : " + file.isFile());
			System.out.println("폴더 여부 : " + file.isDirectory());
			
			// createNewFile() 메소드를 실행해야만 
			// 실제 파일이 만들어진다.
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 폴더 생성 후 파일 생성 테스트
	public void method2() {
		try {
			// 폴더 생성
//			File tempDir = new File("D:/temp");
			File tempDir = new File("D:/temp/demo");
			
			if (!tempDir.exists()) {
//				boolean result = tempDir.mkdir();
				boolean result = tempDir.mkdirs();
				
				System.out.println("폴더 생성 여부 : " + result);
			}
			
			// 존재하지 않는 경로를 제시하면 IOException이 발생한다.
//			File file = new File("D:/temp/test.txt");
			File file = new File("D:/temp/demo/test.txt");
		
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
