package com.kh.io.assiststream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_ByteToCharStream {
	public void input() {
//		char[] arr = new char[10];
//		
//		try (InputStreamReader isr = 
//				new InputStreamReader(System.in)) {
//		
//			System.out.print("문자열 입력 > ");
//		
//			isr.read(arr);
//			
////			System.out.println(Arrays.toString(arr));
//			for (char c : arr) {
//				System.out.print(c);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try (BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("문자열 입력 > ");
			
			String value = br.readLine();
			
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void output() {
//		try (OutputStreamWriter osw = 
//				new OutputStreamWriter(System.out)) {
//			osw.write("한 시간 남았어요 :)");
//			osw.write("여러분 파이팅..!!^^");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try (BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(System.out))) {
					
			bw.write('한');
			bw.write('글');
			bw.newLine();
			bw.write("여러분 오늘도 파이팅..!!^^");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}