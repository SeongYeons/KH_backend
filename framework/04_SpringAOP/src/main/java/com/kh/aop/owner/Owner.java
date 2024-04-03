package com.kh.aop.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.aop.pet.Pet;

@Component
public class Owner {
	@Value("김철수")
	private String name;
	
	@Value("16")
	private int age;
	
	@Autowired
	@Qualifier("cat")
	private Pet pet;

	public Owner() {
	}	
	
	public Owner(String name, int age, Pet pet) {
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", age=" + age + ", Pet=" + pet + "]";
	}
}
