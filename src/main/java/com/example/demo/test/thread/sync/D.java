package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/4/27 22:28
 * @Author: mistyle
 * @Description: 对象锁与类锁同时存在，
 */
public class D {
	//静态方法，上类锁，函数功能为连续打印1000个value值，调用时会传1，所以会打印1000个1
	synchronized public static void mB(String value) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			System.out.println(value);
			Thread.sleep(100);
		}
	}

	public void mC(String value)throws InterruptedException {
		//修饰this上对象锁，函数功能也是连续打印1000个value值，调用时会传2，所以会打印1000个2
		synchronized (this) {
			for (int i = 0; i < 1000; i++) {
				System.out.println(value);
				Thread.sleep(100);
			}
		}
	}

	public static void main(String[] args)throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					D.mB("1");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		D b = new D();
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
				b.mC("2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		thread.start();
		thread2.start();

	}
/**
 * 运行结果：类B的静态方法和代码块功能都是打印100个value值，但是静态方法是类锁，而代码块锁this，是对象锁。所以代码块和静态方法交替执行、交替打印
 * 并没有做到同步
 */
}
