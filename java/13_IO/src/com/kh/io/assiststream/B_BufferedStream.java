package com.kh.io.assiststream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B_BufferedStream {
	public void fileSave() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt", true))) {
			bw.write("안녕하세요.");
			// BufferedWriter가 제공하는 메소드
			// 개행할 때 사용한다.
			bw.newLine(); 
			bw.write("줄바꿈이 적용되었나요?");
			bw.newLine(); 
			bw.write("IO 쉽죠..??");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
			String value = null;
			
			// BufferedReader에서 제공하는 메소드
			// 파일에서 한 줄을 읽어올 때 사용한다.
//			value = br.readLine();
//			System.out.println(value);
//			
//			value = br.readLine();
//			System.out.println(value);
			
			while ((value = br.readLine()) != null) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
