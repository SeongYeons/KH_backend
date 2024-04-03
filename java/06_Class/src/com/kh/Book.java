package com.kh;

public class Book {
	/*
	 * 추상화
	 * [1] 제목, 지은이(저자), 번호, 가격, 표지색상, 대출여부, 카테고리,
	 * 페이지 수 알려주기, 대출여부 조회, 책 정보 조회, ...
	 * [2] (x) => 표지 색상
	 * [3]
	 * // 변수 정의
	 * String title;
	 * String author;
	 * int number;
	 * int price;
	 * String borrow;
	 * String category;
	 * int pageNumber;
	 * // 메소드 정의
	 * public int getPageNumber() {};
	 * public String getBorrow() {};
	 * public void getBookInfo() {};
	 */
	// 멤버 변수(데이터)
	private String title;		// 책 제목
	private String author;		// 저자명
//	private static int number=1;// 고유 번호
	private int price;			// 책 가격
	String borrow;				// 대출 여부: 대출중, 보관중
	String category;			// 카테고리
	int pageNumber;				// 페이지 수
	private int currNumber;		// 고유 번호
	static String info = "책";
	
	// 메소드 (기능)
	//  title getter 메소드 정의
	//  제공 기능: title 변수가 저장한 값을 결과로 전달
	public String getTitle() {	
		return title;
	}
	//  title setter 메소드 정의
	//  제공 기능: 전달받은 값을 title 변수에 대입
	public void setTitle(String title) {
		// this : 클래스 내부에서 다음에 연결되는 멤버를 찾음
		this.title = title;
	}
	//  author getter 메소드 정의
	public String getAuthor() {
		return author;
	}
	//  author setter 메소드 정의
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//  currNumber getter 메소드 정의
	public int getCurrNumber() {
		return currNumber;
	}
	/*
	//  number setter 메소드 정의
	public void setNumber(int number) {
		this.number = number;
	}
	*/
	
	//  price getter 메소드 정의
	public int getPrice() {
		return price;
	}
	//  price setter 메소드 정의
	public void setPrice(int price) {
		this.price = price;
	}
	/*
	 * public int getPageNumber() {};
	 * public String getBorrow() {};
	 * public void getBookInfo() {};
	 */
	// 페이지 수 알려주는 메소드
	public int getPageNumber() {
		System.out.println("페이지 수 : " + pageNumber);
		return pageNumber;
	}
	// 대출 여부를 알려주는 메소드
	public String getBorrow() {
		return borrow;
	}
	// 책 정보를 출력해주는 메소드
	public void getBookInfo() {
		println("================");
		println("책 제목: " + title);
		println("저자: " + author);
		println("고유번호: " + currNumber);
		println("가격: " + price);
		println("페이지 수: " + pageNumber);
		println("카테고리: " + category);
		println("대출 여부: " + borrow);
		println("================");
	}
	
	// 클래스 내부에서 출력함수 사용
	private void println(String msg) {
		System.out.println(msg);
	}
	
	// 고유번호를 관리하는 메소드
	public void addNumber() {
		BookNumber bn = BookNumber.getInstance();
		System.out.println(bn);
		currNumber = bn.number;
		bn.addNumber();
	}
}











