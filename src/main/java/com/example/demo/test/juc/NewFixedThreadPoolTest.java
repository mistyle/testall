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

public class NewFixedThreadPoolTest {

	

	public static void main(String[] args) throws Exception {


		 
		 ExecutorService executorService = Executors.newFixedThreadPool(5); //可重用固定线程数
	        for (int i = 0; i < 30; i++) {
	            Runnable syncRunnable = new Runnable() {
	                @Override
	                public void run() {
	                    System.out.println( Thread.currentThread().getName());  //打印显示线程的名称不会超过5，
	                    
	                }
	            };
	            executorService.execute(syncRunnable);
	        }
		 
		
		System.out.println("sssssssssssssssssssssssssssssssssss"); // 如果启动一百个线程，并不保证这条语句的执行顺序,如果启动一个线程，一定是先执行
		
		//运行结果：总共只会创建5个线程， 开始执行五个线程，当五个线程都处于活动状态，再次提交的任务都会加入队列等到其他线程运行结束，当线程处于空闲状态时会被下一个任务复用
        
	}

}

// 0
// hello world!
// 1
// hello world!
// 2

