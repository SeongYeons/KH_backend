package com.kh;

public class BankAccount00 {
	public static void main(String[] args) {
		// 인스턴스 생성. BankAccount 클래스를 사용하기 위한 준비
		BankAccount kim = new BankAccount();
		BankAccount lee = new BankAccount();
		
		int a = 10;
		int b = 20;
		
		// 입금 메소드. 5000씩 입금
		int money = kim.deposit(5000);
		lee.deposit(5000);
		
		// sc.nextLine();
		
		// 출금 메소드를 사용해서 kim 참조변수에서는 1500출금
		// lee 참조변수에는 3000출금
		
		// 이름, 나이, 핸드폰번호
		/*
		String name = "김아무개";
		int age = 30;
		String phone = "010-0000-0000";
		*/
	}
}






