package com.kh.bookshelf;

public class BookShelfTest {
	
	public static void main(String[] args) {
		Queue shelfQueue = new BookShelf();
		
		shelfQueue.enQueue("자바의 정석");
		shelfQueue.enQueue("객체지향의 사실과 오해");
		shelfQueue.enQueue("이웃집 백만장자");
		
		System.out.println("현재 책장에 책은 " + 
		                    shelfQueue.getSize() +"권 입니다.");
		
		int size = shelfQueue.getSize();
		for(int i=0; i<size; i++) {
			System.out.println(shelfQueue.deQueue());
			System.out.println("현재 책장에 책은 " + 
                    shelfQueue.getSize() +"권 입니다.");
		}
		
	}
	
}





