package com.example.demo.test.extendtest;

/**
 * @program: testall
 * @Date: 2019/5/22 18:49
 * @Author: mistyle
 * @Description:
 */
public class City  extends Country {
	String name;

	void value() {
		name = "Shanghai";
		//super.value();      //调用父类的方法
		super.name="guangzhou";
		System.out.println(name);
		System.out.println(super.name);
	}

	public static void main(String[] args) {
		City c = new City();
		c.value();

	}
}
