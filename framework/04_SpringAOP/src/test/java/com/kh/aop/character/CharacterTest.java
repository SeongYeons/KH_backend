package com.kh.aop.character;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
	locations = "classpath:spring/root-context.xml"
)
class CharacterTest {
	@Autowired
	private Character character;

	@Test
	@Disabled
	void test() {
	}
	
	@Test
	void create() {
//		System.out.println(character);
		
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
	
	@Test
	void questTest() {
		
		assertThat(character.quest("도토리 50개 줍기"))
			.isNotNull().contains("도토리");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
