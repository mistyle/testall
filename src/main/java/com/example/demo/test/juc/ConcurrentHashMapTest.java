package com.example.demo.test.juc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

/**
 *   测试ConcurrentHashMapTest,顺便测试sleep
 * @author lenovo
 *
 */
public class ConcurrentHashMapTest {


	
	static Map<Long, String> conMap = new HashMap<Long, String>(); //这里修改HashMap或者ConcurrentHashMap

    public static void main(String[] args) throws Exception {

        CountDownLatch startGate = new CountDownLatch(3);
        CountDownLatch endGate = new CountDownLatch(333);

        //map中放5个数
        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }
       //创建线程，里面放100
        Thread thread = new Thread(new Runnable() {
            public void run() {
                //startGate.await();
                conMap.put(100l, "100");
                System.out.println("写线程"+"ADD:" + 100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        //创建线程，里面放100
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                //startGate.await();
                conMap.put(101l, "101");
                System.out.println("ADDADD:" + 101);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        //创建第2个线程，循环去打印
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                for (Iterator<Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Entry<Long, String> entry = iterator.next();
                    System.out.println("读线程"+ entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        //thread2.start();
        thread3.start();

        startGate.countDown();

       Thread.sleep(3000); //如果不加sleep，最后的打印最先执行
        System.out.println("--------");
        for (Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println("最后打印"+entry.getKey() + " " + entry.getValue());
        }

    }

}

//ConcurrentHashMap
//       ADD:100
//        0 - 0
//        1 - 1
//        2 - 2
//        3 - 3
//        4 - 4
//        100 - 100
//        --------
//        最后打印0 0
//        最后打印1 1
//        最后打印2 2
//        最后打印3 3
//        最后打印4 4
//        最后打印100 100

/**
 * 注意多个线程，要先做到都start以后才能，才能run
 *
 * 如果是一个写线程，一个读线程，用HashMap仍然能做到同步，
 * 如果是两个写线程，一个读线程，用HashMap  非同步，
 * 如果是两个写线程，一个读线程，用ConcurrentHashMap能同步
 */

