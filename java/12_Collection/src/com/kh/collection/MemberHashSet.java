package com.kh.collection;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
	// 내부접근만 허용(private)한 HashSet<Member> 타입의 
	//		hashSet 멤버변수 선언
	private HashSet<Member> hashSet;
	
	// 생성자
	//	선언한 hashSet에 인스턴스 생성(new)
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	// 메소드
	//	[1] 멤버 추가 기능 : +addMember
	//			클래스 다이어그램=> + (public)
	//						    - (private)
	//							# (protected)
	//			Member객체를 매개변수로 받아서 hashSet에 추가
	public void addMember(Member m) {
		hashSet.add(m);
	}
	
	//  [2] 멤버 제거 기능 : +removeMember
	//			저장된 데이터 중 매개변수로 받은 
	// 				memberid 값이 있는 경우 제거
	//		* Iterator : Collection에서 요소(데이터)를 순회
	//			- [선언] : Iterator<콜렉션클래스에 사용된 데이터타입> 변수명
	//						= 콜렉션클래스참조변수.iterator();
	//					ex) Iterator<Member> itr = hashSet.iterator();
	//			- boolean hasNext() | 이후에 데이터가 더 있는지 체크 메소드
	//			- E next()			| 다음에 있는 데이터를 반환
	public boolean removeMember(int memberId) {
		// 배열에서는 위치를 찾을 때 > 인덱스(index, int)
		// iterator: 데이터구조(컬렉션)에서 위치를 찾을 때 사용하는 방법
		// Iterator<콜렉션클래스에 사용된 데이터타입> 변수명
		//						= 콜렉션클래스참조변수.iterator();
		Iterator<Member> itr = hashSet.iterator();
		
		while(itr.hasNext()) {	// hasNext(): 다음 데이터가 있는지 체크
			Member member = itr.next();	// next(): 데이터를 꺼내오는 것
			
			itr.remove();
			
			if (member.getMemberId() == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 없습니다.");
		return false;
	}
	
	//  [3] 멤버 데이터 전체 출력
	public void printAll() {
		// hashSet에 저장된 데이터를 모두 출력
		//  - for-each
		//    for(데이터타입 변수명 : 컬렉션클래스 참조변수)
		for(Member m : hashSet) {
			System.out.println(m); // m.toString() 자동으로 호출됨
		}
	}
	
	

	public static void main(String[] args) {
		MemberHashSet memberHS = new MemberHashSet();
		
		// 클래스 객체가 매개변수면,
		//		인자 값으로는 "인스턴스(생성)" 전달해야 한다.
		memberHS.addMember(new Member(1000, "이강인"));
		Member m1 = new Member(1001, "손흥민");
		memberHS.addMember(m1); // m1이 전달되는 것은
				//   new Member(1001, "손흥민")을 전달되는 것과 동일
//		memberHS.addMember("김남길");	// 잘못된 접근 방법!
		
		// 번외,
		//	Member -> String
		//	memberHS.addMember(new String("123"));
		
		memberHS.printAll();
		System.out.println("--------------------");
		memberHS.addMember(new Member(1002, "손흥민"));
		
		memberHS.printAll();
	}

}






