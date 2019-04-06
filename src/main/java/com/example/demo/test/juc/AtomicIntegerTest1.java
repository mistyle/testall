package com.example.demo.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 控制方法并发的次数，超过100，返回null
 * @author Administrator
 *
 */
public class AtomicIntegerTest1 {

	private static AtomicInteger counter = new AtomicInteger(0);
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 103; i++) {
			Runnable syncRunnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(methodA());
					// System.out.println( Thread.currentThread().getName());


				}
			};
			executorService.execute(syncRunnable);
		}

	}



	public static Integer methodA() {

//    	int value = counter.get();
//        if(value > 100) {
//             return null;
//         }
//        counter.incrementAndGet(); //注意这里放在前面

		//下面的写法才是正确的,上面的写法少拦截了一次
		int value = counter.incrementAndGet();
		if(value > 100) {
			return null;
		}

		/** 另外
		 getAndIncrement
		 方法是返回旧值（即加1前的原始值），而
		 incrementAndGet
		 返回的是新值（即加1后的值） **/

		try {
			// System.out.println("dddddddddddddd");
		} finally {
			//counter.decrementAndGet();
		}
		return  value;

	}


}
