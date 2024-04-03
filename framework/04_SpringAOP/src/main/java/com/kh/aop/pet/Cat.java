package com.kh.aop.pet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.aop.annotation.NoLogging;

@Component
public class Cat extends Pet {
	
	public Cat(@Value("야옹이") String name) {
		this.name = name;
	}

	@Override
	@NoLogging
	public String bark() {
		
		return "야옹";
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
}
