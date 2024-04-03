package com.kh.io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileByteStream {
	public void fileSave() {
		FileOutputStream fos = null;
//		byte[] arr = new byte[3];
//		
//		arr[0] = 99;
//		arr[1] = 100;
//		arr[2] = 101;
		
//		byte[] arr = new byte[] {99, 100, 101};
		byte[] arr = {99, 100, 101};
		
		System.out.println(Arrays.toString(arr));
		
		try {
//			fos = new FileOutputStream("a_byte.dat");
			fos = new FileOutputStream("a_byte.dat", true);
			
			fos.write(97); // a 문자가 저장
			fos.write('b');
			fos.write(10); // 줄바꿈 문자가 저장
			fos.write('c');
			fos.write(10); // 줄바꿈 문자가 저장
			fos.write(arr);
			fos.write(10); // 줄바꿈 문자가 저장			
			fos.write(arr, 1, 2);
			fos.write(10); // 줄바꿈 문자가 저장		
			// 한글은 2byte로 표현되기 때문에 
			// 바이트 단위 스트림으로는 제한이 있다.
			fos.write('한');
			fos.flush();
			
//			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 스트림을 사용했으면 반드시 닫아주어야 한다.
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		FileInputStream fis = null;
		byte[] arr = new byte[100];
		
		try {
			// 파일이 존재하지 않으면
			// FileNotFoundException 예외가 발생한다.
			fis = new FileInputStream("a_byte.dat");
			
//			System.out.println((char) fis.read());
//			System.out.println(fis.read());
			
//			read()가 2번 호출되기 때문에 정상적으로 값을 출력할 수 없다.
			
//			while (fis.read() != -1) {
//				System.out.print((char) fis.read());
//			}
			
//			int value = 0;
//			
//			while ((value = fis.read()) != -1) {
//				System.out.print((char) value);
//			}
			
//			int value = fis.read(arr);
			int value = fis.read(arr, 5, 10);
			
			System.out.println("읽어온 byte의 수 : " + value);
			System.out.println(Arrays.toString(arr));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
