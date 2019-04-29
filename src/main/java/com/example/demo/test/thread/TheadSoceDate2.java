package com.example.demo.test.thread;

import java.util.Random;

/** 多客户端下单
 * @program: testall
 * @Date: 2019/4/27 17:27
 * @Author: mistyle
 * @Description:点击后买商品类，产生一个线程维护这个商品价格
 */
public class TheadSoceDate2 {
	//引入threadlocal机制，空间换时间
   private static  ThreadLocal<Integer>  buyThreadPrice=new   ThreadLocal<Integer>();

	public static void main(String[] args) {
       for(int i=0;i<3;i++){
		   new  Thread(new Runnable() {
			   @Override
			   public    void run() {  //synchronized写在这里，是对象锁，取的不是同一把锁

			   	// 字节类，资源，同一个锁对象
				   // synchronized(TheadSoceDate.class)这是类锁,synchronized(this)这是对象锁
					   int price = new Random().nextInt(1000); //线程死掉了
					   System.out.println("产生线程的名称" + Thread.currentThread().getName() + "，价格信息是" + price);
					  // System.out.println(buyThreadPrice); //每个线程的ThreadLocal对象是一样的
					   buyThreadPrice.set(price);
					   new A().getInfo();
					   new B().getInfo();
				   buyThreadPrice.remove();

			   }
		   }).start();
	   }


	}
	static class A{
		public void getInfo(){
			int price =buyThreadPrice.get();
			System.out.println(Thread.currentThread().getName()+"进入A模块，处理的价格信息是"+price);
		}

	}
	static class B{

		public void getInfo(){
			int price =buyThreadPrice.get();
			System.out.println(Thread.currentThread().getName()+"进入B模块，处理的价格信息是"+price);
		}

	}

}
/**
 com.example.demo.test.thread.TheadSoceDate2$1@528ff726
 com.example.demo.test.thread.TheadSoceDate2$1@5102a646
 com.example.demo.test.thread.TheadSoceDate2$1@371adbca
 产生线程的名称Thread-0，价格信息是83
 Thread-0进入A模块，处理的价格信息是83
 Thread-0进入B模块，处理的价格信息是83
 产生线程的名称Thread-1，价格信息是758
 Thread-1进入A模块，处理的价格信息是758
 Thread-1进入B模块，处理的价格信息是758
 产生线程的名称Thread-2，价格信息是392
 Thread-2进入A模块，处理的价格信息是392
 Thread-2进入B模块，处理的价格信息是392

 threadLocal源码中
 ThreadLocalMap map = getMap(t); //根据当前线程拿到map,有多少线程，就有多少ThreadLocalMap
 每个线程里面有个属性threadLocals，它是ThreadLocalMap类型 ,内部类

 map.set(this, value);//this是键值，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）
 */