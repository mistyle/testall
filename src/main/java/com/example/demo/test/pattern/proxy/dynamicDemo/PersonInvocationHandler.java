package com.example.demo.test.pattern.proxy.dynamicDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: testall
 * @Date: 2019/5/23 15:40
 * @Author: mistyle
 * @Description:
 */
public class PersonInvocationHandler implements InvocationHandler {

	private Object obj;

	public PersonInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before time to eat");
		method.invoke(obj, args);
		System.out.println("after time to eat");
		return null;
	}

}
