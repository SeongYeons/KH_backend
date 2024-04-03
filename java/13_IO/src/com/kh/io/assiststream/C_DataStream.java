package com.kh.io.assiststream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C_DataStream {
	
	public void fileSaveAndRead() {
		try (
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_data.txt"));
			DataInputStream dis = new DataInputStream(new FileInputStream("d_data.txt"))
		) {
			// 파일에 출력하기
			dos.writeUTF("홍길동");
			dos.writeInt(20);
			dos.writeDouble(173.3);
			dos.writeChar('M');
			dos.writeBoolean(false);
			
			// 파일에서 값을 읽어오기
			System.out.println("이름은 " + dis.readUTF());
			System.out.println("나이는 " + dis.readInt());
			System.out.println("키는 " + dis.readDouble());
			System.out.println("성별은 " + dis.readChar());
			System.out.println("결혼은 " + dis.readBoolean());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
