package com.kh.thread.practice;

/*
 * 스레드를 생성하는 방법
 * 
 * 1. Thread 클래스를 상속받는 방법
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		// 작업하고자 하는 코드를 작성한다.
		for (int i = 1; i <= 100; i++) {
			System.out.println(
				Thread.currentThread().getName() + "[" + i + "]"
			);
		}
	}
}
