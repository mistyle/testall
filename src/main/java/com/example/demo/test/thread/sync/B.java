package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/4/27 22:06
 * @Author: mistyle
 * @Description:
 */
public class B {
	//修饰非静态方法拿到对象锁
	synchronized public void mB(String name) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name);
		}
	}
	//修饰this拿到对象锁
	public void mB2(String name) throws InterruptedException {
		synchronized(this) {
			for (int i = 0; i < 1000; i++) {
				System.out.println(name);
			}
		}
	}

}
