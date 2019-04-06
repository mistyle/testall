package com.example.demo.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicIntegerTest {

	

	public static void main(String[] args)  {

//		 ExecutorService executor = Executors.newCachedThreadPool();
//		 executor.execute(new Thread() {
//				@Override
//				public void run() {
		System.out.println("sssssssstart  ....");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new MyThread());
		executorService.shutdown();

		System.out.println("end........");
		
		

	}



}
/**
 * V get(long timeOut, TimeUnit unit)：获取结果，超时返回null
 *
 * 简单来说，传入false参数只能取消还没有开始的任务，若任务已经开始了，就任由其运行下去。
 *
 * 当创建了Future实例，任务可能有以下三种状态：
 *
 * 等待状态。此时调用cancel()方法不管传入true还是false都会标记为取消，任务依然保存在任务队列中，但当轮到此任务运行时会直接跳过。
 * 完成状态。此时cancel()不会起任何作用，因为任务已经完成了。
 * 运行中。此时传入true会中断正在执行的任务，传入false则不会中断。
 *
 * Future.cancel(true)适用于：
 * 1. 长时间处于运行的任务，并且能够处理interruption
 *
 * Future.cancel(false)适用于：
 * 1. 未能处理interruption的任务
 * 2. 不清楚任务是否支持取消
 * 3. 需要等待已经开始的任务执行完成
        0
		1

		9
		10
		sssssssssssssssssssssssssssssssssss

		Process finished with exit code 0  **/

