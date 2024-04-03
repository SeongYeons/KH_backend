package com.kh.io.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharStream {
	public void fileSave() {
		char[] arr = new char[] {'a', 'p', 'p', 'l', 'e'};
		
		// try-with-resource 구문을 통해서 
		// 리소스를 자동으로 close() 시킨다.
		try (FileWriter fw = new FileWriter("b_char.txt", true)) {
			fw.write("안녕하세요.");
			fw.write("만나서 반갑습니다.");
			fw.write('\n');
			fw.write('한');
			fw.write('\n');
//			fw.write(new char[]{'a', 'p', 'p', 'l', 'e'});
			fw.write(arr);
			fw.write('\n');
			fw.write(arr, 1, 2);
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public void fileRead() {
		try (FileReader fr = new FileReader("b_char.txt")) {
			int value = 0;

			while ((value = fr.read()) != -1) {
				System.out.print((char) value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//  가변인자
	public void sum(int ... arr) {
//	public void sum(int[] arr) {
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		
		System.out.println(result);
	}
}









