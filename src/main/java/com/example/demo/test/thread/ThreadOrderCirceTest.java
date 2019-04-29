package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 15:57
 * @Author: mistyle
 * @Description: 子线程和主线程轮流执行，子线程执行30次，主线程执行40次，轮流执行，循环50次 (没有实现目标)
 */
public class ThreadOrderCirceTest {
	public static void main(String[] args) {
		new  Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					//子线程的业务
					for(int j=1;j<=30;j++){
						System.out.println("子线程运行第"+i+"轮，第"+j+"次");
					}
				}
			}
		}).start();
		for(int i=1;i<=50;i++){
			//主线程的业务
			for(int j=1;j<=40;j++){
				System.out.println("主线程运行第"+i+"轮，第"+j+"次");
			}
		}
	}
}
