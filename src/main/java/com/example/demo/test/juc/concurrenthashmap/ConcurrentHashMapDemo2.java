package com.example.demo.test.juc.concurrenthashmap;

/**
 * @program: testall
 * @Date: 2019/4/6 21:09
 * @Author: mistyle
 * @Description:
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class  ConcurrentHashMapDemo2 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        /** 全局ConcurrentHashMap*/
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();
        hashMap.put(0, 0);

        /** 多线程编辑100次*/
        for (int i = 0; i < 100; i++) {
            //new Thread(new EditThread(hashMap)).start();

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    hashMap.put(0, hashMap.get(0) + 1);
                }
            });
        }

        /** 读取线程*/
        new Thread(new ReadThread(hashMap)).start();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("other  read thread ，value " + hashMap.get(0));
            }
        });

        /** 输出最终结果*/
        System.out.println("Demo2 main value " + hashMap.get(0));
    }

/**
 * value 153
 * Demo2 main value 153
 * value 180
 * 结论：同一个线程池里的线程做到了同步 ,new Thread的线程没有去同步
 */
}