package com.kh.di.character;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.di.config.RootConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
//	locations = "classpath:spring/root-context.xml"
	classes = RootConfig.class
)
class CharacterTest {
	/*
	 * @Autowired에서 required 속성은 빈 주입이 필수로 되어야 하는지
	 * 설정하는 옵션이다. (기본값: true)
	 *   - required가 true일 경우 주입해야 하는 빈이 존재하지 않으면 
	 *     예외를 발생 시킨다.
	 *   - required가 false일 경우 주입해야 하는 빈이 존재하지 않으면
	 *     null을 주입한다.
	 */
	@Autowired(required = false)
	private Character character;

	@Test
	@Disabled
	void test() {
	}
	
	@Test
	void create() {
		System.out.println(character);
		
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
}