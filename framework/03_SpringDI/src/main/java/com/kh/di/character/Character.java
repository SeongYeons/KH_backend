package com.kh.di.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.di.weapon.Weapon;

import lombok.Getter;
import lombok.ToString;


/*
 * properties 파일의 값을 읽어오는 방법
 * 
 * 1. @PropertySource를 사용하는 방법
 *   - Environment 객체를 통해서 character.properties에
 *     설정된 값을 읽어온다.
 *   - 스프링 프로퍼티 플레이스 홀더를 통해서 character.properties에
 *     설정된 값을 읽어온다.
 * 
 * 2. @PropertySource를 생략하는 방법
 *   - xml 설정 파일을 사용하는 경우
 *     <context:property-placeholder/> 요소를 추가한다.
 *   - 자바 설정 파일을 사용하는 경우
 *     PropertySourcesPlaceholderConfigurer 빈을 생성한다.
 */
@Component
@Getter
@ToString
// @RequiredArgsConstructor
// @PropertySource("classpath:character.properties")
public class Character {
	// 스프링 프로퍼티 플레이스 홀더를 사용해서 
	// character.properties에 설정된 값을 읽어올 수 있다.
	@Value("${character.name:이몽룡}")
	private String name;
	
	@Value("${character.level:15}")
	private int level;
	
//	1. 필드를 통해서 빈을 주입받는 방법
	@Autowired(required = false)
	@Qualifier("sword")
	private Weapon weapon;
	
//	2. Setter 메소드를 통해서 빈을 주입받는 방법	
//	@Setter(onMethod_ = @Autowired)
//	private Weapon weapon;
	
	// @Autowired 생략 X (메소드 위에만 지정 가능)
//	@Autowired
//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}
	
//	3. 생성자를 통해서 빈을 주입받는 방법
//	private final Weapon weapon;
	
//	public Character(@Autowired Weapon weapon) {
//	public Character(Weapon weapon) { // @Autowired 생략 가능
//		this.weapon = weapon;
//	}
	
	// Environment 객체를 통해서 character.properties에
	// 설정된 값을 읽어올 수 있다.
//	public Character(/* @Autowired */ Environment env) {
//		this.name = env.getProperty("character.name");
//		this.level = Integer.parseInt(env.getProperty("character.level"));
//	}
}