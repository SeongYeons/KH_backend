package com.kh.thread.practice;

/*
 * 스레드를 생성하는 방법
 * 
 * 2. Runnable 인터페이스를 구현하는 방법
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(
				Thread.currentThread().getName() + "[" + i + "]"
			);
		}
	}
}
