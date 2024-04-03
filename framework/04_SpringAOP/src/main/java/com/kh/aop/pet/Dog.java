package com.kh.aop.pet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Dog extends Pet {
	
	public Dog(@Value("멍멍이") String name) {
		this.name = name;
	}

	@Override
	public String bark() {
		
		return "멍멍";
	}
	
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
}
