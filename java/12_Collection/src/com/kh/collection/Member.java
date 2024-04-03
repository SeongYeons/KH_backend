package com.kh.collection;

// * Set에서 사용하려면 Comparable(인터페이스)를 구현해야함
public class Member {//implements Comparable<Member> {
	
	private int memberId;		// 회원 고유번호
	private String memberName;	// 회원 이름
	
	// 생성자, 회원 번호와 이름을 전달받아 저장
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	// private 멤버변수 캡슐화 (getter, setter)
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	// Object 클래스 내 toString() 메소드를 오버라이딩
	@Override
	public String toString() {
		// 부모클래스(Object)의 toString() 메소드를 호출
//		return super.toString();
		
		// "[{회원번호}] {회원이름}"
		return "[" + memberId + "] " + memberName;
	}
	// ---------------------------------
	// Set 구조에서 중복 데이터 추가를 제어하는 부분
	@Override
	public int hashCode() {
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		// 클래스 인스턴스 타입 체크 : instanceof
		if (obj instanceof Member) {
			Member member = (Member)obj;
			// 고객번호와 고객명이 모두 다른 경우에만 추가?
			//   this.memberId == member.memberId
			//     || this.memberName == member.memberName
			if(this.memberId == member.memberId) {
				// HashSet 구조에서 중복 데이터로 판단하겠다.
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	// ---------------------------------
	// 정렬에 관련된 메소드: compareTo
//	@Override
//	public int compareTo(Member o) {
//		// 회원번호 기준으로 정렬 (오름차순)
//		return this.memberId - o.memberId;
//		// 회원번호 기준으로 정렬 (내림차순)
////		return (this.memberId - o.memberId) * (-1);
//		// 회원이름 기준으로 오름차순 정렬 > 다른 라이브러리 필요..
////		return this.memberName - o.memberName;
//	}
	
	
	
}







