package com.example.demo.test.juc;

import com.example.demo.test.thread.Consumer;
import com.example.demo.test.thread.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) throws InterruptedException {
		          // 声明一个容量为10的缓存队列
		         BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2); //阻塞的有界队列
		  
		         //new了三个生产者和一个消费者
		         Producer producer1 = new Producer(queue);
		         Producer producer2 = new Producer(queue);
		         Producer producer3 = new Producer(queue);
		         Consumer consumer = new Consumer(queue);
		  
		         // 借助Executors
		         ExecutorService service = Executors.newCachedThreadPool();
		         // 启动线程
		         service.execute(producer1);
		         service.execute(producer2);
		         service.execute(producer3);
		         service.execute(consumer);
		  
		         // 执行10s
		        Thread.sleep(2 * 1000);
		         producer1.stop();
		         producer2.stop();
		         producer3.stop();
		  
		         Thread.sleep(2000);
		         // 退出Executor
		         service.shutdown();
		     }


	 
	
}
