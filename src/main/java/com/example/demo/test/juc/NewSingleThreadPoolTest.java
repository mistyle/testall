package com.example.demo.test.juc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                	 System.out.println( Thread.currentThread().getName());
                	//上面虽然new了多个线程，但同时只会是一个线程，一直打印pool-1-thread-1
                }
            };
            executorService.execute(syncRunnable);
            
        }
        
        
        
        System.out.println("sssssssssssssssssssssssssssssssssss"); // 注意一句打印并不一定最后执行
	}

}
