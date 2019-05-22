package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/4/27 17:55
 * @Author: mistyle
 * @Description:
 */
public class SyncThread implements Runnable {
	private static int count;

	public SyncThread() {
		count = 0;
	}

	public  void run() {
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() +":"+i+ ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		SyncThread syncThread = new SyncThread();
		Thread thread1 = new Thread(syncThread, "SyncThread1");
		Thread thread2 = new Thread(syncThread, "SyncThread2");
		thread1.start();
		thread2.start(); //start 的先后顺序并不能保证先后run的顺序
		//当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
		// 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块
	}
}