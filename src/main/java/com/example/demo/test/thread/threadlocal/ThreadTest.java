package com.example.demo.test.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: testall
 * @Date: 2019/5/19 9:39
 * @Author: mistyle
 * @Description:
 */
public class ThreadTest {
	static ExecutorService defaultFixedExecutor = Executors.newFixedThreadPool(1);
	static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			final int count = i;
			defaultFixedExecutor.submit(new Runnable() {

				@Override
				public void run() {
					System.out.println("第"+count+"次循环刚开始，ThreadLocal中的值为："+threadLocal.get());
					threadLocal.set(count+"---");
					System.out.println("第"+count+"次循环结束，ThreadLocal中的值为："+threadLocal.get());
					System.out.println("当前线程名称为："+Thread.currentThread().getName());
					System.out.println("------------------");
				}
			});

		}
	}


}
