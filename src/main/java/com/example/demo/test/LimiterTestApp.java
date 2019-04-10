package com.example.demo.test;

/**
 * @program: testall
 * @Date: 2019/4/10 10:42
 * @Author: mistyle
 * @Description:限速器测试类
 */

import java.util.concurrent.CountDownLatch;


public class LimiterTestApp {

	public static void main(String[] args) throws InterruptedException {
		// 获取限速器
//        final RateLimiter rateLimiter = new CounterLimiter(10);
//        final RateLimiter rateLimiter = new LeakyBucketLimiter(10);
//        final RateLimiter rateLimiter = new TokenBucketLimiter(100);

		//速率是每秒10个许可
		final com.google.common.util.concurrent.RateLimiter rateLimiter = com.google.common.util.concurrent.RateLimiter.create(10);

		// 多个线程
		int maxNum = 100; //100个线程执行大概需要10秒

		// 用户主线程统计时间
		final CountDownLatch countDownLatch = new CountDownLatch(maxNum);

		// 创建若干线程执行限速逻辑
		long startTime = System.currentTimeMillis();
		for (int i=0; i< 105; i++){
			Thread thread = new Thread(new Runnable() {
				public void run() {
					rateLimiter.acquire();
					System.out.println("run_Task:" + Thread.currentThread().getName());
					countDownLatch.countDown();
				}
			});
			thread.setName("thread_" + i);
			thread.start();
		}

		// 获取整个过程执行时间
		countDownLatch.await();
		System.out.println("end takeTime:"+ (System.currentTimeMillis() - startTime));
	}
}