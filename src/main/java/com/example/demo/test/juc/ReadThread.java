package com.example.demo.test.juc;

import java.util.Map;

class ReadThread implements Runnable {
	 
    Map<Integer, Integer> hashMap;
 
    public ReadThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }
 
    @Override
    public void run() {
        System.out.println("value " + hashMap.get(0));
    }
}
