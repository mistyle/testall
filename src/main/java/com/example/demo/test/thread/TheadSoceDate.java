package com.example.demo.test.thread;

import java.util.Random;

/** 多客户端下单
 * @program: testall
 * @Date: 2019/4/27 17:27
 * @Author: mistyle
 * @Description:点击后买商品类，产生一个线程维护这个商品价格
 */
public class TheadSoceDate {

	private static int price ;
	public static void main(String[] args) {
       for(int i=0;i<3;i++){
		   new  Thread(new Runnable() {
			   @Override
			   public    void run() {  //synchronized写在这里，是对象锁，取的不是同一把锁
				   System.out.println(this);
			   	// 字节类，资源，同一个锁对象
				   synchronized(TheadSoceDate.class) { // synchronized(TheadSoceDate.class)这是类锁,synchronized(this)这是对象锁
					    price = new Random().nextInt(1000); //线程死掉了
					   System.out.println("产生线程的名称" + Thread.currentThread().getName() + "，价格信息是" + price);
					   new A().getInfo();
					   new B().getInfo();
				   }
			   }
		   }).start();
	   }


	}
	static class A{
		public void getInfo(){
			System.out.println(Thread.currentThread().getName()+"进入A模块，处理的价格信息是"+price);
		}

	}
	static class B{
		public void getInfo(){
			System.out.println(Thread.currentThread().getName()+"进入B模块，处理的价格信息是"+price);
		}

	}
}
/**
 com.example.demo.test.thread.TheadSoceDate$1@528ff726
 产生线程的名称Thread-0，价格信息是31
 com.example.demo.test.thread.TheadSoceDate$1@5102a646
 com.example.demo.test.thread.TheadSoceDate$1@371adbca
 * Thread-0进入A模块，处理的价格信息是31
 * Thread-0进入B模块，处理的价格信息是31
 * 产生线程的名称Thread-2，价格信息是218
 * Thread-2进入A模块，处理的价格信息是218
 * Thread-2进入B模块，处理的价格信息是218
 * 产生线程的名称Thread-1，价格信息是479
 * Thread-1进入A模块，处理的价格信息是479
 * Thread-1进入B模块，处理的价格信息是479
 *
 * Process finished with exit code 0
 * 这里可以看到  每个线程，访问的是不同的对象
 */