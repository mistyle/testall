package com.example.demo.test.juc;

import java.util.Map;

class EditThread  implements Runnable{
	
	Map<Integer, Integer> hashMap;
	 
    public EditThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }
 
    @Override
    public void run() {
        hashMap.put(0, hashMap.get(0) + 1);
    }



}
