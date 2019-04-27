package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 15:57
 * @Author: mistyle
 * @Description: 子线程和主线程轮流执行，子线程执行30次，主线程执行40次，轮流执行，循环50次
 */
public class ThreadOrderCirceTest2 {
	final static BusinessDemo businessDemo=new BusinessDemo();
	public static void main(String[] args) {
		new  Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					businessDemo.sunBusiness(i);
				}
			}
		}).start();
		for(int i=1;i<=50;i++){
			businessDemo.mainBusiness(i);
		}
	}
}
