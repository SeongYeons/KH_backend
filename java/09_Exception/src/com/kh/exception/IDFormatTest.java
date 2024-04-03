package com.kh.exception;

import java.util.Scanner;

public class IDFormatTest {
	// 변수: 사용자ID(문자열, '-' ->클래스 내부에서만 접근)
	//      비밀번호 (문자열, '-' -> 클래스 내부에서만 접근)
	private String userID;
	private String userPW;
	
	// 사용자ID getter 메소드
	public String getUserID() {
		return userID;
	}
	
	// 사용자ID setter 메소드
	//	[1] 전달받은 값이 null 인 경우에 저장하지 않고 
	//	    "아이디는 null일 수 없습니다." 출력
	//  [2] 전달받은 값의 길이가 8 이상 20 이하만 저장
	//		범위를 벗어날 경우, "아이디는 8자 이상 20자 이하로 쓰세요" 출력
	public void setUserID(String userID) throws IDFormatException {
		// 조건에 맞지 않은 경우 IDFormatException 예외 발생시키기
		//  throw new 예외클래스명();
		//  throw new IDFormatException();
		if(userID == null) {
//			System.out.println("아이디는 null 일 수 없습니다.");
			throw new IDFormatException("아이디는 null 일 수 없습니다.");
		} else if(userID.length() < 8 || userID.length() > 20) {
//			System.out.println("아이디는 8자 이상 20자 이하로 쓰세요.");
			throw new IDFormatException("아이디는 8자 이상 20자 이하로 쓰세요.");
		}
		
		this.userID = userID;
	}
	
	// 비밀번호 getter 메소드
	public String getUserPW() {
		return userPW;
	}
	// 비밀번호 setter 메소드
	//   - 길이 제한 : 8자 이상 ~ 20자 이하
	//	   범위를 벗어나면, "비밀번호 길이는 8자 이상 20자 이하여야 합니다." 
	//						내용과 함께 예외 발생
	//	 - 문자랑 숫자가 포함된 경우 저장
	//	   그렇지 않으면, "비밀번호는 문자와 숫자를 포함해야 합니다." 예외 발생
	//  예외 클래스 추가: PWFormatException
	public void setUserPW(String userPW) throws PWFormatException {
		if (userPW.length() < 8 || userPW.length() > 20) {
			// 예외 발생
			throw new PWFormatException("비밀번호 길이는 8자 이상 20자 이하여야 합니다.");
		// } else if (!(checkChar(userPW) && checkNumber(userPW))) {
		} else if (!checkChar(userPW) || !checkNumber(userPW)) {
			// !(checkChar: true && checkNumber: true)
			// => checkChar:false || checkNumber:false
			// => !checkChar || !checkNumber
			// a(b+c) = ab + ac
			// 예외 발생
			//  비밀번호에 문자만 있거나 > checkChar:true && checkNumber:false
			//	비밀번호에 숫자만 있거나 > checkChar:false && checkNumber:true
			//	비밀번호에 문자와 숫자 모두 없거나 > checkChar:false && checkNumber:false
			throw new PWFormatException("비밀번호는 문자와 숫자를 포함해야 합니다.");
		}
		
		this.userPW = userPW;
		
	}
	
	private boolean checkChar(String str) {
		boolean bContains = false;
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				// 문자가 소문자인지 확인
				bContains = true;
				break;
			} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				// 문자가 대문자인지 확인
				bContains = true;
				break;
			}
		}
		return bContains;
	}
	
	// 숫자(0 ~ 9)가 포함되어있는지 확인하는 메소드
	// str => 1q2w3e4r
	private boolean checkNumber(String str) {
		boolean bContains = false;
		for(int i=0; i<str.length(); i++) {
			// 1 (x) , '1' => 49 (O)
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				bContains = true;
				break;
			} 
		}
		return bContains;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 스캐너 클래스 인스턴스 생성
		IDFormatTest test = new IDFormatTest();	// IDFormatTest 인스턴스 생성
		
		String userID = null;					// 
		String userPW = null;
		
		do {
			try {
				
				System.out.print("아이디: ");
				userID = sc.nextLine();
				test.setUserID(userID);
				
				System.out.print("비밀번호: ");
				userPW = sc.nextLine();
				test.setUserPW(userPW);
				
			} catch(IDFormatException | PWFormatException e) {
				
				System.out.println("[Exception] " + e.getMessage());
				
			} /*catch(PWFormatException e) {
				
				System.out.println("[PWFormatException] " + e.getMessage());
				
			}*/
			// id 와 pw 모두 정상적으로 입력을 했을때 반복문 종료
			// id가 null이거나 pw도 null인 경우에는 반복문 진행
			//  test.getUserPW()
		} while(test.getUserID() == null || test.getUserPW() == null);
		/*
		try {
			String userID = null;
			test.setUserID(userID);
			System.out.println("현재ID: " + test.getUserID());
		} catch(IDFormatException e) {
			System.out.println("[IDFormatException] " + e.getMessage());
		}
		
		try {
			String userID2 = "123456";
			test.setUserID(userID2);
			System.out.println("현재ID: " + test.getUserID());
		} catch(Exception e) {
			System.out.println("[Exception] " + e.getMessage());
			e.printStackTrace();  // Exception 종류도 확인 가능!
		}
		*/
	}





}
