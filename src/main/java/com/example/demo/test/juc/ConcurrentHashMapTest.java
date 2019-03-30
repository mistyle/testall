package com.example.demo.test.juc;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO  测试ConcurrentHashMapTest,顺便测试sleep
 * @author lenovo
 *
 */
public class ConcurrentHashMapTest {
	
	static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }

        Thread thread = new Thread(new Runnable() {
            public void run() {
                conMap.put(100l, "100");
                System.out.println("ADD:" + 100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (Iterator<Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Entry<Long, String> entry = iterator.next();
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();

        Thread.sleep(3000);
        System.out.println("--------");
        for (Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

}
