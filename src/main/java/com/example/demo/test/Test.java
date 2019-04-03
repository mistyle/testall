package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
	
	private static Semaphore semaphore = new Semaphore(100);
	 

	public static void main(String[] args) {
		System.out.println("start");

		  ExecutorService executorService = Executors.newCachedThreadPool();
		   for (int i = 0; i < 105; i++) {
	            Runnable syncRunnable = new Runnable() {
	                @Override
	                public void run() {
	                 System.out.println( Thread.currentThread().getName());
	                	 methodA();
	                	 
	                	
	                }
	            };
	            executorService.execute(syncRunnable);
	        }
	           
		  
		
		
		
		System.out.println("end");

	}

	
    public static Integer methodA() {
        if(!semaphore.tryAcquire()) {
        	System.out.println("aaaaaaaaaaa");
            return null;
        }
 
        try {
        // TODO 方法中的业务逻辑
        } finally {
            semaphore.release();
        }
        return  1;
    }

}