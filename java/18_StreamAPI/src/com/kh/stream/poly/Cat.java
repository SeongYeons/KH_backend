package com.kh.stream.poly;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(this.name + "가 츄르를 먹는다.");
	}
}
