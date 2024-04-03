package com.kh.example;

import java.io.FileInputStream;

public class ExceptionTest {
	public static void main(String[] args) {
		// unchecked exception
		try {
			System.out.println( 3 / 0 );
		} catch(Exception e) {
			System.out.println("Exception 발생" + e.getMessage());
		}
//		int n = 0;
//		if (n != 0) {
//			System.out.println( 3 / n );
//		}
		String filename = "";
//		try {
//			FileInputStream fi = new FileInputStream(filename);
//		} catch(Exception e) {
//			
//		}
		
		
	}
}
