package com.example.demo.test.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch implements Runnable{
	


	    /** 处理main线程阻塞（等待所有子线程） */
	    private CountDownLatch countDown;

	    /** 线程名字 */
	    private String  threadName;


	    public TestCountDownLatch(CountDownLatch countDownLatch, String threadName) {
	        this.countDown = countDownLatch;
	        this.threadName = threadName;
	    }

	    @Override
	    public void run() {
	        System.out.println( "[" + threadName + "] Running ! [countDownLatch.getCount() = " + countDown.getCount() + "]." );
	        // 每个独立子线程执行完后,countDownLatch值减1
	        countDown.countDown();
	    }

	    public static void main(String [] args) throws InterruptedException {
	        int countNum = 5;
	        CountDownLatch countDownLatch = new CountDownLatch(countNum); //这里改成7，主程序子线程执行完成了,但是countDownLatch的倒记数的值不为0,进入持续等待中,并没有唤醒主线程来执行
	        for(int i=0; i<countNum; i++){
	            new Thread(new TestCountDownLatch(countDownLatch,"子线程" + (i+100))).start();
	        }
	        System.out.println("主线程阻塞,等待所有子线程执行完成");

	        countDownLatch.await();
	        System.out.println("所有线程执行完成!");
	    }

}
