package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/4/27 22:11
 * @Author: mistyle
 * @Description:   类锁，
 */
public class C {
	//修饰静态方法，调用取得类锁
	synchronized public static void mB(String value) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			Thread.sleep(100);
			System.out.println(value);

		}
	}
	//修饰class对象，调用取得静类锁
	public static void mC(String value) throws InterruptedException{
		synchronized (C.class) {
			for (int i = 0; i < 1000; i++) {
				Thread.sleep(100);
				System.out.println(value);

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					C.mB("1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					C.mC("2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
