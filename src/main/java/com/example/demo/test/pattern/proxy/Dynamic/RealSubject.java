package com.example.demo.test.pattern.proxy.Dynamic;

/**
 * @program: testall
 * @Date: 2019/4/29 9:41
 * @Author: mistyle
 * @Description:
 */
public class RealSubject implements Subject {
	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str) {
		System.out.println("hello: " + str);
	}

}
