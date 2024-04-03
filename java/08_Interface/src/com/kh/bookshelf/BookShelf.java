package com.kh.bookshelf;

public class BookShelf extends Shelf implements Queue {
	/* Shelf 클래스를 상속받고,
	 *   Queue 인터페이스를 구현
	 *    [1] enQueue : shelf 배열에 전달받은 값을 추가
	 *    [2] deQueue : shelf 배열에 첫번째 위치의 값을 
	 *                  제거하여 그 값을 반환
	 *    [3] getSize : getCount() 호출하여 그 결과를 반환 
	 */
	@Override
	public void enQueue(String title) {
		super.shelf.add(title);
	}
	@Override
	public String deQueue() {
		// remove: 해당 위치의 값을 제거하고, 그 값을 결과로 반환함.
		return shelf.remove(0);	
	}
	@Override
	public int getSize() {
		int count = getCount();
		return count;
	}
}







