package com.example.demo.test.thread.sync;

/**
 * @program: testall
 * @Date: 2019/5/14 22:18
 * @Author: mistyle
 * @Description:
 */
	public class TestSync2 implements Runnable {
	    int b = 100;

			    synchronized void m1() throws InterruptedException {
					System.out.println("222");
			        b = 1000;
			        Thread.sleep(500); //6
			        System.out.println("b=" + b);
		    }

			    synchronized void m2() throws InterruptedException {
			        Thread.sleep(250); //5
					System.out.println("111");
		       b = 2000;
		    }

		    public static void main(String[] args) throws InterruptedException {
			        TestSync2 tt = new TestSync2();
		        Thread t = new Thread(tt);  //1
		        t.start(); //2

		        tt.m2(); //3
		        System.out.println("main thread b=" + tt.b); //4
		   }

		    @Override
    public void run() {
		        try {
			            m1();
			       } catch (InterruptedException e) {
				            e.printStackTrace();
				        }
		    }

			}
