package com.kh.collection;

import java.util.TreeMap;

public class MemberTreeMap {
	// TreeMap : key-value.
	//			 Key를 기준으로 데이터 정렬할 때 주로 사용
	// [멤버 변수]
	// TreeMap 컬렉션클래스타입.
	//		Key: 정수형, Value: Member
	//		(-)treeMap
	private TreeMap<Integer, Member> treeMap;
	
	// [생성자]
	//		treeMap 인스턴스 생성 및 참조변수 연결
	public MemberTreeMap() {
		treeMap = new TreeMap<Integer, Member>();
	}
	
	// [메소드]
	//	[1] 데이터 추가. 매개변수: Member타입 데이터.
	//		TreeMap 데이터추가: put(Key값-고객번호, Value값-고객 객체)
	public void add(Member member) {
		treeMap.put(member.getMemberId(), member);
	}
	
	//  [2] 데이터 삭제. 매개변수: 고객번호. Map에 데이터가 있는 경우 삭제.
	//		결과: T(삭제 성공), F(삭제하지 않았을 때)
	//		TreeMap도 HashMap처럼 containsKey, remove 메소드 사용
	public boolean delete(int memberId) {
		if (treeMap.containsKey(memberId)) {
			treeMap.remove(memberId);
			return true;
		}
		
		System.out.println(memberId + "가 없습니다.");
		return false;
	}
	
	//  [3] 전체 데이터 출력.
	public void printAll() {
		for(int memberId: treeMap.keySet()) {
			System.out.println(treeMap.get(memberId));
		}
	}
	
	

	public static void main(String[] args) {
		MemberTreeMap mtp = new MemberTreeMap();
		
		mtp.add(new Member(1000, "김이나"));
		mtp.add(new Member(1001, "아이유"));
		mtp.add(new Member(1002, "이지금"));
		
		mtp.printAll();
		
		System.err.println("-----------");
		mtp.delete(1001);
		
		mtp.printAll();

	}

}
