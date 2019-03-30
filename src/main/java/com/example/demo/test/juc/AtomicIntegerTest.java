package com.example.demo.test.juc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	

	public static void main(String[] args) throws Exception {

//		 ExecutorService executor = Executors.newCachedThreadPool();
//		 executor.execute(new Thread() {
//				@Override
//				public void run() {
		
		//子线程的阻塞，只会影响父线程内部，而不会阻塞到主线程，也就是不能越级阻塞
		 
		String jobID = "REQUEST_SUBSCRIPTION_STATUS_CHANGE";
		Map<String, Future> futures = new HashMap<>();
		final AtomicInteger count = new AtomicInteger(0);
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		Future future = scheduler.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				System.out.println("ddddddddd");
				
				for(int i=0;i<10;i++){
					String a=i*133/334+23+"xxx";
					System.out.println(a);
				}
				System.out.println("sssss");
				
//				count.getAndIncrement();
//				//
//				Future future = futures.get(jobID);
//				// if (count.get() >2) {
//				// System.out.println("sss " +count.get());
//				// if (future != null) future.cancel(true);
//				// countDownLatch.countDown();
//				// }
//				//
//
//				
//			
//				
//				// dcp
//				// //(1) 调查询接口查状态
//				String state = "complated";
//				if ("complated".equals(state) || "canceld".equals(state) || "Rejected".equals(state)) {
//					if (future != null) {
//						future.cancel(true);
//
//					}
//					countDownLatch.countDown(); // 开始这里没写这一句，导致子线程挂起，主线程得不到执行
//
//				} else if ("In progress".equals(state)) {
//					if (count.get() > 2) {
//
//						if (future != null) {
//							future.cancel(true);
//						}
//						countDownLatch.countDown();
//					}
//
//				}

			}
		}, 0, 1, TimeUnit.SECONDS);

		futures.put(jobID, future);
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		}

		//scheduler.shutdown();
				
		 
		 //如果要让最后的打印先执行，必须再调度任务上再包装成线程执行
		System.out.println("sssssssssssssssssssssssssssssssssss"); // 注意子线程 不停止，这里打印得不到执行
		
		

	}

}

// 0
// hello world!
// 1
// hello world!
// 2

