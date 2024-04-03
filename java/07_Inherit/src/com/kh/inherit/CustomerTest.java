package com.kh.inherit;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		// ArrayList(p.222) : Customer 클래스 배열 생성
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		// 클래스 인스턴스 생성
		// 일반 고객(Customer) : 2명 (ID, 이름) : ("10010", "이순신")
		//                                    ("10020", "신사임당")
		// GOLD고객(GoldCustomer) : 2명 (ID, 이름) : ("10030", "홍길동")
		//                                        ("10040", "김유신")
		Customer cLee = new Customer("10010", "이순신");
		Customer cShin = new Customer("10020", "신사임당");
		Customer gHong = new GoldCustomer("10030", "홍길동");
		Customer gKim = new GoldCustomer("10040", "김유신");
		
		// 생성한 인스턴스를 Customer 클래스 배열에 추가
		customerList.add(cLee);
		customerList.add(cShin);
		customerList.add(gHong);
		customerList.add(gKim);
		
		System.out.println("========= 고객 정보 출력 =========");
		// showCustomerInfo() 활용하여 출력
		for(Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}
		
		System.out.println("========= 할인율과 적립금 계산 ========");
		int price = 10000;
		// 할인율과 적립금 계산 후
		//  "{고객이름} 님이 {price}을 지불했습니다." 출력
		//  "{고객이름} 님의 현재 적립금은 {...} 입니다." 출력
		for(Customer customer : customerList) {
			System.out.printf("%s님이 %d을 지불했습니다.\n", customer.getCustomerName(), customer.calcPrice(price));
			System.out.printf("%s님의 현재 적립금은 %d입니다.\n", customer.getCustomerName(), customer.point);
		}
	}

}










