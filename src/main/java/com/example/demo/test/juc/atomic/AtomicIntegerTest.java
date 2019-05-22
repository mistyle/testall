package com.example.demo.test.juc.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {



	public static void main(String[] args)  {

//		 ExecutorService executor = Executors.newCachedThreadPool();
//		 executor.execute(new Thread() {
//				@Override
//				public void run() {
		System.out.println("sssssssstart  ....");


				String jobID = "REQUEST_SUBSCRIPTION_STATUS_CHANGE";
				Map<String, Future> futures = new HashMap<>();
				final AtomicInteger count = new AtomicInteger(0);
				final CountDownLatch countDownLatch = new CountDownLatch(1); //如果countDown()执行次数<这里参数,会导致死锁，如果执行次数大于参数，以conntdown执行次数为准
				ExecutorService scheduledExcutor = Executors.newSingleThreadExecutor();
				for(int i=0;i<3;i++){
					scheduledExcutor.execute( new Runnable() {

						@Override
						public void run() {
							System.out.println(count.getAndIncrement());

                          countDownLatch.countDown();

						}
					});
				}


				try {
			countDownLatch.await(); //这是个阻塞方法，如果遇到重试，那么最多要重试3次之后，才会回到主线程执行
		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();
		}

				try {
					scheduledExcutor.shutdown();
					// (所有的任务都结束的时候，返回TRUE)
					if (!scheduledExcutor.awaitTermination(5, TimeUnit.SECONDS)) {
						// 超时的时候向线程池中所有的线程发出中断(interrupted)。
						scheduledExcutor.shutdownNow();
					}
				} catch (InterruptedException e) {
					//logger.error("awaitTermination interrupted: " + e);
					scheduledExcutor.shutdownNow();
				}

		System.out.println("end........");



	}

/**
 *
 * sssssssstart  ....
 * 0
 * 1
 * 2
 * end........
 */

}