package com.example.demo.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {
	public static void main(String[] args) throws Exception {

	
		 
		   ExecutorService executorService = Executors.newCachedThreadPool();
		   for (int i = 0; i < 5; i++) {
		   executorService.execute( new Runnable() {
	                @Override
	                public void run() {
	                	// for (int i = 0; i < 1000; i++) {
	                	 System.out.println( Thread.currentThread().getName());
	                	/// }
	                }
	            });
		   }
//		   for (int i = 0; i < 20; i++) {
//	            Runnable syncRunnable = new Runnable() {
//	                @Override
//	                public void run() {
//	                	 System.out.println( Thread.currentThread().getName());
//	                	 
//	                	
//	                }
//	            };
//	            executorService.execute(syncRunnable);
//	        }
	           
	        
		
		System.out.println("sssssssssssssssssssssssssssssssssss"); // 如果启动一百个线程，并不保证这条语句的执行顺序,如果启动一个线程，一定是先执行
		
		//运行结果：可以看出缓存线程池大小是不定值，可以需要创建不同数量的线程，在使用缓存型池时，先查看池中有没有以前创建的线程，如果有，就复用.如果没有，就新建新的线程加入池中，
		//缓存型池子通常用于执行一些生存期很短的异步型任务
	}

}
