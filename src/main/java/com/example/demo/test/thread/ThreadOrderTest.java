package com.example.demo.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: testall
 * @Date: 2019/4/13 16:33
 * @Author: mistyle
 * @Description:
 */
public class ThreadOrderTest {
	static CountDownLatch  downn1=new CountDownLatch (1);
	static  CountDownLatch  downn2=new CountDownLatch (1);
	static CountDownLatch  downn3=new CountDownLatch (1);
	static Thread  thread1=new Thread(new  Runnable() {

		@Override
		public void run() {
			System.out.println("Thread1");
			downn1.countDown();
		}
	});

	static Thread  thread2=new Thread(new  Runnable() {

		@Override
		public void run() {
			System.out.println("Thread2");
			downn2.countDown();
		}
	});

	static Thread  thread3=new Thread(new  Runnable() {

		@Override
		public void run() {
			System.out.println("Thread3");
		}
	});
	static  ExecutorService executorService = Executors.newSingleThreadExecutor();

	public static void main(String[] args) throws Exception {
//		thread1.start();
//		downn1.await();
//		thread1.join();
//		thread2.start();
//		downn2.await();
//		//thread2.join();
//		thread3.start();
//		//thread3.join();
		executorService.submit(thread1);
		executorService.submit(thread2);
		executorService.submit(thread3);
		executorService.shutdown();
	}
}

//3种方式，一种是通过countdownlatch,一种是join()
 //最后一种是通过newSingleThreadExecutor，利用队列，FIFO，