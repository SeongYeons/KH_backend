package com.kh.inherit;

public class GoldCustomer extends Customer {
	double saleRatio;
	// Customer 클래스로부터 상속을 받고
	
	// 고객등급: "GOLD", 적립율: 0.02, 할인율: 0.1 초기화
	//  고객ID, 고객이름을 전달받아서 초기화
	public GoldCustomer(String customerID, String customerName) {
		super(customerID, customerName);	// 부모클래스의 생성자 호출
		
		customerGR = "GOLD";
		ratio = 0.02;
		saleRatio = 0.1;
	}
	
	// 할인율을 계산해서 결과로 돌려주는 기능
	//  (적립금도 계산)
	//  메소드명: calcPrice
	// 오버라이딩 : 부모클래스의 메소드를 재정의
	@Override
	public int calcPrice(int price) {
		point += price*ratio;
		
		return price - (int)(price*saleRatio);
	}
}










