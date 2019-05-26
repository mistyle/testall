package com.example.demo.test.pattern.proxy.staticstate;

/**
 * @program: testall
 * @Date: 2019/5/23 10:55
 * @Author: mistyle
 * @Description:
 */
public class Proxy  implements Sourceable {

	private Source source;
	public Proxy(){

		this.source = new Source();
	}
	@Override
	public void method() {
		before();
		source.method();
		atfer();
	}
	private void atfer() {
		System.out.println("after proxy!");
	}
	private void before() {
		System.out.println("before proxy!");
	}
}