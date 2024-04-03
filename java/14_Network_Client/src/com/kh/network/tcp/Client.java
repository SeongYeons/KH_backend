package com.kh.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	/*
	 * 클라이언트용 TCP 소켓 프로그래밍 순서
	 * 
	 * 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
	 * 2. 서버와의 입출력 스트림 오픈
	 * 3. 보조 스트림을 통해 성능 개선
	 * 4. 스트림을 통해 읽고 쓰기
	 * 5. 통신 종료
	 */
	public void clientStart() {
		// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		String serverIp = "192.168.40.3";
		int port = 30021;
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			socket = new Socket(serverIp, port);
			
			if (socket != null) {
				// 2. 서버와의 입출력 스트림 오픈
				// 3. 보조 스트림을 통해 성능 개선
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(), true);
				
				// 4. 스트림을 통해 읽고 쓰기
				Scanner scanner = new Scanner(System.in);
				
				do {
					System.out.print("서버에 보낼 내용 : ");
					String message = scanner.nextLine();
					
					pw.println(message);
					
					if (message == null || "exit".equals(message)) {
						System.out.println("접속 종료");
						
						break;
					}
					
					System.out.println("받은 메세지 : " + br.readLine());
				} while(true);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5. 통신 종료
			try {
				pw.close();
				br.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

