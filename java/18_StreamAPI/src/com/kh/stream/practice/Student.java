package com.kh.stream.practice;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String name;
	
	private int age;
	
	private String gender;
	
	private int mathScore;
	
	private int englishScore;
	
	public Student() {
	}
	
	public Student(String name, int age) {
		this(name, age, "남자", 30, 30);
	}

	public Student(String name, int age, String gender, int mathScore, int englishScore) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
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
		if(age < 0) {
			this.age = 0;
		}
		
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	
	public double avg() {
		return (this.mathScore + this.englishScore) / 2.0;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, englishScore, gender, mathScore, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && englishScore == other.englishScore && Objects.equals(gender, other.gender)
				&& mathScore == other.mathScore && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Student obj) {
		// 자신과 매개값으로 주어진 객체를 비교하여
		// 같으면 0, 자신이 크면 양수, 자신이 작으면 음수를
		// 반환하도록 구현하면 된다.
		
		System.out.println(this.name + ", " + obj.name + ", " + (this.age - obj.age));
		
		return this.age - obj.age;
	}
}