package com.example.demo.test.pattern.proxy.dynamicDemo2;

/**
 * @program: testall
 * @Date: 2019/5/23 23:39
 * @Author: mistyle
 * @Description:
 */
public class Student  implements Person {
	private String name;
	public Student(String name) {
		this.name = name;
	}

	@Override
	public void giveMoney(String toObject) {
		try {
			//假设数钱花了一秒时间
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "上交班费50元给"+toObject);
	}
}
