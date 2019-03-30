package com.example.demo.test.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO测试ConcurrentHashMap2是否线程安全
 * @author lenovo
 *
 */
public class ConcurrentHashMapTest2 {
	

	
	public static void main(String[] args) {
		
		  ExecutorService executorService = Executors.newCachedThreadPool();
		  
		  
        /** 全局ConcurrentHashMap*/
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();
        hashMap.put(0, 0);
 
        /** 多线程编辑100次*/
        for (int i = 0; i < 100; i++) {
            //new Thread(new EditThread(hashMap)).start();
            
        	executorService.execute( new Runnable() {
                @Override
                public void run() {
                	hashMap.put(0, hashMap.get(0) + 1);
                }
          });
        }
 
        /** 读取线程*/
       // new Thread(new ReadThread(hashMap)).start();
        
        executorService.execute( new Runnable() {
            @Override
            public void run() {
            	System.out.println("value " + hashMap.get(0));
            }
         });
        
        /** 输出最终结果*/
        System.out.println("Demo2 main value " + hashMap.get(0));
    }




}
