package com.kh.thread;

import com.kh.thread.practice.MyRunnable;
import com.kh.thread.practice.MyThread;

public class Application {

	public static void main(String[] args) {
		
		for (int i = 10; i <= 15; i++) {
		    System.out.println(i );
		}
		
		System.out.println("메인 스레드 실행");
		System.out.println(Thread.currentThread().getName());
		
		// 1. Thread 클래스를 상속받는 방법
		MyThread thread1 = new MyThread();
		
//		thread1.run();
		thread1.start();
		
		// 2. Runnable 인터페이스를 구현하는 방법
		Thread thread2 = new Thread(new MyRunnable());
		
		thread2.start();
		
		// 3. 익명 구현 객체
		//  [표현법]
		//    new 인터페이스() { ... 구현 내용 ... };
		//
		//    - 자바에서는 소스 파일을 만들지 않고도 구현 객체를 만들 수 있는 방법을 제공한다.
		//    - 중괄호({ .. })에는 인터페이스에 선언된 모든 추상 메소드들을 재정의해야 한다.
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					System.out.println(
						Thread.currentThread().getName() + "[" + i + "]"
					);
				}				
			}
		});
		
		thread3.start();
		
		// 4. 람다식을 통한 익명 구현 객체 (참고)
		Runnable runnable = () -> {			
			for (int i = 1; i <= 100; i++) {
				System.out.println(
					Thread.currentThread().getName() + "[" + i + "]"
				);
			}
		};
		
		Thread thread4 = new Thread(runnable);
		
		thread4.start();
		
		
		System.out.println("메인 스레드 종료");
	}
}
