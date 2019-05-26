package com.example.demo.test.pattern.proxy.staticstate;

/**
 * @program: testall
 * @Date: 2019/5/23 10:55
 * @Author: mistyle
 * @Description:
 */
public class Source  implements Sourceable {

	@Override
	public void method() {
		System.out.println("the original method!");
	}
}
