package com.kh.aop.character;

import com.kh.aop.weapon.Weapon;

import lombok.Data;

@Data
public class Character {
	private String name;
	
	private int level;
	
	private Weapon weapon;
	
	public String quest(String questName) {
		
//		if (true) {
//			throw new RuntimeException("존재하지 않는 퀘스트");
//		}
		
//		System.out.println(questName + " 퀘스트 진행 중..");
		
		return questName + " 퀘스트 진행 중..";
	}
	
	
	
	
	
	
	
	
	
}