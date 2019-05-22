package com.example.demo.test.juc.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: testall
 * @Date: 2019/4/6 20:45
 * @Author: mistyle
 * @Description:
 */
public class ConcurrentHashMapADDDemo {



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();


        /** 全局ConcurrentHashMap*/
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();
        hashMap.put(0, 0);

        /** 多线程编辑100次*/
        for (int i = 0; i < 100; i++) {
            new Thread(new EditThread(hashMap,i)).start();

        }

        /** 读取线程*/
        new Thread(new ReadThread(hashMap)).start();


        /** 输出最终结果*/
        System.out.println("Demo2 main value " + hashMap.get(0));
    }

/**
 * Demo2 main value 4
 * value 13
 *
 * 结论:这样说明多线程修改ConcurrentHashMap中的数据，不能保证多线程同步。需要进行加锁或者其他能达到线程同步的方式配合使用。
 * 结论原因：
 * 在EditThread线程中
 * public void run() {
 *         hashMap.put(0, hashMap.get(0) + 1);
 *     }
 * 高大上的ConcurrentHashMap根本帮不上你的忙，因为它是一个通用的数据结构类，并没假设你会这么使用。
 * ConcurrentHashMap只对基本的Map的方法put、get等提供同步支持，但不会把这段"getAndIncrAndPut"逻辑也给同步了。
 */

}