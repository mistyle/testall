package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/4/27 22:07
 * @Author: mistyle
 * @Description: 对象锁测试
 */
public class test {
	public static void main(String[] args) {

		B b = new B();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//线程1的调用处
					b.mB("1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//线程2的调用处
					b.mB2("2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
/**打印结果：先打印1000个2，再打印1000个1
 **/
