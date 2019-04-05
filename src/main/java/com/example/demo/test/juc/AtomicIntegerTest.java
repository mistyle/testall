package com.example.demo.test.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	

	public static void main(String[] args) throws Exception {

//		 ExecutorService executor = Executors.newCachedThreadPool();
//		 executor.execute(new Thread() {
//				@Override
//				public void run() {


		 
		String jobID = "REQUEST_SUBSCRIPTION_STATUS_CHANGE";
		Map<String, Future> futures = new HashMap<>();
		final AtomicInteger count = new AtomicInteger(0);
		final CountDownLatch countDownLatch = new CountDownLatch(1); //如果countDown()执行次数<这里参数,会导致死锁，如果执行次数大于参数，以conntdown执行次数为准
		ScheduledExecutorService scheduledExcutor = Executors.newSingleThreadScheduledExecutor();
		Future future = scheduledExcutor.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				System.out.println(count.getAndIncrement());

				Future future = futures.get(jobID);
				String state = "In progress";
				if ("completed".equals(state) || "canceld".equals(state) || "Rejected".equals(state)) {

					if (future != null) {
						future.cancel(true);

					}
					countDownLatch.countDown(); // 开始这里没写这一句，导致子线程挂起，主线程得不到执行

				} else if ("In progress".equals(state)) {
					if (count.get() > 2) {

						if (future != null) {
							future.cancel(true);
						}
						countDownLatch.countDown();
					}

				}



			}
		}, 0, 1, TimeUnit.SECONDS);

		futures.put(jobID, future);

		countDownLatch.await();
		// scheduledExcutor.shutdown();

		try {
			scheduledExcutor.shutdown();
			// (所有的任务都结束的时候，返回TRUE)
			if (!scheduledExcutor.awaitTermination(5, TimeUnit.MINUTES)) {
				// 超时的时候向线程池中所有的线程发出中断(interrupted)。
				scheduledExcutor.shutdownNow();
			}
		} catch (InterruptedException e) {
			//logger.error("awaitTermination interrupted: " + e);
			scheduledExcutor.shutdownNow();
		}

		 

		System.out.println("end........");
		
		

	}

}
/**
        0
		1
		2
		3
		4
		5
		6
		7
		8
		9
		10
		sssssssssssssssssssssssssssssssssss

		Process finished with exit code 0  **/

