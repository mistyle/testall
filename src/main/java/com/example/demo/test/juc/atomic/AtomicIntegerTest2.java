package com.example.demo.test.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁与CAS AtomicInteger对比测试
 * @author lenovo
 *
 *
 */
public class AtomicIntegerTest2 {

	private static int id = 0;
	private static AtomicInteger atomicId = new AtomicInteger();
	private static CountDownLatch latch = null;
	private static Lock  lock=new ReentrantLock();

	public  static int getNextIdLock() {

		return ++id ;
	}

//	public synchronized static int getNextId() {
//		return ++id;
//	}

	public static int getNextIdWithAtomic() {
		return atomicId.incrementAndGet();
	}

	public static void main(String[] args) throws Exception {
		latch = new CountDownLatch(50);
		long beginTime = System.nanoTime();
		for (int i = 0; i < 50; i++) {
			new Thread(new Task(false)).start();  //false表明不是AtomicInteger,是同步
		}
		latch.await();
		System.out.println("Lock style consume time:" + (System.nanoTime() - beginTime));

		//////////////////cas//////////////////////////////
		latch = new CountDownLatch(50);
		beginTime = System.nanoTime();
		for (int i = 0; i < 50; i++) {

			new Thread(new Task(true)).start();
		}
		latch.await();
		System.out.println("CAS style consume time:" + (System.nanoTime() - beginTime));

		//Synchronized style consume time:19946818  是CAS执行的两倍多
		//Lock style consume time:14567066 ,是CAS执行的一倍多
		//CAS style consume time:8589618
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
				else{
					lock.lock();
					//getNextId();
					getNextIdLock();
					lock.unlock(); //释放锁
				}
			}
			latch.countDown();
		}
	}

}
