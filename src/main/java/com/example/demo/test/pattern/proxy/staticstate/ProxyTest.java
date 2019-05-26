package com.example.demo.test.pattern.proxy.staticstate;

/**
 * @program: testall
 * @Date: 2019/5/23 10:56
 * @Author: mistyle
 * @Description:
 */
public class ProxyTest {
	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}
}
