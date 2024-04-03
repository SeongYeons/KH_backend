package com.kh.generics;

import java.util.ArrayList;

// 제네릭 클래스 : 타입 매개변수 1개
class MyArray<E> {	// 모든 타입을 허용(사용), 데이터타입: E
	private Object[] array = new Object[10];
	
	int i;

	/*	배열 타입을 변경할 경우,
	 * 		생성자를 통해 인스턴스를 생성하도록 변경.
	 * 	이렇게 하면, get 메소드에서 강제형변환을 하지 않아도 됨.
	ArrayList<E> arr;
	MyArray() {
		arr = new ArrayList<E>();
	}
	*/
	
	// [1] 배열에 추가. E 타입의 매개변수를 받아
	//		i번째에 대입하고, i값을 증가하는 메소드
	//		- 메소드명 : add
	public void add(E e) {	// E는 어떤 타입인지는 모르나,
							// MyArray클래스가 생성될때 정해짐.
		array[i++] = e;	// array 배열에 i번째 위치에
						// 매개변수로 받은 e 데이터 대입	
						// 대입 후에 i 값 1증가
		//i++;
	}
	
	// [2] 인덱스를 매개변수로 받아서, 배열(array)에서 
	//		인덱스 위치의 데이터를 결과 값으로 반환하는 메소드
	//		- 메소드명 : get
	//		* 인덱스: 위치를 의미. 0부터 시작. 정수형.
	public E get(int idx) { // E 타입의 데이터를 반환
					// int(정수형) idx 매개변수를 받는 get 메소드
		// 배열에서 idx 위치의 데이터를 결과로 반환
		return (E)array[idx];
	}
	
}


public class ArrayTest {

	public static void main(String[] args) {
		// ** MyArray<E> **
		// ArrayList<String> a = new ArrayList<String>();

		MyArray<String> ma1 = new MyArray<String>();
		// String : 클래스
		//  클래스를 매개변수로 한다는 건, 
		//		호출할 때(인자값으로 전달할때) 인스턴스화하여 전달.
		ma1.add(new String("Hi"));
		String data1 = ma1.get(0);
		System.out.println(data1);
		
		MyArray<Integer> m2 = new MyArray<Integer>();
		m2.add(new Integer(20));
		Integer data2 = m2.get(0);
		System.out.println(data2);
	}

}







