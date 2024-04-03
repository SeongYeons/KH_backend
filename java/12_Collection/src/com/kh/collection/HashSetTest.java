package com.kh.collection;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Member> hMem = new HashSet<Member>();
		
		hMem.add(new Member(1000, "qwer"));
		hMem.add(new Member(1002, "asdf"));
		hMem.add(new Member(1003, "aaaa"));
		
		System.out.println(hMem);
		
		hMem.add(new Member(1004, "zzz"));
		
		System.out.println(hMem);
	}
}
