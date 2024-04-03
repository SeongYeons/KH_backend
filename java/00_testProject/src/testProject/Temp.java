package testProject;

import java.util.Arrays;
import java.util.ArrayList;

public class Temp {

	public static void main(String[] args) {
		ArrayList<String> book = new ArrayList<String>();
		
		book.add("객체 지향의 사실과 오해");
		book.add("탈무드");
		
		for (String name : book) {
			System.out.println(name);
		}
	}
	
	public static void test1() {
		int[] arr1 = {1, 2, 3, 4};	// 데이터길이 : 4
		int[] arr2 = new int[2];	// 데이터길이 : 2
		
		// arr2 = Arrays.copyOf(arr1, arr1.length);
//		arr2 = arr1.clone();

		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

}
