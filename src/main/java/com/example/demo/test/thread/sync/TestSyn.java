package com.example.demo.test.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: testall
 * @Date: 2019/4/5 9:28
 * @Author: mistyle
 * @Description:  类锁与对象锁
 */
public class TestSyn {
    public synchronized void showMsg() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized static   void showMsg2() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TestSyn testSyn = new TestSyn();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                testSyn.showMsg();
            }
        };

       // TestSyn testSyn2 = new TestSyn();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                testSyn.showMsg2();
            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable2);
        executorService.shutdown();
    }
}
/**
 * 结论:
 * (1)同一个对象，多个线程执行同一个方法，加上synchronized就可以做到同步
 * （2）同一个对象，多个线程执行不同方法，加上synchronized也可以做到同步
 *  (3) 同一个类的不同对象，多个线程执行同一个方法，加上synchronized也不会同步
 *  (4)同一个对象，多个线程执行不同方法（其中一个是static方法）加上synchronized也不会同步
 *  （5）synchronized方法如果被继承，synchronized关键字不会被继承
 */