package com.example.demo.test.juc;

import java.util.HashMap;

/**
 * @program: testall
 * @Date: 2019/4/6 20:36
 * @Author: mistyle
 * @Description: 100个写线程 写入100个数，然后用1个读线程去读，最终打印读线程读到的第一个数，以及主线程读到的第一个数
 */
public class HashMapDemo {
    public static void main(String[] args) {
        /** 全局HashMap*/
        HashMap<Integer, Integer> hashMap = new HashMap();
        hashMap.put(0, 0);

        /** 多线程编辑100次*/
        for (int i = 0; i < 100; i++) {
            new Thread(new EditThread(hashMap,i)).start();
        }

        /** 读取线程*/
        new Thread(new ReadThread(hashMap)).start();
        /** 输出最终结果*/
        System.out.println("Demo1 main value " + hashMap.get(0));
    }

/**
 *
 * 打印结果:
 * Demo1 main value 13
 * value 95
 * 只要多个线程访问的不是同一个segment 就没有锁争用，就没有堵塞，也就是允许16个线程并发的更新而尽量没有锁争用。
 * 结果： 读线程读到的第一个数与主线程读到的第一个数不相同
 */
}
