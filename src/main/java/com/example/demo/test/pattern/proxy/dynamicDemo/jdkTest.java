package com.example.demo.test.pattern.proxy.dynamicDemo;

import java.lang.reflect.Proxy;

/**
 * @program: testall
 * @Date: 2019/5/23 15:41
 * @Author: mistyle
 * @Description:
 */
public class jdkTest {
	public static void main(String[] args) throws Exception {
		PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(
				new PersonImpl());
		Person personProxy = (Person) Proxy.newProxyInstance(
				PersonImpl.class.getClassLoader(),
				PersonImpl.class.getInterfaces(), personInvocationHandler);
		personProxy.eat();
	}
}


