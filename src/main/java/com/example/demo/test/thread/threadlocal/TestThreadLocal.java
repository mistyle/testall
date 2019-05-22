package com.example.demo.test.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: testall
 * @Date: 2019/5/19 9:42
 * @Author: mistyle
 * @Description:
 */
public class TestThreadLocal {
	private ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};

	public void getAndAdd() {
		Integer integer = local.get();
		System.out.println(Thread.currentThread().getName() + ": (get and add local) thread values is:"+integer);
		local.set(integer+1);
	}

	public void get() {
		System.out.println(Thread.currentThread().getName() + ": (get) local thread values is:"+local.get());
	}

	public void clear() {
		local.remove();
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		final TestThreadLocal testThreadLocal = new TestThreadLocal();
		Runnable runnable = () -> {
			testThreadLocal.getAndAdd();
			testThreadLocal.get();
			testThreadLocal.clear();
		};
		service.submit(runnable);
		service.submit(runnable);
		service.submit(runnable);
		service.submit(runnable);
		service.submit(runnable);
	}
}
