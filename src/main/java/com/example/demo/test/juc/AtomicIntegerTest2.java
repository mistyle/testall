package com.example.demo.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * 同步锁与CAS AtomicInteger对比测试
 * @author lenovo
 * TODO
 *
 */
public class AtomicIntegerTest2 {

	private static int id = 0;
	private static AtomicInteger atomicId = new AtomicInteger();
	private static CountDownLatch latch = null;

	public synchronized static int getNextId() {
		return ++id;
	}

	public static int getNextIdWithAtomic() {
		return atomicId.incrementAndGet();
	}

	public static void main(String[] args) throws Exception {
		latch = new CountDownLatch(50);
		long beginTime = System.nanoTime();
		for (int i = 0; i < 50; i++) {
			new Thread(new Task(false)).start();
		}
		latch.await();
		System.out.println("Synchronized style consume time:" + (System.nanoTime() - beginTime));
		latch = new CountDownLatch(50);
		beginTime = System.nanoTime();
		for (int i = 0; i < 50; i++) {

			new Thread(new Task(true)).start();
		}
		latch.await();
		System.out.println("CAS style consume time:" + (System.nanoTime() - beginTime));
	}

	static class Task implements Runnable {

		private boolean isAtomic;

		public Task(boolean isAtomic) {
			this.isAtomic = isAtomic;
		}

		public void run() {
			for (int i = 0; i < 1000; i++) {
				if (isAtomic)
					getNextIdWithAtomic();
				else
					getNextId();
			}
			latch.countDown();
		}
	}

}
