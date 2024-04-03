package com.kh.lambda.practice;

public class A_Lambda {
	public void method1() {
		Thread thread;
		Runnable runnable;
		
		runnable = new Runnable() {
			
			public void run() {
				System.out.println("익명 구현 객체를 사용한 스레드 생성");
			}
		};
		
		thread = new Thread(runnable);
		
		thread.start();
		
//		runnable = () -> {
//			System.out.println("람다식을 사용한 스레드 생성");
//		};
		
		runnable = () -> System.out.println("람다식을 사용한 스레드 생성");
		
		thread = new Thread(runnable);
		
		thread.start();
	}
}
