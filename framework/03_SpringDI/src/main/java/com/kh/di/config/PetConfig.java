package com.kh.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kh.di.pet.Cat;
import com.kh.di.pet.Dog;

@Configuration
public class PetConfig {
	@Bean // 빈 ID를 지정해 주지 않으면 메소드명으로 ID를 지정한다.
	public Cat cat() {
		
		return new Cat("라떼");
	}
	
	@Bean
	@Primary // <bean primary="true"/>와 같다.
	public Dog dog() {
		Dog dog = new Dog();
		
		dog.setName("백구");
		
		return dog;
	}
}