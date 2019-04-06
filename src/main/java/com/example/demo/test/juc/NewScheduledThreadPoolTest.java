package com.example.demo.test.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {
	
	public static void main(String[] args) {
		   ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5); //也是创建定长的线程池

	            Runnable syncRunnable = new Runnable() {
	                @Override
	                public void run() {
	                	 for (int i = 0; i < 20; i++) {
	                	 System.out.println( Thread.currentThread().getName());
	                	 }
	                }
	            };
	          executorService.schedule(syncRunnable, 2000, TimeUnit.MILLISECONDS);
	            
	      	ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
			Future future = executorService1.scheduleWithFixedDelay(new Runnable() {

				@Override
				public void run() {
					 for (int i = 0; i < 20; i++) {
	                	 System.out.println( Thread.currentThread().getName());
	                	 }
				}
			}, 0, 1, TimeUnit.SECONDS);
	       
	        System.out.println("sssssssssssssssssssssssssssssssssss");//也是先执行的
	}

}
