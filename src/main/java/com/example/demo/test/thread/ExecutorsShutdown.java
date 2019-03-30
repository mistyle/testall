package com.example.demo.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsShutdown {
	
	public static void main(String[] args) {
		System.out.println("start");
		ExecutorService pool = Executors.newFixedThreadPool(5);
		final long waitTime = 8 * 1000;
		final long awaitTime = 5 * 1000;
		//以看出上面程序中waitTime的值比awaitTime大的情况下，发生Timeout然后执行中的线程会中止执行而结束。
		//反过来如果缩小waitTime的值，增大awaitTime的值的的话，各个线程就会不被中止的正常运行至结束。
		//不管awaitTime设置多大，如果任务在awaitTime前执行完，那么也能正常运行至结束
		Runnable task1 = new Runnable() {
			public void run() {
				try {
					System.out.println("task1 start");  //   1
					Thread.sleep(waitTime);
					System.out.println("task1 end");
				} catch (InterruptedException e) {
					System.out.println("task1 interrupted: " + e);  //last
				}
			}
		};

		Runnable task2 = new Runnable() {
			public void run() {
				try {
					System.out.println("  task2 start"+Thread.currentThread().getName());
					Thread.sleep(1000);
					System.out.println("  task2 end"+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					System.out.println("task2 interrupted: " + e);
				}
			}

		};
		// 让学生解答某个很难的问题
		pool.execute(task1);

		// 生学生解答很多问题
		for (int i = 0; i < 2; ++i) {
			pool.execute(task2);
		}
		
	

		try {
			// 向学生传达“问题解答完毕后请举手示意！”
			pool.shutdown();

			// 向学生传达“XX分之内解答不完的问题全部带回去作为课后作业！”后老师等待学生答题
			// (所有的任务都结束的时候，返回TRUE)
			if (!pool.awaitTermination(awaitTime, TimeUnit.MILLISECONDS)) {
				// 超时的时候向线程池中所有的线程发出中断(interrupted)。
				pool.shutdownNow();
			}
		} catch (InterruptedException e) {
			// awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
			System.out.println("awaitTermination interrupted: " + e);
			pool.shutdownNow();
		}

		System.out.println("end");

	}

}
