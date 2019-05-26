package com.example.demo.test.thread.wait_notify2;

/**
 * @program: testall
 * @Date: 2019/5/23 17:29
 * @Author: mistyle
 * @Description:
 */
public class Something {
	private Buffer mBuf = new Buffer();

	public void produce() {
		synchronized (this) {
			while (mBuf.isFull()) {
				try {
					System.out.println(Thread.currentThread().getName() + " product wait");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mBuf.add();
			notifyAll();
		}
	}

	public void consume() {
		synchronized (this) {
			while (mBuf.isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName() + " consume wait ");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mBuf.remove();
			notifyAll();
		}
	}
}