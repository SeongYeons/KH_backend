package com.kh.inherit;

public class Customer {
	// 멤버 변수: 고객ID(-), 고객이름(-), 고객등급(-), 포인트, 포인트적립율
	private String customerID;
	private String customerName;
	protected String customerGR;
	int point;
	double ratio;
	
	// 생성자: 멤버 변수를 초기화하기 위해 사용하는 메소드
	//        기본값은 public 클래스명() {}
	//        초기화할 값을 매개변수로 받아서 초기화할때
	//        public Customer(String customerName) {
	//            this.customerName = customerName;
	//        }
	//        public Customer(String customerName, String customerGR) {
	//            this.customerName = customerName;
	//			  this.customerGR = customerGR;
	//        }	
	//        Customer customer = new Customer("아무개");
	//  초기화 : 고객등급("SILVER"), 포인트적립율(0.01)
	public Customer() {
		init();
	}
	// 고객ID, 고객이름을 전달받아서 초기화하는 메소드(생성자)
	public Customer(String customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		
		init();
	}
	private void init() {
		customerGR = "SILVER";
		ratio = 0.01;
	}
	
	// 메소드
	// 캡슐화 : customerID, customerName, customerGR
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGR() {
		return customerGR;
	}
	public void setCustomerGR(String customerGR) {
		this.customerGR = customerGR;
	}
	
	//  (1) 적립 포인트 계산.
	//      금액을 전달 받아서 포인트적립율 기준으로 포인트 계산 후 포인트 변수에 저장. 
	//         금액 다시 결과로 반환
	//      메소드명: calcPrice
	//		매개변수명: price
	public int calcPrice(int price) {
		point += price*ratio;
		return price;
	}
	
	
	//  (2) 고객 정보를 결과로 반환
	//      "{고객명}님의 등급은 {고객등급} 이고, 보너스 포인트는 {포인트}입니다."
	//      메소드명: showCustomerInfo
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGR + " 이고, "
				+ "보너스 포인트는 " + point + "입니다.";
	}
}








