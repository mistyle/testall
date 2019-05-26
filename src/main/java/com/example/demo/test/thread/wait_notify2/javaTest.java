package com.example.demo.test.thread.wait_notify2;

/**
 * @program: testall
 * @Date: 2019/5/23 17:31
 * @Author: mistyle
 * @Description:
 */
public class javaTest {
	public static void main(String[] args) {
		Something sth = new Something();
		Runnable runProduce = new Runnable() {
			int count = 3;

			@Override
			public void run() {
				while (count-- > 0) {

					sth.produce();
				}
			}
		};
		Runnable runConsume = new Runnable() {
			int count = 3;

			@Override
			public void run() {
				while (count-- > 0) {
					sth.consume();
				}
			}
		};
		for (int i = 0; i < 2; i++) {
			new Thread(runConsume).start();
		}
		for (int i = 0; i < 2; i++) {
			new Thread(runProduce).start();
		}
	}


}
