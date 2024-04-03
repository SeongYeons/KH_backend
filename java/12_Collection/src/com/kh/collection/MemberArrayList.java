package com.kh.collection;

import java.util.ArrayList;

public class MemberArrayList {
	
	// ArrayList를 사용해서 Member타입의 배열 변수 선언
	private ArrayList<Member> memberList;
	
	// 생성자, memberList 배열의 인스턴스 생성
	public MemberArrayList() {
		memberList = new ArrayList<Member>();
	}
	
	// (메소드) Member 객체를 매개변수로 받아서, 
	//	memberList 배열에 데이터를 추가 (add())
	public void addMember(Member m) {
		// 매개변수: Member 타입의 m이라는 이름으로 정의
		memberList.add(m);	// memberList의 add 메소드 사용하여
							// 전달받은 m 데이터(인스턴스) 추가
	}
	
	// (메소드) 회원 번호를 매개변수로 받아서,
	//	memberList 배열에 있는 데이터인 경우 해당 데이터 제거
	//	데이터를 제거한 경우 true 반환, 그렇지 않은 경우 false 반환
	//  제거된 항목이 없는 경우 "{memberId}가 존재하지 않습니다." 출력
	//		* ArrayList 데이터 제거: remove({인덱스, 객체})
	//		* ArrayList 데이터 조회: get()
	//		* ArrayList 데이터 길이: size()
	public boolean removeMember(int memberId) {
		// memberList=[1, 2, 3]  |    memberId=459
		for(int i=0; i<memberList.size(); i++) {
			Member m = memberList.get(i);
			if(m.getMemberId() == memberId) {
				memberList.remove(i);
				return true; 	// 메소드를 종료하고 true값을 반환
			}
		}
		
		// memberList 안에서 memberId 값을 찾지 못한 경우
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	// (메소드) 배열에 저장된 데이터 모두 출력
	public void printAll() {
		// ArrayList<Member> memberList;
		//  for-each문
		//		for({배열아이템데이터타입} {변수명}:{배열명}) 
		for(Member m:memberList) {
			System.out.println(m);	// m.toString() 호출
		}
	}
	
	public static void main(String[] args) {
		MemberArrayList members = new MemberArrayList();
		
		// addMember(Member m)
		//	메소드의 매개변수가 클래스타입이면,
		//		메소드를 호출할 때 인자 값으로 인스턴스를 전달.
		members.addMember(new Member(10, "장나라"));
		members.addMember(new Member(20, "홍길동"));
		
		members.printAll(); // 기존에는 객체의 주소값이 표시되었으나,
							// Member 클래스에서 toString() 메소드를
							// 오버라이딩하여 원하는 정보를 출력하도록 재정의.
		
		System.out.println(members.removeMember(0));  // false
		System.out.println(members.removeMember(10)); // true?
		
		members.printAll();
	}
}













