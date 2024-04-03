package com.kh;

public class Run {
	
	public static void main(String[] args) {
		String name = "박시아";
		int age = 8;
		String phone = "";
		
		String name2 = "김정아";
		int age2 = 18;
		String phone2 = "";
		
		
		
		Person kim = new Person("김아무개", 35, 175.4);
		
		System.out.println(kim.getName());
		
//		kim.printInfo();
		
		Person lee = new Person("이아무개");
		
//		lee.printInfo();
	}
}



