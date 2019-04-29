package com.example.demo.test.reflection;

/**
 * @program: testall
 * @Date: 2019/4/29 9:49
 * @Author: mistyle
 * @Description:
 */
public class Person {
	String name;
	private int age;
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

	//包含一个带参的构造器和一个不带参的构造器
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
}
