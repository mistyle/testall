package com.example.demo.test.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends Thread {
	private String name;
	//第一阶段工作时间
	private long time;
	
	private CountDownLatch countDownLatch;
	public CountDownLatchTest(String name, long time, CountDownLatch countDownLatch) {
		super();
		this.name = name;
		this.time = time;
		this.countDownLatch = countDownLatch;
		
	}
	@Override
	public void run() {
		try {
			System.out.println(name+"开始工作"); // (2)
			Thread.sleep(time);
			System.out.println(name+"第一阶段工作完成，消耗时间time="+time); // (3)
			countDownLatch.countDown();
			System.out.println(countDownLatch); // (4)
			Thread.sleep(10000);//work2被阻塞,下一步打印work2一定是最后
			System.out.println(name+"第二阶段工作完成，消耗时间time="+(time+10000));// (5) work0,1,2 ,也可能是1，0，2，顺序不固定,
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		CountDownLatchTest worker0 = new CountDownLatchTest("worker0", (long)(Math.random()*2000+3000),countDownLatch);
		CountDownLatchTest worker1 = new CountDownLatchTest("worker1", (long)(Math.random()*2000+3000),countDownLatch);
		CountDownLatchTest worker2 = new CountDownLatchTest("worker2", (long)(Math.random()*2000+3000),countDownLatch);
		worker0.start();
		worker1.start();
		
		countDownLatch.await();
		System.out.println("准备工作继续"); //(1)
		worker2.start();
		//work0和work1阻塞work2的执行，countDown变成0，work2开始执行
		
//		worker1开始工作
//		worker0开始工作
//		worker0第一阶段工作完成，消耗时间time=3024
//		worker1第一阶段工作完成，消耗时间time=4398
//		准备工作继续
//		worker2开始工作
//		worker2第一阶段工作完成，消耗时间time=4629
//		worker0第二阶段工作完成，消耗时间time=13024
//		worker1第二阶段工作完成，消耗时间time=14398
//		worker2第二阶段工作完成，消耗时间time=14629
	}

}
