package com.example.demo.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest1 {
	
	private static AtomicInteger counter = new AtomicInteger(0);
	public static void main(String[] args) {
		
		  ExecutorService executorService = Executors.newCachedThreadPool();
		  
		   for (int i = 0; i < 120; i++) {
	            Runnable syncRunnable = new Runnable() {
	                @Override
	                public void run() {
	                	 System.out.println(methodA());
	                	 System.out.println( Thread.currentThread().getName());
	                	 
	                	
	                }
	            };
	            executorService.execute(syncRunnable);
	        }
		
	}
	
	
	 
    public static Integer methodA() {
 
    	int value = counter.get();
        if(value > 100) {
             return null;
         }


        counter.incrementAndGet(); //注意这里放在前面，

        try {
          System.out.println("dddddddddddddd");
        } finally {
          ///  counter.decrementAndGet();
        }
        return  value;

    }


}
